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

  }

  public void clip(View view) {

  }

  public void rotate(View view) {

  }

  public void saveAndRestore(View view) {

  }

  public void draw(View view) {

  }
}