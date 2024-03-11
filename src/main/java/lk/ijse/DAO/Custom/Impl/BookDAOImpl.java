package lk.ijse.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.BookDAO;
import lk.ijse.DAO.Custom.TransactionDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.Entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class BookDAOImpl  implements BookDAO {
    Session session = FactoryConfiguration.getInstance().getSession();
    @Override
    public boolean save(Book dto) {
        try {
            Transaction transaction = session.beginTransaction();
            Serializable save = (Serializable) session.save(dto);
            transaction.commit();
            return  save!=null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Book dto) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            return true;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            Book book = session.get(Book.class,id);
            session.delete(book);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getAll() {
        try {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = (CriteriaBuilder) session.getCriteriaBuilder();
            CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
            query.from(Book.class);
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getItem(String id) {
        return null;
    }

    @Override
    public String getNextId() {
        return null;
    }
}
