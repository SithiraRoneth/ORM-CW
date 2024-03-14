package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.AdminDTO;

import java.util.List;

public interface AdminBO extends SuperBO {
    boolean saveUser(AdminDTO adminDTO);
    AdminDTO getAdmin(String mail);
    boolean updateUser(AdminDTO adminDTO);
    List<AdminDTO> loginUserDetails(AdminDTO adminDTO);

}
