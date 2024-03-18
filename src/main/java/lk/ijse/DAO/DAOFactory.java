/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:52
 * Project Name :ORM
 * */
package lk.ijse.DAO;

import lk.ijse.DAO.Custom.Impl.*;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static DAOFactory getFactory() {
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes {
        AdMIN,USER,BOOK,TRANSACTION,QUERY,BRANCH
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
                return new TransactionDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            default:
                return null;
        }
    }
}
