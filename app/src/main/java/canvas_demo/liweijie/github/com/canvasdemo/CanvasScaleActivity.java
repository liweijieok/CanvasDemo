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
 * create on 2018/5/4.
 * email:liweijieok@qq.com
 * desc:
 * lastModify:
 */

public class CanvasScaleActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(new ScaleView(this));
  }
}

/**
 * Scale
 */
class ScaleView extends View {

  private Paint mPaint;
  private final static String TAG = "ScaleTag";

  public ScaleView(Context context) {
    super(context);
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
  }

  /**
   * 调用Scale方法前后，canvas的width+height变，即不影响Canvas的宽+高
   *
   * Scale方法其实是：先在原画布上画，画完之后进行缩放，有一种这样子的意味。
   *
   * 对于scale(float sx, float sy) 他是去进行缩放操作的真实方法
   *    scale(float sx, float sy, float px, float py) 他间距调用了上面的方法，调用之前先进行了translate(px,py),缩放完成，在translate回去
   *    其中px,py是缩放的之后的偏移量，他会去改变canvas的原点(0,0)的位置，这点需要注意的。
   * @param canvas
   */
  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Log.i(TAG, "canvas before scale width = "+canvas.getWidth());
    mPaint.setColor(Color.BLUE);
    canvas.drawRect(new RectF(0,0,getWidth(),getHeight()),mPaint );
    canvas.save();
    //没有制定以那点为中心进行缩放
    canvas.scale(0.5f,0.5f);
    mPaint.setColor(Color.RED);
    canvas.drawRect(new RectF(0,0,getWidth(),getHeight()),mPaint );
    Log.i(TAG,"canvas after scale width = "+canvas.getWidth());
    canvas.restore();

    canvas.save();
    canvas.scale(0.5f,0.5f,300f,300f);
    mPaint.setColor(Color.GREEN);
    canvas.drawRect(new RectF(0,0,getWidth(),getHeight()),mPaint );
    canvas.restore();

  }
}
