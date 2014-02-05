package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called

	private int mCreate, mStart, mResume, mRestart;

	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	private TextView mTvCreate, mTvStart, mTvResume, mTvRestart;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		this.
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate  = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
	    mTvResume = (TextView) findViewById(R.id.resume);
	    mTvRestart = (TextView) findViewById(R.id.restart);

	    Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method
				
				// Create an intent stating which Activity you would like to start
				Intent intent = new Intent(getBaseContext(), ActivityTwo.class);
				
				// Launch the Activity using the intent
				startActivity(intent);
			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {
			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);		
		}

		// TODO: Emit LogCat message
		Log.i(TAG, "The activity is about to be created.");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();
	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		Log.i(TAG, "The activity is visible and about to be started.");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		Log.i(TAG, "The activity is and has focus (it is now \"resumed\")");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mResume++;
		displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.i(TAG, "Another activity is taking focus (this activity is about to be \"paused\")");
	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG, "The activity is no longer visible (it is now \"stopped\")");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.i(TAG, "The activity is visible and about to be restarted.");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG, "The activity is about to be destroyed.");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
	}
	
	// Updates the displayed counters
	public void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	}
}
