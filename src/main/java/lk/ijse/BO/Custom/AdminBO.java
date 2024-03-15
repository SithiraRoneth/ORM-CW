package lk.ijse.BO.Custom;

import lk.ijse.BO.SuperBO;
import lk.ijse.Dto.AdminDTO;


public interface AdminBO extends SuperBO {
    boolean saveUser(AdminDTO adminDTO);
    AdminDTO getAdmin(String mail);
    boolean updateUser(AdminDTO adminDTO);

}
