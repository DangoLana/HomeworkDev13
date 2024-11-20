package org.example;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    private static final FlywayConfig INSTANCE;
    private final Flyway flyway;

    static {
        INSTANCE = new FlywayConfig();
    }

    private FlywayConfig() {
        flyway = Flyway.configure()
                .dataSource("jdbc:h2:./data/testdb", "sa", "")
                .load();
    }


    public static FlywayConfig getInstance() {
        return INSTANCE;
    }

    public void migrate() {
        flyway.migrate();
        System.out.println("Міграції Flyway виконані успішно!---------");
    }

}
