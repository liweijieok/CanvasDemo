package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
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

public class CanvasSaveAndRestoreActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new SaveAndRestoreView((this)));
  }
}

class SaveAndRestoreView extends View{

  private Paint mPaint;

  public SaveAndRestoreView(Context context) {
    super(context);
    mPaint = new Paint();
  }

  /**
   * 一般而言，save+restore是成对出现的，save()用于保留现场，restore则是还原。
   * @param canvas
   */
  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

  }
}
