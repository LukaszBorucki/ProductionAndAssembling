package co.borucki.d_pa.DTO.mappers;

import java.util.ArrayList;
import java.util.List;

import co.borucki.d_pa.DTO.MachinesDTO;
import co.borucki.d_pa.DTO.MachineUsageDTO;
import co.borucki.d_pa.DTO.MessageDTO;
import co.borucki.d_pa.DTO.ProductionOrderDTO;
import co.borucki.d_pa.DTO.ProductionOrderHistoryDTO;
import co.borucki.d_pa.DTO.ProductionOrderRealizationDTO;
import co.borucki.d_pa.DTO.ProductDTO;
import co.borucki.d_pa.DTO.UserDTO;
import co.borucki.d_pa.model.Machine;
import co.borucki.d_pa.model.MachineUsage;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.model.ProductionOrderRealization;
import co.borucki.d_pa.model.ProductionOrder;
import co.borucki.d_pa.model.ProductionOrderHistory;
import co.borucki.d_pa.model.Product;
import co.borucki.d_pa.model.User;

public class Mapper {
    public static User fromUserDTOToUser(UserDTO userDTO) {
        return new User(
                userDTO.getLogin()
                , userDTO.getName()
                , userDTO.getSurname()
                , userDTO.getAssembling()
                , userDTO.getId()
                , userDTO.getOrderAssembling()
                , userDTO.getActive()
                , userDTO.getLevel()
                , userDTO.getTurned()
                , "password");
    }

    public static List<User> fromUserDTOToUser(List<UserDTO> userDTOs) {
        List<User> userList = new ArrayList<>();
        for (UserDTO userDTO : userDTOs) {
            userList.add(new User(
                    userDTO.getLogin()
                    , userDTO.getName()
                    , userDTO.getSurname()
                    , userDTO.getAssembling()
                    , userDTO.getId()
                    , userDTO.getOrderAssembling()
                    , userDTO.getActive()
                    , userDTO.getLevel()
                    , userDTO.getTurned()
                    , "password"));
        }
        return userList;
    }

    public static Message fromMessageDTOToMessage(MessageDTO messageDTO) {

        return new Message(messageDTO.getId(),
                messageDTO.getDate(),
                messageDTO.getUserId(),
                messageDTO.getContents(), messageDTO.isRead() != 0);
    }

    public static List<Message> fromMessageDTOToMessage(List<MessageDTO> messageDTOs) {
        List<Message> messageList = new ArrayList<>();
        for (MessageDTO messageDTO : messageDTOs) {
            messageList.add(new Message(messageDTO.getId(),
                    messageDTO.getDate(),
                    messageDTO.getUserId(),
                    messageDTO.getContents(), messageDTO.isRead() != 0));
        }
        return messageList;
    }


    public static List<ProductionOrder> fromProductionOrderDTOToProductionOrder(List<ProductionOrderDTO> productionOrderDTOs) {
        List<ProductionOrder> productionOrderList = new ArrayList<>();
        for (ProductionOrderDTO productionOrderDTO : productionOrderDTOs) {
            productionOrderList.add(new ProductionOrder(productionOrderDTO.getIdOrderTurning()
                    , productionOrderDTO.getOrderProduct()
                    , productionOrderDTO.getOrderStatus()
                    , productionOrderDTO.getOrderDate()
                    , productionOrderDTO.getOrderTermOfRealization()
                    , productionOrderDTO.getOrderQuantity()
                    , productionOrderDTO.getOrderEmployee()
                    , productionOrderDTO.getOrderMachineId()));
        }
        return productionOrderList;
    }

    public static ProductionOrder fromProductionOrderDTOToProductionOrder(ProductionOrderDTO productionOrderDTO) {
        return new ProductionOrder(productionOrderDTO.getIdOrderTurning()
                , productionOrderDTO.getOrderProduct()
                , productionOrderDTO.getOrderStatus()
                , productionOrderDTO.getOrderDate()
                , productionOrderDTO.getOrderTermOfRealization()
                , productionOrderDTO.getOrderQuantity()
                , productionOrderDTO.getOrderEmployee()
                , productionOrderDTO.getOrderMachineId());
    }

    public static List<ProductionOrderHistory> fromProductOrderHistoryDTOToProductOrderHistory(List<ProductionOrderHistoryDTO> productionOrderHistoryDTOs) {
        List<ProductionOrderHistory> productionOrderHistoryList = new ArrayList<>();
        for (ProductionOrderHistoryDTO productionOrderHistoryDTO : productionOrderHistoryDTOs) {
            productionOrderHistoryList.add(new ProductionOrderHistory(productionOrderHistoryDTO.getIdOrderTurning()
                    , productionOrderHistoryDTO.getOrderId()
                    , productionOrderHistoryDTO.getDate()
                    , productionOrderHistoryDTO.getTime()
                    , productionOrderHistoryDTO.getEmployee()
                    , productionOrderHistoryDTO.getContents()));
        }


        return productionOrderHistoryList;
    }

    public static ProductionOrderHistory fromProductOrderHistoryDTOToProductOrderHistory(ProductionOrderHistoryDTO productionOrderHistoryDTO) {
        return new ProductionOrderHistory(productionOrderHistoryDTO.getIdOrderTurning()
                , productionOrderHistoryDTO.getOrderId()
                , productionOrderHistoryDTO.getDate()
                , productionOrderHistoryDTO.getTime()
                , productionOrderHistoryDTO.getEmployee()
                , productionOrderHistoryDTO.getContents());
    }

    public static List<ProductionOrderRealization> fromProductOrderRealizationDTOToProductOrderRealization(List<ProductionOrderRealizationDTO> productionOrderRealizationDTOs) {
        List<ProductionOrderRealization> productionOrderRealizationList = new ArrayList<>();
        for (ProductionOrderRealizationDTO productionOrderRealizationDTO : productionOrderRealizationDTOs) {
            productionOrderRealizationList.add(new ProductionOrderRealization(productionOrderRealizationDTO.getId()
                    , productionOrderRealizationDTO.getOrderId()
                    , productionOrderRealizationDTO.getSaveDate()
                    , productionOrderRealizationDTO.getStartDateTime()
                    , productionOrderRealizationDTO.getStopDateTime()
                    , productionOrderRealizationDTO.getQuantity()
                    , productionOrderRealizationDTO.getMachineId()
                    , productionOrderRealizationDTO.getUnitTime()
                    , productionOrderRealizationDTO.getSpeedSpindle1()
                    , productionOrderRealizationDTO.getSpeedSpindle2()
                    , productionOrderRealizationDTO.getFeederateWorking()
                    , productionOrderRealizationDTO.getFeederateFast()));
        }
        return productionOrderRealizationList;
    }

    public static ProductionOrderRealization fromProductOrderRealizationDTOToProductOrderRealization(ProductionOrderRealizationDTO productionOrderRealizationDTO) {
        return new ProductionOrderRealization(productionOrderRealizationDTO.getId()
                , productionOrderRealizationDTO.getOrderId()
                , productionOrderRealizationDTO.getSaveDate()
                , productionOrderRealizationDTO.getStartDateTime()
                , productionOrderRealizationDTO.getStopDateTime()
                , productionOrderRealizationDTO.getQuantity()
                , productionOrderRealizationDTO.getMachineId()
                , productionOrderRealizationDTO.getUnitTime()
                , productionOrderRealizationDTO.getSpeedSpindle1()
                , productionOrderRealizationDTO.getSpeedSpindle2()
                , productionOrderRealizationDTO.getFeederateWorking()
                , productionOrderRealizationDTO.getFeederateFast());
    }

    public static List<Machine> fromMachineDTOToMachine(List<MachinesDTO> machinesDTOs) {
        List<Machine> machineList = new ArrayList<>();
        for (MachinesDTO machinesDTO : machinesDTOs) {
            machineList.add(new Machine(machinesDTO.getId()
                    , machinesDTO.getName()
                    , machinesDTO.getManufactureYear()
                    , machinesDTO.getTrademark()
                    , machinesDTO.getProcesingMaterial()
                    , machinesDTO.getStatus()));
        }
        return machineList;
    }

    public static Machine fromMachineDTOToMachine(MachinesDTO machinesDTO) {
        return new Machine(machinesDTO.getId()
                , machinesDTO.getName()
                , machinesDTO.getManufactureYear()
                , machinesDTO.getTrademark()
                , machinesDTO.getProcesingMaterial()
                , machinesDTO.getStatus());
    }

    public static List<MachineUsage> fromMachineUsageDTOToMachineUsage(List<MachineUsageDTO> machineUsageDTOs) {
        List<MachineUsage> machineUsageList = new ArrayList<>();
        for (MachineUsageDTO machineUsageDTO : machineUsageDTOs) {
            machineUsageList.add(new MachineUsage(machineUsageDTO.getId()
                    , machineUsageDTO.getMachinesId()
                    , machineUsageDTO.getDate()
                    , machineUsageDTO.getStartDateTime()
                    , machineUsageDTO.getStopDateTime()
                    , machineUsageDTO.getStatus()
                    , machineUsageDTO.getEmployee()
                    , machineUsageDTO.getOrderId()));
        }
        return machineUsageList;
    }

    public static MachineUsage fromMachineUsageDTOToMachineUsage(MachineUsageDTO machineUsageDTO) {
        return new MachineUsage(machineUsageDTO.getId()
                , machineUsageDTO.getMachinesId()
                , machineUsageDTO.getDate()
                , machineUsageDTO.getStartDateTime()
                , machineUsageDTO.getStopDateTime()
                , machineUsageDTO.getStatus()
                , machineUsageDTO.getEmployee()
                , machineUsageDTO.getOrderId());
    }

    public static List<Product> fromProoductDTOToProduct(List<ProductDTO> productDTOs) {
        List<Product> productsList = new ArrayList<>();
        for (ProductDTO productDTO : productDTOs) {
            productsList.add(new Product(productDTO.getCode()
                    , productDTO.getSeries()
                    , productDTO.getWeight()
                    , productDTO.getQuantityInBox()
                    , productDTO.getLength()
                    , productDTO.getMaterial()
                    , productDTO.getAssembling()
                    , productDTO.getDescription()
                    , productDTO.getPicture()
                    , productDTO.getTechnicalDrawing()));
        }

        return productsList;
    }

    public static Product fromProoductDTOToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getCode()
                , productDTO.getSeries()
                , productDTO.getWeight()
                , productDTO.getQuantityInBox()
                , productDTO.getLength()
                , productDTO.getMaterial()
                , productDTO.getAssembling()
                , productDTO.getDescription()
                , productDTO.getPicture()
                , productDTO.getTechnicalDrawing());

    }

}
