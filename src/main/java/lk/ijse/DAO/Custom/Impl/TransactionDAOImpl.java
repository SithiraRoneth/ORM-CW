package lk.ijse.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.TransactionDAO;
import lk.ijse.Entity.Transactions;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    Session session = FactoryConfiguration.getInstance().getSession();

    @Override
    public boolean save(Transactions dto) {
        try {
            Transaction transaction = session.beginTransaction();
            Serializable save = (Serializable) session.save(dto);
            transaction.commit();
            return save!=null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Transactions dto) {
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
            Transactions transactions = session.get(Transactions.class,id);
            session.delete(transactions);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Transactions> getAll() {
        return null;
    }

    @Override
    public Transactions getItem(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            Transactions transactions = session.get(Transactions.class,id);
            transaction.commit();
            return transactions;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public String getNextId() {
        try {
            String newId = "TRS-000";
            Transaction transaction = session.beginTransaction();
            List list = session.createNativeQuery("select trans_id from reservation order by trans_id desc limit 1").list();
            if (!list.isEmpty()) newId = (String) list.get(0);
            transaction.commit();
            session.close();
            return newId;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
}
