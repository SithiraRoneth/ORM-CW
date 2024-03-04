/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:52
 * Project Name :ORM
 * */
package lk.ijse.DAO;

import lk.ijse.BO.Custom.impl.UserBOImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static DAOFactory getFactory() {
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes {
        USER,CUSTOMER,BOOK,TRANSACTION,QUERY
    }

    public SuperDAO getDAO (DAOTypes daoTypes) {
        switch (daoTypes) {
            case USER:
               // new UserBOImpl();
                return null;
            case CUSTOMER:
                return null;
            case BOOK:
                return null;
            case TRANSACTION:
                return null;
            case QUERY:
                return null;
            default:
                return null;
        }
    }
}
