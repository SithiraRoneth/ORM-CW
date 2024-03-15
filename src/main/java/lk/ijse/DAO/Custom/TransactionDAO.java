package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.Entity.Transactions;

public interface TransactionDAO extends CrudDAO<Transactions,String > {
    String getNextId();
}
