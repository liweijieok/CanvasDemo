package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author liweijie
 * create on 2018/5/16.
 * email:liweijie@qq.com
 * desc:
 * lastModify:
 */

public class CanvasClipActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new ClipView(this));
  }
}

class ClipView extends View{
  private Paint mPaint;

  public ClipView(Context context) {
    super(context);
    mPaint = new Paint();
  }
}
