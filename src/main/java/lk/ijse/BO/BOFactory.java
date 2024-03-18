/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:57
 * Project Name :ORM
 * */
package lk.ijse.BO;

import lk.ijse.BO.Custom.impl.*;

public class BOFactory {
    private static BOFactory factory;

    private BOFactory() {}

    public static BOFactory getFactory() {
        return factory == null ? factory= new BOFactory() : factory;
    }
    public enum BOTypes {
        ADMIN,USER,BOOK,TRANSACTION,BRANCH
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case ADMIN:
               return new AdminBOImpl();
            case USER:
                return new UserBOImpl();
            case BOOK:
                return new BookBOImpl();
            case TRANSACTION:
                return new TransactionBOImpl();
            case BRANCH:
                return new BranchBOImpl();
            default:
                return null;
        }
    }
}
