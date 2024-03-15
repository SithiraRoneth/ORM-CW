/* Created By Sithira Roneth
 * Date :2/29/24
 * Time :22:02
 * Project Name :ORM
 * */

package lk.ijse.Config;

import lk.ijse.Entity.Admin;
import lk.ijse.Entity.Book;
import lk.ijse.Entity.User;
import lk.ijse.Entity.Transactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration(){

        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Transactions.class);

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
