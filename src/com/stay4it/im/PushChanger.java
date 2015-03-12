package com.stay4it.im;

import java.util.Observable;

import com.stay4it.im.db.MessageController;
import com.stay4it.im.entities.Message;

/** 
 * @author Stay  
 * @version create time：Mar 11, 2015 10:28:10 AM 
 */
public class PushChanger extends Observable {
	private static PushChanger mInstance;
	public static PushChanger getInstance(){
		if (mInstance == null) {
			mInstance = new PushChanger();
		}
		return mInstance;
	}
	
	public void notifyChanged(Message message) {
		MessageController.addOrUpdate(message);
		setChanged();
		notifyObservers(message);
	}
	
	
}
