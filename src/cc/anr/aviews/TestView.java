package cc.anr.aviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TestView extends View {

	public Canvas canvas;
	public Paint paint;
	private Bitmap bitmap;
	float x, y;
	int bgColor;

	public TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bgColor = Color.WHITE; // 设置背景颜色
		bitmap = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888); // 设置位图，线就画在位图上面，第一二个参数是位图宽和高
		canvas = new Canvas();
		canvas.setBitmap(bitmap);
		paint = new Paint(Paint.DITHER_FLAG);
		paint.setAntiAlias(true); // 设置抗锯齿，一般设为true
		paint.setColor(Color.RED); // 设置线的颜色
		paint.setStrokeCap(Paint.Cap.ROUND); // 设置线的类型
		paint.setStrokeWidth(8); // 设置线的宽度

	}

	// 触摸事件
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE) { // 拖动屏幕
			canvas.drawLine(x, y, event.getX(), event.getY(), paint); // 画线，x，y是上次的坐标，event.getX(),
			invalidate();
		}

		if (event.getAction() == MotionEvent.ACTION_DOWN) { // 按下屏幕
			x = event.getX();
			y = event.getY();
			canvas.drawPoint(x, y, paint); // 画点
			invalidate();
		}
		if (event.getAction() == MotionEvent.ACTION_UP) { // 松开屏幕
		}
		x = event.getX(); // 记录坐标
		y = event.getY();
		return true;
	}

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawBitmap(bitmap, 0, 0, null);
	}

}
