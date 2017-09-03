package co.borucki.d_pa.database;

import java.util.List;

import co.borucki.d_pa.model.Machine;
import co.borucki.d_pa.model.MachineUsage;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.model.Product;
import co.borucki.d_pa.model.ProductionOrder;
import co.borucki.d_pa.model.ProductionOrderHistory;
import co.borucki.d_pa.model.ProductionOrderRealization;
import co.borucki.d_pa.model.User;

public interface Database {
    List<User> getAllUser();

    Integer countUsers();

    void saveUser(User user);

    User getUserById(String id);

    void updateUser(User user);

    void saveMessage(List<Message> messages);

    void saveMessage(Message message);

    List<Message> getAllMessage();

    List<Message> getUnreadMessage();

    int getLastIndexOfMessage();

    void updateMessage(Message message);

    Message getMessageById(int messageId);

    void deleteMessage(Message message);

    void saveMachine(List<Machine> machines);

    void saveMachine(Machine machine);

    void saveMachineUsage(List<MachineUsage> machineUsages);

    void saveMachineUsage(MachineUsage machineUsage);

    void saveProduct(List<Product> products);

    void saveProduct(Product product);

    void saveProductionOrder(List<ProductionOrder> productionOrders);

    void saveProductionOrder(ProductionOrder productionOrder);

    void saveProductionOrderHistory(List<ProductionOrderHistory> productionOrderHistories);

    void saveProductionOrderHistory(ProductionOrderHistory productionOrderHistory);

    void saveProductionOrderRealization(List<ProductionOrderRealization> productionOrderRealizations);

    void saveProductionOrderRealization(ProductionOrderRealization productionOrderRealization);

    List<Machine> getMachine();

    Machine getMachineById(String id);

    List<MachineUsage> getMachineUsageByMachineId(String id);

}
