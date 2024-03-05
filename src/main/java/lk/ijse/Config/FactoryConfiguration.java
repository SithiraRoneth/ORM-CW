/* Created By Sithira Roneth
 * Date :2/29/24
 * Time :22:02
 * Project Name :ORM
 * */
package lk.ijse.Config;

import lk.ijse.Entity.Book;
import lk.ijse.Entity.Customer;
import lk.ijse.Entity.Transaction;
import lk.ijse.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Transaction.class)
                ;
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        if (factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
