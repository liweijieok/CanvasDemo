package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author liweijie
 * create on 2018/5/16.
 * email:liweijie@qq.com
 * desc: 错切
 * lastModify:
 */

public class CanvasSkewActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new SkewView(this));
  }
}

class SkewView extends View {

  private Paint mPaint;
  public SkewView(Context context) {
    super(context);
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setStyle(Paint.Style.FILL);
  }

  /**
   * 对于skew(x,y),x,y,是对应x轴y轴的倾斜值，其中,x = tan a,y = tan b,a和b就是我们需要倾斜的角度，x正方向是向左，y正反向是向下。
   * @param canvas
   */
  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    mPaint.setColor(Color.RED);
    canvas.drawRect(200, 200, 400, 400, mPaint);
    canvas.save();
    canvas.skew(1,0);//画布向左倾斜45度tab 45 = 1
    mPaint.setColor(Color.GRAY);
    //倾斜之后
    canvas.drawRect(200, 200, 400, 400, mPaint);
    canvas.restore();
  }
}