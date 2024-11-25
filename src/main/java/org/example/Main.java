package org.example;

import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        FlywayConfig.getInstance().migrate();
        SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

        ClientCrudService clientService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudService(sessionFactory);
        TicketCrudService ticketService = new TicketCrudService(sessionFactory);


        System.out.println("Testing ClientCrudService----------------");

        Client newClient = clientService.create("Alice");
        System.out.println("Created Client: " + newClient);

        System.out.println("Testing PlanetCrudService------------------");

        Planet earth = planetService.create("EARTH", "Earth");
        System.out.println("Created Planet: " + earth);
        Planet mars = planetService.create("MARS", "Mars");
        System.out.println("Created Planet: " + mars);

        System.out.println("Testing TicketCrudServiceNull------------------");

        try {
            ticketService.create(null, earth, mars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ticketService.create(newClient, null, mars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ticketService.create(newClient, earth, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Testing TicketCrudService------------------");

        Ticket newTicket = ticketService.create(newClient, earth, mars);
        System.out.println("Created Ticket: " + newTicket);

        Ticket fetchedTicket = ticketService.getById(newTicket.getId());
        System.out.println("Fetched Ticket: " + fetchedTicket);

        Ticket updatedTicket = ticketService.update(newTicket.getId(), mars, earth);
        System.out.println("Updated Ticket: " + updatedTicket);

        boolean isTicketDeleted = ticketService.delete(newTicket.getId());
        System.out.println("Ticket Deleted: " + isTicketDeleted);




        sessionFactory.close();
    }
}