package cc.anr.aviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View implements Runnable {

	public final static String TAG = "Example_05_03_GameView";
	// 声明Paint对象
	private Paint mPaint = null;

	public GameView(Context context) {
		super(context);
		// 构建对象
		mPaint = new Paint();

		// 开启线程
		//new Thread(this).start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 设置Paint为无锯齿
		mPaint.setAntiAlias(true);

		// 设置Paint的颜色
		mPaint.setColor(Color.RED);
		mPaint.setColor(Color.BLUE);
		mPaint.setColor(Color.YELLOW);
		mPaint.setColor(Color.GREEN);
		// 同样是设置颜色
		mPaint.setColor(Color.rgb(255, 0, 0));

		// 提取颜色
		Color.red(0xcccccc);
		Color.green(0xcccccc);

		// 设置paint的颜色和Alpha值(a,r,g,b)
		mPaint.setAlpha(220);

		// 这里可以设置为另外一个paint对象
		// mPaint.set(new Paint());
		// 设置字体的尺寸
		mPaint.setTextSize(20);

		// 设置paint的风格为“空心”
		// 当然也可以设置为"实心"(Paint.Style.FILL)
		mPaint.setStyle(Paint.Style.STROKE);

		// 设置“空心”的外框的宽度
		mPaint.setStrokeWidth(5);

		// 得到Paint的一些属性 颜色、Alpha值、外框的宽度、字体尺寸
		Log.i("TAG", "paint Color------>" + mPaint.getColor());
		Log.i(TAG, "paint Alpha------->" + mPaint.getAlpha());
		Log.i("TAG", "paint StrokeWidth--------->" + mPaint.getStrokeWidth());
		Log.i("TAG", "paint TextSize----------->" + mPaint.getTextSize());

		// 绘制一空心个矩形
		canvas.drawRect((320 - 80), 20, (320 - 80) / 2 + 80, 20 + 40, mPaint);

		// 设置风格为实心
		mPaint.setStyle(Paint.Style.FILL);

		mPaint.setColor(Color.GREEN);

		
		// 绘制绿色实心矩形
		canvas.drawRect(0, 20, 40, 20 + 40, mPaint);
		
		mPaint.setTextSize(20);
	//	canvas.drawText("你么么么么么么么么", 20, 40, mPaint);
		
		
		//===============================时种====================
		
		mPaint.setAntiAlias(true);
	    mPaint.setStyle(Style.STROKE);
	    canvas.translate(canvas.getWidth()/2, 200); //将位置移动画纸的坐标点:150,150
	    canvas.drawCircle(0, 0, 100, mPaint); //画圆圈
	 
	    //使用path绘制路径文字
	    canvas.save();
	    canvas.translate(-75, -75);
	    Path path = new Path();
	    path.addArc(new RectF(0,0,150,150), -180, 180);
	    Paint citePaint = new Paint(mPaint);
	    citePaint.setTextSize(14);
	    citePaint.setStrokeWidth(1);
	    canvas.drawTextOnPath("http://www.android777.com", path, 28, 0, citePaint);
	    canvas.restore();
	 
	    Paint tmpPaint = new Paint(mPaint); //小刻度画笔对象
	    tmpPaint.setStrokeWidth(1);
	 
	    float  y=100;
	    int count = 60; //总刻度数
	 
	    for(int i=0 ; i <count ; i++){
	        if(i%5 == 0){
	            canvas.drawLine(0f, y, 0, y+12f, mPaint);
	            canvas.drawText(String.valueOf(i/5+1), -4f, y+25f, tmpPaint);
	 
	        }else{
	            canvas.drawLine(0f, y, 0f, y +5f, tmpPaint);
	        }
	        canvas.rotate(360/count,0f,0f); //旋转画纸
	    }
	 
	    //绘制指针
	    tmpPaint.setColor(Color.GRAY);
	    tmpPaint.setStrokeWidth(4);
	    canvas.drawCircle(0, 0, 7, tmpPaint);
	    tmpPaint.setStyle(Style.FILL);
	    tmpPaint.setColor(Color.YELLOW);
	    canvas.drawCircle(0, 0, 5, tmpPaint);
	    canvas.drawLine(0, 10, 0, -65, mPaint);
		
	}

	// 触笔事件
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

	// 按键按下事件
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return true;
	}

	// 按键弹起事件
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		return true;
	}

	public boolean onKeyMultiple(int KeyCode, int repeatCount, KeyEvent event) {
		return true;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
			// 更新界面
			postInvalidate();
		}
	}
}