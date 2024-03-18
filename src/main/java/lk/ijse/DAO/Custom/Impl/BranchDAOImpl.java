/* Created By Sithira Roneth
 * Date :3/18/24
 * Time :10:48
 * Project Name :ORM
 * */
package lk.ijse.DAO.Custom.Impl;

import lk.ijse.Config.FactoryConfiguration;
import lk.ijse.DAO.Custom.BranchDAO;
import lk.ijse.Entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BranchDAOImpl implements BranchDAO {
    @Override
    public boolean save(Branch dto) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Branch> branchList = new ArrayList<>();

        branchList.add(dto);
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Branch dto) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Branch branch = session.get(Branch.class,id);
        session.delete(branch);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Branch> getAll() {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        return session.createQuery("FROM Branch").list();
        return null;
    }

    @Override
    public Branch getItem(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Branch branch = session.get(Branch.class,id);
        transaction.commit();
        session.close();
        return branch;
    }

    @Override
    public String getNextId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String newId = "BR00";
        Transaction transaction = session.beginTransaction();
        List list = session.createNativeQuery("select branch_id from branch order by branch_id desc limit 1").list();
        if (!list.isEmpty()) newId = (String) list.get(0);
        transaction.commit();
        return newId;
    }
}
