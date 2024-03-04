package lk.ijse.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.CustomerDAO;
import lk.ijse.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    Session session = FactoryConfiguration.getInstance().getSession();
    @Override
    public boolean save(Customer dto) {
        try {
            Transaction transaction = session.beginTransaction();
            Serializable save = (Serializable) session.save(dto);
            transaction.commit();
            return save != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Customer dto) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class,id);
            session.delete(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getItem(String id) {
        return null;
    }

    @Override
    public String getNextId() {
        return null;
    }
}
