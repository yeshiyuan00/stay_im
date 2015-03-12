package com.stay4it.im.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.stay4it.im.entities.Message.MessageType;
import com.stay4it.im.entities.Message.StatusType;

/** 
 * @author Stay  
 * @version create time：Mar 9, 2015 5:40:32 PM 
 */
@DatabaseTable(tableName="conversation")
public class Conversation {
	public static final String TIMESTAMP = "timestamp";
	public static final String UNREADNUM = "unreadNum";
	public static final String TARGETID = "targetId";
	@DatabaseField(id=true)
	private String targetId;
	@DatabaseField
	private String content;
	@DatabaseField
	private MessageType type;
	@DatabaseField
	private int unreadNum;
	@DatabaseField
	private StatusType status;
	@DatabaseField
	private long timestamp;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public int getUnreadNum() {
		return unreadNum;
	}
	public void setUnreadNum(int unreadNum) {
		this.unreadNum = unreadNum;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return targetId + " msg " + content +" unread "+ unreadNum + " status: " + status;
	}
}
