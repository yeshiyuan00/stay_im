package com.stay4it.im.junit;

import android.test.AndroidTestCase;

import com.stay4it.im.PushManager;
import com.stay4it.im.PushWatcher;
import com.stay4it.im.entities.Message;
import com.stay4it.im.utilities.Trace;

/** 
 * @author Stay  
 * @version create time：Mar 11, 2015 10:38:43 PM 
 */
public class ChatTest extends AndroidTestCase {
	public static final String SELFID = "Stay";
	public static final String TARGETID = "Will";
	
	PushWatcher watcher1 = new PushWatcher(){

		@Override
		public void messageUpdate(Message message) {
			Trace.d(message.toString());
		}
	};
	
	PushWatcher watcher2 = new PushWatcher();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		PushManager.getInstance(getContext()).addObserver(watcher1);
	}
	
	public void testSendMsg() throws Exception{
		Message message = Message.test("00001", SELFID, TARGETID);
		PushManager.getInstance(getContext()).sendMessage(message);
	}
	
	public void testReceiveMsg() throws Exception{
//		socket xmpp push sdk  string parse to message
		PushManager.getInstance(getContext()).handlePush("");
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		PushManager.getInstance(getContext()).removeObserver(watcher1);
	}
	
	
}
