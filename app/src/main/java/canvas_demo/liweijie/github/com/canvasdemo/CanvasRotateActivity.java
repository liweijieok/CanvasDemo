package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author liweijie
 * create on 2018/5/4.
 * email:liweijieok@qq.com
 * desc:
 * lastModify:
 */

public class CanvasRotateActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new RotateView(this));
  }
}

class RotateView extends View{
  private Paint mPaint;
  public RotateView(Context context) {
    super(context);
    mPaint = new Paint();
    mPaint.setTextSize(32);
    mPaint.setTextAlign(Paint.Align.CENTER);
    mPaint.setAntiAlias(true);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    canvas.save();
    canvas.rotate(45);
    mPaint.setColor(Color.RED);
    canvas.drawRect(new RectF(200,0,400,200),mPaint );
    mPaint.setColor(Color.BLUE);
    canvas.drawText("Text",400,0,mPaint);
    canvas.restore();
  }
}
