package global.goit;

import global.goit.client.Client;
import global.goit.client.ClientService;
import global.goit.connection.Database;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);

    public static void main(String[] args) {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://35.238.176.199:5432/database_yan", "dev12", "dev12thebest")
                .load();

        flyway.migrate();
        ClientService clientService = new ClientService();
        LOGGER.info(String.valueOf(clientService.create("Lina")));
        LOGGER.info(clientService.getById(5));
        clientService.setName(1, "Evgeniy");
        clientService.deleteById(7);
        for (Client client : clientService.listAll()) {
            LOGGER.info(client.toString());
        }

    }
}