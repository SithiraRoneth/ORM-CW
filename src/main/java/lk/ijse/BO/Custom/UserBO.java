package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> getAllUsers();
    boolean saveUser(UserDTO customerDTO);
    boolean updateUser(UserDTO customerDTO);
    UserDTO getUser(String cusId);
    boolean deleteUser(String cusId);
    String getNextId();
}
