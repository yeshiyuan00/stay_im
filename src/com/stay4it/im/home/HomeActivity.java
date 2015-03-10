package com.stay4it.im.home;

import com.stay4it.im.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/** 
 * @author Stay  
 * @version create time：Mar 10, 2015 5:31:42 PM 
 */
public class HomeActivity extends Activity implements OnClickListener {
	private Button mHomeConversationBtn;
	private Button mHomeContactBtn;
	private Button mHomeProfileBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		mHomeConversationBtn = (Button)findViewById(R.id.mHomeConversationBtn);
		mHomeContactBtn = (Button)findViewById(R.id.mHomeContactBtn);
		mHomeProfileBtn = (Button)findViewById(R.id.mHomeProfileBtn);
		mHomeConversationBtn.setOnClickListener(this);
		mHomeContactBtn.setOnClickListener(this);
		mHomeProfileBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mHomeConversationBtn:
//			TODO 
			break;
		case R.id.mHomeContactBtn:
			
			break;
		case R.id.mHomeProfileBtn:
			
			break;

		default:
			break;
		}
	}
	
	
}
