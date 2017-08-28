package co.borucki.d_pa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import co.borucki.d_pa.model.User;

public class DatabaseOrmImpl extends OrmLiteSqliteOpenHelper implements Database {

    private static final String DATABASE_NAME = "DPA";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<User, Integer> mUserDao;

    public DatabaseOrmImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mUserDao = getRuntimeExceptionDao(User.class);
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
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }


}
