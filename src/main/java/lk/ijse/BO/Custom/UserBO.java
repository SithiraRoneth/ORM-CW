package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.UserDTO;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO userDTO);
    UserDTO getUser(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);
}
