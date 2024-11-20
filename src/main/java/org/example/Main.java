package org.example;

import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        FlywayConfig.getInstance().migrate();
        SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

        ClientCrudService clientService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudService(sessionFactory);

        System.out.println("Testing ClientCrudService----------------");

        Client newClient = clientService.create("Alice");
        System.out.println("Created Client: " + newClient);

        Client fetchedClient = clientService.getById(newClient.getId());
        System.out.println("Fetched Client: " + fetchedClient);

        Client updatedClient = clientService.update(newClient.getId(), "Alice Updated");
        System.out.println("Updated Client: " + updatedClient);

        boolean isClientDeleted = clientService.delete(newClient.getId());
        System.out.println("Client Deleted: " + isClientDeleted);


        System.out.println("Testing PlanetCrudService------------------");

        Planet newPlanet = planetService.create("EARTH", "Earth");
        System.out.println("Created Planet: " + newPlanet);

        Planet fetchedPlanet = planetService.getById("EARTH");
        System.out.println("Fetched Planet: " + fetchedPlanet);

        Planet updatedPlanet = planetService.update("EARTH", "Earth Updated");
        System.out.println("Updated Planet: " + updatedPlanet);

        boolean isPlanetDeleted = planetService.delete("EARTH");
        System.out.println("Planet Deleted: " + isPlanetDeleted);

        sessionFactory.close();
    }
}

