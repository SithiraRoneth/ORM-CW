package lk.ijse.DAO.Custom.Impl;

import lk.ijse.DAO.Custom.TransactionDAO;
import lk.ijse.Entity.Transaction;

import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public boolean save(Transaction dto) {
        return false;
    }

    @Override
    public boolean update(Transaction dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public Transaction getItem(String id) {
        return null;
    }
}
