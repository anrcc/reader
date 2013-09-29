package cc.anr;

import cc.anr.aviews.ReadingBoard;
import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class ReadingBoardActivity extends Activity {

	
	ReadingBoard readingBoard;
	private GestureDetector mGestureDetector;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading_board);
		readingBoard=(ReadingBoard)findViewById(R.id.readingBoard);
		mGestureDetector=new GestureDetector(this, new ReadingGestureListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reading_board, menu);
		return true;
	}

	
	
	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(mGestureDetector!=null){
			return mGestureDetector.onTouchEvent(event);
		}else{
			return super.onTouchEvent(event);
		}
	}






	class ReadingGestureListener extends SimpleOnGestureListener{

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,float distanceX, float distanceY) {
			return super.onScroll(e1, e2, distanceX, distanceY);
		}
		
	}
}
