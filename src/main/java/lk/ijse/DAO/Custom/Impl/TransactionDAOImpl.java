package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.TransactionDAO;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.Transactions;
import lk.ijse.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    Session session = FactoryConfiguration.getInstance().getSession();

    @Override
    public boolean save(Transactions dto) {
        return true;
    }

    @Override
    public boolean update(Transactions transactions) {
       String status = "Available";

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.createQuery("UPDATE Book b SET B.status =:status WHERE b.id = :book_id")
            .setParameter("status",status)
                    .setParameter("bookId",transactions.getId())
                    .executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
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
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Transactions").list();
    }

    @Override
    public Transactions getItem(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
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
        Session session = FactoryConfiguration.getInstance().getSession();
        String newId = "TRS-000";
        Transaction transaction = session.beginTransaction();
        List list = session.createNativeQuery("select trans_id from transaction order by trans_id desc limit 1").list();
        if (!list.isEmpty()) newId = (String) list.get(0);
        transaction.commit();
        session.close();
        return newId;
    }

    @Override
    public boolean saveTransaction(Transactions transactionsEntity, User userEntity, Book bookEntity) {
        String status = "Not Available";
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            List<Transactions> transactions = new ArrayList<>();

            transactionsEntity.setUserList(userEntity);
            userEntity.setTransactions(transactions);

            transactionsEntity.setBookList(bookEntity);
            bookEntity.setTransactions(transactions);

            transactions.add(transactionsEntity);
            session.save(transactionsEntity);

            session.createQuery("UPDATE Book b SET b.status = :status WHERE b.id = : book_id")
                    .setParameter("status",status).setParameter("book_id",bookEntity.getId()).executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
