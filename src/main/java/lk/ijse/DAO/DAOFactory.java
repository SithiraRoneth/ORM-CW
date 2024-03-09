/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:52
 * Project Name :ORM
 * */
package lk.ijse.DAO;

import lk.ijse.DAO.Custom.Impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static DAOFactory getFactory() {
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes {
        USER,CUSTOMER,BOOK,TRANSACTION
    }

    public SuperDAO getDAO (DAOTypes daoTypes) {
        switch (daoTypes) {
            case USER:
               return new UserDAOImpl();
            case CUSTOMER:
                return null;
            case BOOK:
                return null;
            case TRANSACTION:
                return null;
            default:
                return null;
        }
    }
}
