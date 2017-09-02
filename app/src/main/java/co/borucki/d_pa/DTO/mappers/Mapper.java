package co.borucki.d_pa.DTO.mappers;

import java.util.ArrayList;
import java.util.List;

import co.borucki.d_pa.DTO.MessageDTO;
import co.borucki.d_pa.DTO.ProductionOrdersDTO;
import co.borucki.d_pa.DTO.ProductionOrdersHistoryDTO;
import co.borucki.d_pa.DTO.ProductionOrdersRealizationDTO;
import co.borucki.d_pa.DTO.UserDTO;
import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.model.ProductionOrdersRealization;
import co.borucki.d_pa.model.ProductionOrders;
import co.borucki.d_pa.model.ProductionOrdersHistory;
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

    public static List<User> fromUserDTOListToUserList(List<UserDTO> userDTOs) {
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


    public static List<ProductionOrders> fromProductionOrdersDTOToProductionOrders(List<ProductionOrdersDTO> productionOrdersDTOs) {
        List<ProductionOrders> productionOrdersList = new ArrayList<>();
        for (ProductionOrdersDTO productionOrdersDTO : productionOrdersDTOs) {
            productionOrdersList.add(new ProductionOrders(productionOrdersDTO.getIdOrderTurning()
                    , productionOrdersDTO.getOrderProduct()
                    , productionOrdersDTO.getOrderStatus()
                    , productionOrdersDTO.getOrderDate()
                    , productionOrdersDTO.getOrderTermOfRealization()
                    , productionOrdersDTO.getOrderQuantity()
                    , productionOrdersDTO.getOrderEmployee()
                    , productionOrdersDTO.getOrderMachineId()));
        }
        return productionOrdersList;
    }

    public static ProductionOrders fromProductionOrdersDTOToProductionOrders(ProductionOrdersDTO productionOrdersDTO) {
        return new ProductionOrders(productionOrdersDTO.getIdOrderTurning()
                , productionOrdersDTO.getOrderProduct()
                , productionOrdersDTO.getOrderStatus()
                , productionOrdersDTO.getOrderDate()
                , productionOrdersDTO.getOrderTermOfRealization()
                , productionOrdersDTO.getOrderQuantity()
                , productionOrdersDTO.getOrderEmployee()
                , productionOrdersDTO.getOrderMachineId());
    }

    public static List<ProductionOrdersHistory> fromProductOrdersHistoryDTOToProductOrdersHistory(List<ProductionOrdersHistoryDTO> productionOrdersHistoryDTOs) {
        List<ProductionOrdersHistory> productionOrdersHistoryList = new ArrayList<>();
        for (ProductionOrdersHistoryDTO productionOrdersHistoryDTO : productionOrdersHistoryDTOs) {
            productionOrdersHistoryList.add(new ProductionOrdersHistory(productionOrdersHistoryDTO.getIdOrderTurning()
                    , productionOrdersHistoryDTO.getOrderId()
                    , productionOrdersHistoryDTO.getDate()
                    , productionOrdersHistoryDTO.getTime()
                    , productionOrdersHistoryDTO.getEmployee()
                    , productionOrdersHistoryDTO.getContents()));
        }


        return productionOrdersHistoryList;
    }

    public static ProductionOrdersHistory fromProductOrdersHistoryDTOToProductOrdersHistory(ProductionOrdersHistoryDTO productionOrdersHistoryDTO) {
        return new ProductionOrdersHistory(productionOrdersHistoryDTO.getIdOrderTurning()
                , productionOrdersHistoryDTO.getOrderId()
                , productionOrdersHistoryDTO.getDate()
                , productionOrdersHistoryDTO.getTime()
                , productionOrdersHistoryDTO.getEmployee()
                , productionOrdersHistoryDTO.getContents());
    }

    public static List<ProductionOrdersRealization> fromProductOrdersRealizationDTOToProductOrdersRealization(List<ProductionOrdersRealizationDTO> productionOrdersRealizationDTOs) {
        List<ProductionOrdersRealization> productionOrdersRealizationList = new ArrayList<>();
        for (ProductionOrdersRealizationDTO productionOrdersRealizationDTO : productionOrdersRealizationDTOs) {
            productionOrdersRealizationList.add(new ProductionOrdersRealization(productionOrdersRealizationDTO.getId()
                    , productionOrdersRealizationDTO.getOrderId()
                    , productionOrdersRealizationDTO.getSaveDate()
                    , productionOrdersRealizationDTO.getStartDateTime()
                    , productionOrdersRealizationDTO.getStopDateTime()
                    , productionOrdersRealizationDTO.getQuantity()
                    , productionOrdersRealizationDTO.getMachineId()
                    , productionOrdersRealizationDTO.getUnitTime()
                    , productionOrdersRealizationDTO.getSpeedSpindle1()
                    , productionOrdersRealizationDTO.getSpeedSpindle2()
                    , productionOrdersRealizationDTO.getFeederateWorking()
                    , productionOrdersRealizationDTO.getFeederateFast()));
        }
        return productionOrdersRealizationList;
    }

    public static ProductionOrdersRealization fromProductOrdersRealizationDTOToProductOrdersRealization(ProductionOrdersRealizationDTO productionOrdersRealizationDTO) {
        return new ProductionOrdersRealization(productionOrdersRealizationDTO.getId()
                , productionOrdersRealizationDTO.getOrderId()
                , productionOrdersRealizationDTO.getSaveDate()
                , productionOrdersRealizationDTO.getStartDateTime()
                , productionOrdersRealizationDTO.getStopDateTime()
                , productionOrdersRealizationDTO.getQuantity()
                , productionOrdersRealizationDTO.getMachineId()
                , productionOrdersRealizationDTO.getUnitTime()
                , productionOrdersRealizationDTO.getSpeedSpindle1()
                , productionOrdersRealizationDTO.getSpeedSpindle2()
                , productionOrdersRealizationDTO.getFeederateWorking()
                , productionOrdersRealizationDTO.getFeederateFast());
    }
}
