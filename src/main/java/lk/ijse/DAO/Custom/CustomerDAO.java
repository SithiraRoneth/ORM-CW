package lk.ijse.DAO.Custom;

import lk.ijse.DAO.CrudDAO;
import lk.ijse.Entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String > {
    String getNextId();
}
