package com.stay4it.im.entities;

import com.stay4it.im.entities.Message.MessageType;
import com.stay4it.im.entities.Message.StatusType;

/** 
 * @author Stay  
 * @version create time：Mar 9, 2015 5:40:32 PM 
 */
public class Conversation {
	private String messageId;
	private String content;
	private MessageType type;
	private String targetId;
	private int unreadNum;
	private StatusType status;
	private long timestamp;
}
