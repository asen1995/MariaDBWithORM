package org.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.orm.entity.Product;
import org.orm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MariaDBConnector {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
// configures settings from hibernate.cfg.xml
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // handle the exception
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Product product = new Product();
        product.setProductName("Product 1");
        session.save(product);

        List<Product> result = session.createQuery("from Product", Product.class).list();

        result.forEach(person -> {
            //do something with Person instance...
        });

        session.getTransaction().commit();
        session.close();
    }
}
