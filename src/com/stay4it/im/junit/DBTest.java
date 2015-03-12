package com.stay4it.im.junit;

import java.util.ArrayList;

import com.stay4it.im.IMApplication;
import com.stay4it.im.PushChanger;
import com.stay4it.im.PushManager;
import com.stay4it.im.PushWatcher;
import com.stay4it.im.db.ConversationController;
import com.stay4it.im.db.MessageController;
import com.stay4it.im.entities.Conversation;
import com.stay4it.im.entities.Message;
import com.stay4it.im.entities.Message.StatusType;
import com.stay4it.im.utilities.Trace;

import android.test.AndroidTestCase;

/**
 * @author Stay
 * @version create time：Mar 12, 2015 2:25:42 PM
 */
public class DBTest extends AndroidTestCase {
	public static final String SELFID = "Stay";
	public static final String TARGETID = "Will";
	public static final String OTHERID = "Other";
	PushWatcher watcher = new PushWatcher() {

		@Override
		public void messageUpdate(Message message) {
			if (message.getSenderId().equals(SELFID)) {
				Trace.d("i sent a message to " + message.getReceiverId());
			} else {

				if (message.getSenderId().equals(TARGETID)) {
					// show on list
					Trace.d("new message sent by " + message.getSenderId());
				} else {
					Trace.d("new message sent by others");
				}
			}
		}
	};
	PushWatcher conversationWatcher = new PushWatcher() {

		@Override
		public void messageUpdate(Message message) {
			updateConversation();
		}
	};

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// 
		// PushManager.getInstance(getContext()).addObserver(conversationWatcher);
		IMApplication.gContext = getContext();
	}

	protected void updateConversation() {
		ArrayList<Conversation> conversations = ConversationController.queryAllByTimeDesc();
		if (conversations != null && conversations.size() > 0) {
			for (Conversation conversation : conversations) {
				Trace.d(conversation.toString());
			}
		}
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// 
		// PushManager.getInstance(getContext()).removeObserver(conversationWatcher);
	}

	public void testChat() throws Exception {
		PushManager.getInstance(getContext()).addObserver(watcher);
		// TODO query db
		ArrayList<Message> messages = MessageController.queryAllByTimeAsc(SELFID, TARGETID);
		if (messages != null && messages.size() > 0) {
			for (Message message : messages) {
				Trace.d(message.toString());
			}
		}
		// TODO new message
		Message message = Message.test("00003", OTHERID, ChatTest.SELFID);
		PushManager.getInstance(getContext()).handlePush(message);
		// TODO notify
		PushManager.getInstance(getContext()).removeObserver(watcher);
	}

	public void testConversation() throws Exception {
		PushManager.getInstance(getContext()).addObserver(conversationWatcher);
		updateConversation();

		Message message = Message.test("00002", OTHERID, ChatTest.SELFID);
		PushManager.getInstance(getContext()).handlePush(message);
		PushManager.getInstance(getContext()).removeObserver(conversationWatcher);
	}

	public void testBack() throws Exception {
		PushManager.getInstance(getContext()).addObserver(watcher);
		ArrayList<Message> messages = MessageController.queryAllByTimeAsc(SELFID, OTHERID);
		if (messages != null && messages.size() > 0) {
			for (Message message : messages) {
				Trace.d(message.toString());
			}
		}

		Message message = Message.test("00001", SELFID, OTHERID);
		message.setStatus(StatusType.ing);
		PushChanger.getInstance().notifyChanged(message);
		PushManager.getInstance(getContext()).removeObserver(watcher);
		
		ConversationController.markAsRead(OTHERID);
		
		PushManager.getInstance(getContext()).addObserver(conversationWatcher);
		updateConversation();

		message.setStatus(StatusType.done);
		PushChanger.getInstance().notifyChanged(message);

		PushManager.getInstance(getContext()).removeObserver(conversationWatcher);

	}

}
