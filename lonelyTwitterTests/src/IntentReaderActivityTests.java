
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import android.test.ViewAsserts;


@SuppressLint("NewApi")
public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	public IntentReaderActivityTests()
	{
		super(IntentReaderActivity.class);
	}

	public void testSendtext(){
		Intent i = new Intent();
		String text = "hello";
		i.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(i);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivty should get text from intent", 
				text, activity.getText());	
	}
	
	public void testDoubleText(){
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("Intent reader should double text", "hellohello", activity.transformText(text));
		
	}
	
	public void testDisplayText(){
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("text should be displayed", text, textView.getText().toString());
		
	}
	
	public void testReverseText(){
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("text should be reversed", "olleh", activity.transformText(text));
		
	}
	
	public void testDefaultText(){
		Intent intent = new Intent();		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("getText should be null", null, activity.getText());
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("Should display default text", "default_text", textView.getText().toString());
	}
	
	public void testTextVisible(){
		Intent intent = new Intent();
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		TextView textView = (TextView)activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), textView);
	}
	
	
}
