package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class TicketCrudService {
    private final SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket create(Client client, Planet fromPlanet, Planet toPlanet) {
        if (client == null || fromPlanet == null || toPlanet == null) {
            throw new IllegalArgumentException("Client and planets cannot be null.");
        }

        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setClient(client);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }

        return ticket;
    }

    public Ticket getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public List<Ticket> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    public Ticket update(Long id, Planet fromPlanet, Planet toPlanet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                ticket.setFromPlanet(fromPlanet);
                ticket.setToPlanet(toPlanet);
                session.merge(ticket);
            }
            transaction.commit();
            return ticket;
        }
    }

    public boolean delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.remove(ticket);
                transaction.commit();
                return true;
            }
            return false;
        }
    }
}
