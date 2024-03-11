package lk.ijse.DAO.Custom.Impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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
        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
            query.from(Customer.class);
            List<Customer> resultList = session.createQuery(query).getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Customer getItem(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class,id);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public String getNextId() {
        return null;
    }
}
