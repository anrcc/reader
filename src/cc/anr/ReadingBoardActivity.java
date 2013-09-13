package cc.anr;

import cc.anr.aviews.ReadingBoard;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadingBoardActivity extends Activity {

	
	ReadingBoard readingBoard;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading_board);
		readingBoard=(ReadingBoard)findViewById(R.id.readingBoard);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reading_board, menu);
		return true;
	}

}
