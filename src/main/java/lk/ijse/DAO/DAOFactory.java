/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:52
 * Project Name :ORM
 * */
package lk.ijse.DAO;

import lk.ijse.DAO.Custom.Impl.BookDAOImpl;
import lk.ijse.DAO.Custom.Impl.UserDAOImpl;
import lk.ijse.DAO.Custom.Impl.AdminDAOImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static DAOFactory getFactory() {
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes {
        AdMIN,USER,BOOK,TRANSACTION
    }

    public SuperDAO getDAO (DAOTypes daoTypes) {
        switch (daoTypes) {
            case AdMIN:
               return new AdminDAOImpl();
            case USER:
                return new UserDAOImpl();
            case BOOK:
                return new BookDAOImpl();
            case TRANSACTION:
                return null;
            default:
                return null;
        }
    }
}
