package com.stay4it.im;

import android.content.Context;
import android.content.Intent;

import com.stay4it.im.entities.Message;

/**
 * @author Stay
 * @version create time：Mar 11, 2015 10:29:12 AM
 */
public class PushManager {
	private static PushManager mInstance;
	public Context context;
	
	public PushManager(Context context) {
		this.context = context;
	}

	public static PushManager getInstance(Context context){
		if (mInstance == null) {
			mInstance = new PushManager(context);
		}
		return mInstance;
	}
	
	public void handlePush(String content) {
//		TODO parse content to Message/Notice
		Message message = new Message();
		PushChanger.getInstance().notifyChanged(message);
	}
	
	public void sendMessage(Message message){
		Intent service = new Intent(context, PushService.class);
		service.putExtra(Constants.KEY_MESSAGE, message);
		context.startService(service);
	}
	
	public void addObserver(PushWatcher watcher){
		PushChanger.getInstance().addObserver(watcher);
	}
	
	public void removeObserver(PushWatcher watcher){
		PushChanger.getInstance().deleteObserver(watcher);
	}
	
	public void removeObservers(){
		PushChanger.getInstance().deleteObservers();
	}
	
	
	
}
