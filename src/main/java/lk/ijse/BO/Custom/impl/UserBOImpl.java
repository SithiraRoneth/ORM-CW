package lk.ijse.BO.Custom.impl;

import lk.ijse.BO.Custom.UserBO;
import lk.ijse.DAO.Custom.UserDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Dto.UserDTO;
import lk.ijse.Entity.User;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO userDTO) {
        //userDAO.save(new User(userDTO.getMail(),userDTO.getPassword()));
        return true;
    }

    @Override
    public UserDTO getUser(UserDTO userDTO) {
        User user = userDAO.getItem(userDTO.getMail());
        if (user!=null) {
            return new UserDTO(user.getMail(),user.getPassword());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userDAO.update(new User(
                userDTO.getMail(),
                userDTO.getPassword()
        ));
    }
}
