package lk.ijse.BO.Custom.impl;

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
    public AdminDTO getAdmin(AdminDTO userDTO) {
        Admin admin = adminDAO.getItem(userDTO.getMail());
        if (admin!=null) {
            return new AdminDTO(admin.getMail(),admin.getPassword());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateUser(AdminDTO userDTO) {
        return adminDAO.update(new Admin(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }

}
