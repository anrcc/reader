package cc.anr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cc.anr.aviews.FloatImageText;

public class MainActivity extends Activity {

	private GestureDetector gestureDetector;
	TextView mainText;
	FloatImageText floatImageText;
	
	Button inReadingActivityBut;
	Button inGameBut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		
		gestureDetector=new GestureDetector(this, new LearnGestureListener());
		setContentView(R.layout.activity_main);
		mainText=(TextView) findViewById(R.id.mainText);
		inReadingActivityBut=(Button)findViewById(R.id.inReadingActivityBut);
		inGameBut=(Button)findViewById(R.id.inGameBut);
		floatImageText=(FloatImageText) findViewById(R.id.floatImageText);
		
		Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
		
		floatImageText.setText("味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味味");
		floatImageText.setImageBitmap(bitmap, 200, 10);
	
		inReadingActivityBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in=new Intent();
				in.setClass(getApplicationContext(), ReadingBoardActivity.class);
				startActivity(in);
			}
		});
		inGameBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in=new Intent();
				in.setClass(getApplicationContext(), GameActivity.class);
				startActivity(in);
			}
		});
	}

	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		   if(gestureDetector.onTouchEvent(event)){
			  return true;
		   }else{
			  return false;
		   }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	class LearnGestureListener implements GestureDetector.OnGestureListener{

		
		@Override
		public boolean onDown(MotionEvent e) {
			System.out.println("onDown="+e.getAction());
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) {
			System.out.println(" onFling e1="+e1.getAction()+"e2="+e1.getAction() +" x="+velocityX+" y="+velocityY);
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			System.out.println("onLongPress="+e.getAction());
			
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,float distanceX, float distanceY) {
			System.out.println(" onScroll e1="+e1.getAction()+"e2="+e1.getAction() +" x="+distanceX+" y="+distanceY);
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			System.out.println("onShowPress="+e.getAction());
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			System.out.println("onSingleTapUp="+e.getAction());
			return false;
		}
		
	}
	
	
	
	
}
