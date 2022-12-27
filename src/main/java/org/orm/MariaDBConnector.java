package org.orm;

import org.orm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication( exclude = {DataSourceAutoConfiguration.class} )
public class MariaDBConnector {

    public static void main(String[] args) {
        SpringApplication.run(MariaDBConnector.class, args);

    }
}
