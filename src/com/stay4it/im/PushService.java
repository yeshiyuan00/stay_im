package com.stay4it.im;

import com.stay4it.im.entities.Message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/** 
 * @author Stay  
 * @version create time：Mar 11, 2015 10:38:03 AM 
 */
public class PushService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Message message = (Message)intent.getSerializableExtra(Constants.KEY_MESSAGE);
		switch (message.getType()) {
		case plain:
			sendPlainMsg(message);
			break;
		case audio:
			break;
		case emo:
			break;
		case image:
			break;
		case location:
			break;

		default:
			break;
		}
		return super.onStartCommand(intent, flags, startId);
	}

	private void sendPlainMsg(Message message) {
		
	}

}
