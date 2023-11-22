package br.com.cassiogamarra.orcamentos.repositories;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.cassiogamarra.orcamentos.entities.Orcamento;

public class OrcamentoRepository { 
	public SessionFactory sessionFactory;

    public void setup() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "");
        config.setProperty("hibernate.connection.username", "");
        config.setProperty("hibernate.connection.password", "");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.addAnnotatedClass(Orcamento.class);
        sessionFactory = config.buildSessionFactory();
    }
    
    public void close() {
        sessionFactory.close();
    }
    
    public Orcamento buscarPorCliente(String nomeCliente) {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();

        String query = String.format("from Orcamento where nomeCliente = '%s'", nomeCliente);
        Orcamento orcamento = session.createQuery(query, Orcamento.class).setMaxResults(1).getSingleResult();
		return orcamento;
    }
    
    public String salvar(Orcamento orcamento) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(orcamento);
        session.close();

        return "/index.xhtml?faces-redirect=true";
    }
}
