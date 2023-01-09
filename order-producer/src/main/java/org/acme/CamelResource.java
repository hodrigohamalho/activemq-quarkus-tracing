package org.acme;

import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.agroal.api.AgroalDataSource;
import io.quarkus.runtime.StartupEvent;
import org.apache.camel.CamelContext;

@ApplicationScoped
public class CamelResource {

	@Inject
	AgroalDataSource defaultDataSource;

    void startup(@Observes StartupEvent event, CamelContext context) throws Exception {
        context.getRouteController().startAllRoutes();
    }

    @PostConstruct
    void postConstruct() throws Exception {
        try (Connection con = defaultDataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                
                con.setAutoCommit(true);
                
                try {
                    statement.execute("drop table orders");
                } catch (Exception ignored) {}

                statement.execute("CREATE TABLE orders ("
                		+ "id integer NOT NULL AUTO_INCREMENT, "
                		+ "item varchar(100), "
                		+ "amount integer, "
                		+ "description varchar(100), "
                		+ "processed boolean, "
                		+ "PRIMARY KEY (id)"
                		+ ")");
                
                statement.execute("INSERT INTO orders (item, amount, description, processed) values('Ansible', 10, 'ansible product', true)");
                statement.execute("INSERT INTO orders (item, amount, description, processed) values('Openshift', 10, 'Openshift product', true)");
            }
        }
    }
}