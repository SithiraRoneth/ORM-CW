package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DAO.Custom.UserDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public List<UserDTO> getAllUsers() {

        List<UserDTO>userDTOS = new ArrayList<>();
        for (User user:userDAO.getAll()) {
            userDTOS.add(new UserDTO(
                    user.getE_mail(),
                    user.getName(),
                    user.getPw()
            ));
        }
        return userDTOS;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return userDAO.save(
                new User(
                        userDTO.getE_mail(),
                        userDTO.getName(),
                        userDTO.getPw()
                )
        );
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userDAO.update(
                new User(
                        userDTO.getE_mail(),
                        userDTO.getName(),
                        userDTO.getPw()
                )
        );
    }

    @Override
    public UserDTO getUser(String cusId) {
        User user = userDAO.getItem(cusId);
        if (user!=null) {
            return new UserDTO(
                    user.getE_mail(),
                    user.getName(),
                    user.getPw()
            );
        }
        return null;
    }

    @Override
    public boolean deleteUser(String cusId) {
        return userDAO.delete(cusId);
    }

    @Override
    public String getNextId() {
        String id = userDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("U","")) + 1;
        return String.format("U%03d",newId);
    }
}
