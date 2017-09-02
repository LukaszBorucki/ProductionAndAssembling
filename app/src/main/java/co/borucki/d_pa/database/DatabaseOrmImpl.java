package co.borucki.d_pa.database;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.query.OrderBy;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.model.User;

import static android.R.attr.id;

public class DatabaseOrmImpl extends OrmLiteSqliteOpenHelper implements Database {

    private static final String DATABASE_NAME = "DPA";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<User, Integer> mUserDao;
    private RuntimeExceptionDao<Message, Integer> mMessageDao;

    public DatabaseOrmImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mUserDao = getRuntimeExceptionDao(User.class);
        mMessageDao = getRuntimeExceptionDao(Message.class);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Message.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    @Override
    public List<User> getAllUsers() {
        return mUserDao.queryForAll();
    }

    @Override
    public void saveUser(User user) {
        mUserDao.createIfNotExists(user);
    }

    @Override
    public User getUserById(String id) {
        try {
            QueryBuilder<User, Integer> query = mUserDao.queryBuilder();
            Where where = query.where();
            where.eq("login", id);

            return query.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        mUserDao.update(user);
    }

    @Override
    public Integer countUsers() {
        return (int) mUserDao.countOf();
    }

    @Override
    public void saveMessages(List<Message> messages) {
        for (Message message : messages) {
            mMessageDao.createIfNotExists(message);
        }

    }

    @Override
    public void saveMessage(Message message) {
        mMessageDao.createIfNotExists(message);
    }

    @Override
    public List<Message> getAllMessages() {
        QueryBuilder<Message, Integer> qb = mMessageDao.queryBuilder();
        try {
            return qb.orderBy("id", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

return null;
//        return mMessageDao.queryForAll();

    }

    @Override
    public List<Message> getUnreadMessages() {
        QueryBuilder<Message, Integer> qb = mMessageDao.queryBuilder();
        Where where = qb.where();
        try {
            where.eq("isRead", false);
qb.orderBy("id", false);
            return qb.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
//        return mMessageDao.queryForAll();


    }

    @Override
    public int getLastIndexOfMessage() {
        String[] firstResult = new String[0];
        try {
            QueryBuilder<Message, Integer> query = mMessageDao.queryBuilder().selectRaw("max(id)");
            GenericRawResults<String[]> result = mMessageDao.queryRaw(query.prepareStatementString());
            firstResult = result.getFirstResult();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (firstResult[0] == null||firstResult.length==0) {
            return 0;
        }


        return Integer.parseInt(firstResult[0]);
    }

    @Override
    public void updateMessage(Message message) {
        mMessageDao.update(message);
    }

    @Override
    public Message getMessageById(int messageId) {
        try {
            QueryBuilder<Message, Integer> query = mMessageDao.queryBuilder();
            Where where = query.where();
            where.eq("id", messageId);

            return query.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteMessage(Message message) {
        mMessageDao.delete(message);
    }
}
