package canvas_demo.liweijie.github.com.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

/**
 * @author liweijie
 * create on 2018/5/3.
 * email:liweijieok@qq.com
 * desc:
 * lastModify:
 */

public class CanvasTranslateActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new TranslateView(this));
  }
}

/**
 * 为了方便演示，暂时都用px
 */
class TranslateView extends View {
  private Paint mPaint;
  private static final String TAG = "TranslateView";
  public TranslateView(Context context) {
    super(context);
    mPaint = new Paint();
    mPaint.setTextSize(32);
    mPaint.setTextAlign(Paint.Align.CENTER);
    mPaint.setAntiAlias(true);
  }

  /**
   * 调用translate不影响canvas的高度+宽度
   * @param canvas
   */
  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    mPaint.setColor(Color.RED);
    //默认顶点0,0
    canvas.drawRect(new RectF(0, 0, 100, 100), mPaint);
    //把顶点往下移动100px,往右移动100px,
    Log.i(TAG, "canvas before translate width = "+canvas.getWidth());
    canvas.save();//保存一个状态
    canvas.translate(100, 100);
    Log.i(TAG, "canvas alter translate width = "+canvas.getWidth());
    mPaint.setColor(Color.BLACK);
    canvas.drawRect(new RectF(0, 0, 100, 100), mPaint);
    canvas.restore();//恢复，使得translate失效，重新定位顶点为0,0
    mPaint.setColor(Color.BLUE);
    canvas.drawRect(new RectF(100, 0, 200, 100), mPaint);

    //画尺子
    //画边框
    //空心矩形
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setColor(Color.GRAY);
    mPaint.setStrokeWidth(4);
    canvas.drawRect(new RectF(20, 600, getWidth() - 20, 900), mPaint);
    //开始画竖线
    //竖线宽4，一共10cm，一共101条线，一半高度60,(5,15)高度120,(0,10)高度200，
    float gap = (getWidth() - 40 - 60) / 100f;//这个就是每次画完的偏移量,其中-40是矩形总长，再减去40是他跟真实尺子之间的内间距
    canvas.save();
    canvas.translate(50, 0);
    for (int i = 0; i <= 100; i++) {
      if (i % 10 == 0) {
        canvas.drawLine(0, 900 - 160, 0, 900, mPaint);
        canvas.drawText("" + i / 10, 0, 900 - 180, mPaint);
      } else if (i % 5 == 0) {
        canvas.drawLine(0, 900 - 120, 0, 900, mPaint);
      } else {
        canvas.drawLine(0, 900 - 60, 0, 900, mPaint);
      }
      canvas.translate(gap, 0);
    }
    canvas.restore();
  }
}
