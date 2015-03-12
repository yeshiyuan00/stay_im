package com.stay4it.im.db;

import java.sql.SQLException;
import java.util.ArrayList;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.stay4it.im.entities.Message;

/**
 * @author Stay
 * @version create time：Oct 23, 2014 10:45:30 AM
 */
public class MessageController {
	public static Dao<Message, String> getDao() throws SQLException {
		return DBController.getInstance().getDB().getDao(Message.class);
	}

	public static void addOrUpdate(Message message) {
		try {
			getDao().createOrUpdate(message);
			ConversationController.syncMessage(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Message message) {
		try {
			getDao().delete(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Message> queryAllByTimeAsc(String id1, String id2) {
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			QueryBuilder<Message, String> queryBuilder = getDao().queryBuilder();
			queryBuilder.orderBy(Message.TIMESTAMP, true);
			Where<Message, String> where = queryBuilder.where();
			where.in(Message.SENDERID, id1, id2);
			where.and();
			where.in(Message.RECEIVERID, id1, id2);
			// (senderid=id1 and receiverid=id2) or (senderid=id2 and
			// receiverid=id1)
			// "where senderid in(id1,id2) and receiverid in(id1,id2) order by timestamp desc";
			messages = (ArrayList<Message>) getDao().query(queryBuilder.prepare());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}
}
