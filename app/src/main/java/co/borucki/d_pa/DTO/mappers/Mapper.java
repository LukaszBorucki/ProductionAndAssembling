package co.borucki.d_pa.DTO.mappers;

import java.util.ArrayList;
import java.util.List;

import co.borucki.d_pa.DTO.UserDTO;
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

}
