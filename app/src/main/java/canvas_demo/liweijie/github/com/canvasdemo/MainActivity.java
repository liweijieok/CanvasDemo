package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void translate(View view) {
    startActivity(new Intent(this, CanvasTranslateActivity.class));
  }

  public void scale(View view) {
    startActivity(new Intent(this, CanvasScaleActivity.class));
  }

  public void rotate(View view) {
    startActivity(new Intent(this, CanvasRotateActivity.class));
  }

  public void skew(View view) {
    startActivity(new Intent(this, CanvasSkewActivity.class));
  }

  public void clip(View view) {
    startActivity(new Intent(this, CanvasClipActivity.class));
  }

  public void saveAndRestore(View view) {
    startActivity(new Intent(this, CanvasSaveAndRestoreActivity.class));
  }

  public void draw(View view) {

  }
}
