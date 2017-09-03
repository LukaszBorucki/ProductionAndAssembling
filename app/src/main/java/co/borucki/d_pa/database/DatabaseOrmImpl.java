package co.borucki.d_pa.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import co.borucki.d_pa.model.Machine;
import co.borucki.d_pa.model.MachineUsage;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.model.ProductionOrder;
import co.borucki.d_pa.model.ProductionOrderHistory;
import co.borucki.d_pa.model.ProductionOrderRealization;
import co.borucki.d_pa.model.Product;
import co.borucki.d_pa.model.User;

public class DatabaseOrmImpl extends OrmLiteSqliteOpenHelper implements Database {

    private static final String DATABASE_NAME = "DPA";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<User, Integer> mUserDao;
    private RuntimeExceptionDao<Message, Integer> mMessageDao;
    private RuntimeExceptionDao<Product, Integer> mProductDao;
    private RuntimeExceptionDao<ProductionOrder, Integer> mProductionOrderDao;
    private RuntimeExceptionDao<ProductionOrderHistory, Integer> mProductionOrderHistoryDao;
    private RuntimeExceptionDao<ProductionOrderRealization, Integer> mProductionOrderRealizationDao;
    private RuntimeExceptionDao<Machine, Integer> mMachineDao;
    private RuntimeExceptionDao<MachineUsage, Integer> mMachineUsageDao;

    public DatabaseOrmImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mUserDao = getRuntimeExceptionDao(User.class);
        mMessageDao = getRuntimeExceptionDao(Message.class);
        mProductDao = getRuntimeExceptionDao(Product.class);
        mProductionOrderDao = getRuntimeExceptionDao(ProductionOrder.class);
        mProductionOrderHistoryDao = getRuntimeExceptionDao(ProductionOrderHistory.class);
        mProductionOrderRealizationDao = getRuntimeExceptionDao(ProductionOrderRealization.class);
        mMachineDao = getRuntimeExceptionDao(Machine.class);
        mMachineUsageDao = getRuntimeExceptionDao(MachineUsage.class);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Message.class);
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductionOrder.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductionOrderHistory.class);
            TableUtils.createTableIfNotExists(connectionSource, ProductionOrderRealization.class);
            TableUtils.createTableIfNotExists(connectionSource, Machine.class);
            TableUtils.createTableIfNotExists(connectionSource, MachineUsage.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    @Override
    public List<User> getAllUser() {
        return mUserDao.queryForAll();
    }

    @Override
    public void saveUser(User user) {
        mUserDao.createOrUpdate(user);
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
    public void saveMessage(List<Message> messages) {
        for (Message message : messages) {
            mMessageDao.createOrUpdate(message);
        }

    }

    @Override
    public void saveMessage(Message message) {
        mMessageDao.createOrUpdate(message);
    }

    @Override
    public List<Message> getAllMessage() {
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
    public List<Message> getUnreadMessage() {
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
        if (firstResult[0] == null || firstResult.length == 0) {
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

    @Override
    public void saveMachine(List<Machine> machines) {
        for (Machine machine : machines) {

            mMachineDao.createOrUpdate(machine);
        }
    }

    @Override
    public void saveMachine(Machine machine) {
        mMachineDao.createOrUpdate(machine);
    }

    @Override
    public void saveMachineUsage(List<MachineUsage> machineUsages) {
        for (MachineUsage machineUsage : machineUsages) {
            mMachineUsageDao.createOrUpdate(machineUsage);
        }

    }

    @Override
    public void saveMachineUsage(MachineUsage machineUsage) {
        mMachineUsageDao.createOrUpdate(machineUsage);
    }

    @Override
    public void saveProduct(List<Product> products) {
        for (Product product : products) {
            mProductDao.createOrUpdate(product);
        }
    }

    @Override
    public void saveProduct(Product product) {
        mProductDao.createOrUpdate(product);
    }

    @Override
    public void saveProductionOrder(List<ProductionOrder> productionOrders) {
        for (ProductionOrder productionOrder : productionOrders) {
            mProductionOrderDao.createOrUpdate(productionOrder);

        }
    }

    @Override
    public void saveProductionOrder(ProductionOrder productionOrder) {
        mProductionOrderDao.createOrUpdate(productionOrder);
    }

    @Override
    public void saveProductionOrderHistory(List<ProductionOrderHistory> productionOrderHistories) {
        for (ProductionOrderHistory productionOrderHistory : productionOrderHistories) {
            mProductionOrderHistoryDao.createOrUpdate(productionOrderHistory);
        }
    }

    @Override
    public void saveProductionOrderHistory(ProductionOrderHistory productionOrderHistory) {
        mProductionOrderHistoryDao.createOrUpdate(productionOrderHistory);
    }

    @Override
    public void saveProductionOrderRealization(List<ProductionOrderRealization> productionOrderRealizations) {
        for (ProductionOrderRealization productionOrderRealization : productionOrderRealizations) {
            mProductionOrderRealizationDao.createOrUpdate(productionOrderRealization);

        }
    }

    @Override
    public void saveProductionOrderRealization(ProductionOrderRealization productionOrderRealization) {
        mProductionOrderRealizationDao.createOrUpdate(productionOrderRealization);
    }

    @Override
    public List<Machine> getMachine() {
        return mMachineDao.queryForAll();
    }

    @Override
    public Machine getMachineById(String id) {
        QueryBuilder<Machine, Integer> query = mMachineDao.queryBuilder();
        Where where = query.where();
        try {
            where.eq("id", id);
            return query.queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
