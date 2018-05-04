package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
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

/**
 * Rotate
 */
class RotateView extends View {
  private Paint mPaint;

  public RotateView(Context context) {
    super(context);
    mPaint = new Paint();
    mPaint.setTextSize(32);
    mPaint.setTextAlign(Paint.Align.CENTER);
    mPaint.setAntiAlias(true);
  }

  /**
   * rotate默认的旋转中心点是canvas的(0,0)点
   * rotate(float degrees) 他是最终实现旋转的方法
   *  rotate(float degrees, float px, float py) 他会得到一个以(px,py)进行旋转的方法，其实是先经过translate的结果。
   * @param canvas
   */
  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    canvas.save();
    mPaint.setColor(Color.RED);
    canvas.drawRect(new RectF(0, 0, 200, 200), mPaint);
    mPaint.setColor(Color.BLUE);
    //以(100,100)左边旋转45度
    canvas.rotate(45, 100, 100);
    canvas.drawRect(new RectF(0, 0, 200, 200), mPaint);
    canvas.restore();

    //画一个钟刻表
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(12);
    mPaint.setColor(Color.RED);
    int radius = (getWidth() - 30) / 2;
    float x = getWidth() / 2f;
    float y = getHeight() - getWidth() + getWidth() / 2f - 20;
    canvas.setDrawFilter(
        new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));
    canvas.drawCircle(x, y, radius, mPaint);
    //一格6度
    for (int i = 0; i <= 360; i += 6) {
      canvas.save();
      //找到旋转的中心点
      canvas.rotate(i, x, y);
      if (i % 10 == 0) {
        mPaint.setStrokeWidth(10);
        //画一个垂直线，延长线穿过圆心，改线是平行于垂直边框的，这样子再由rotate旋转就得到想要的结果了，下同。
        canvas.drawLine(getWidth() / 2, getHeight() - getWidth(), x, getHeight() - getWidth() + 60,
            mPaint);
      } else {
        mPaint.setStrokeWidth(8);
        canvas.drawLine(getWidth() / 2, getHeight() - getWidth(), x, getHeight() - getWidth() + 20,
            mPaint);
      }
      canvas.restore();
    }
  }
}
