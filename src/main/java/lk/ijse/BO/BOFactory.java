/* Created By Sithira Roneth
 * Date :3/3/24
 * Time :22:57
 * Project Name :ORM
 * */
package lk.ijse.BO;

import lk.ijse.BO.Custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory factory;

    private BOFactory() {}

    public static BOFactory getFactory() {
        return factory == null ? factory= new BOFactory() : factory;
    }
    public enum BOTypes {
        USER,CUSTOMER,BOOK,TRANSACTION
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case USER:
                new UserBOImpl();
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
