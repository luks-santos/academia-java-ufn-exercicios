package com.lucas.ocorrencias;

import com.lucas.ocorrencias.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ocorrencias-beta");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        user.setName("Zé do Brejo");
        user.setCellphone("12345678");
        user.setCpf("11111111111");
        user.setEmail("user@user.com");
        user.setPassword("1234");

        Category category = new Category();
        category.setName("Lote vago sujo");

        Topic topic = new Topic();
        topic.setName("Chamado");
        topic.setCategory(category);

        Comment comment = new Comment();
        comment.setName("Reclamação");

        Ticket ticket = new Ticket();
        ticket.setStatus("Em análise");
        ticket.setPriority("Alta");
        ticket.setComment(comment);
        ticket.setTopic(topic);
        ticket.setUser(user);

        user.getTickets().add(ticket);
        comment.getTickets().add(ticket);
        topic.getTickets().add(ticket);
        category.getTopics().add(topic);

        em.persist(user);
        em.persist(category);
        em.persist(topic);
        em.persist(comment);
        em.persist(ticket);

        Ticket ticket1 = em.find(Ticket.class, 1L);

        ticket1.setStatus("Resolvido");
        ticket1.setClosedAt(LocalDateTime.now());
        em.persist(ticket1);

        em.getTransaction().commit();
    }
}