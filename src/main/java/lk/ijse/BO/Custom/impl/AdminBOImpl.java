package lk.ijse.BO.Custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.BO.Custom.AdminBO;
import lk.ijse.DAO.Custom.AdminDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.AdminDTO;
import lk.ijse.Entity.Admin;

import java.util.List;

public class AdminBOImpl implements AdminBO {

    AdminDAO adminDAO = (AdminDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.AdMIN);
    @Override
    public boolean saveUser(AdminDTO userDTO) {
        adminDAO.save(new Admin(userDTO.getMail(),userDTO.getPassword()));
        return true;
    }

    @Override
    public AdminDTO getAdmin(String mail) {
        Admin admin = adminDAO.getItem(mail);
        if (admin!=null) {
            return new AdminDTO(admin.getMail(),admin.getPassword());
        } else {
          new Alert(Alert.AlertType.ERROR).show();
        }
        return null;
    }

    @Override
    public boolean updateUser(AdminDTO userDTO) {
        return adminDAO.update(new Admin(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }

}
