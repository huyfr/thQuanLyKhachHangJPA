package customer.repository.impl;

import customer.model.Customer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    private static Logger logger = LogManager.getLogger(CustomerRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        logger.trace("Vao findAll");
        String queryStr = "select c from Customer as c";
        TypedQuery<Customer> query = em.createQuery(queryStr, Customer.class);
        logger.info(query.toString());
        logger.trace("Thoat findAll");
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        logger.trace("Vao findById");
        String queryStr = "select c from Customer as c where c.id = :id";
        TypedQuery<Customer> query = em.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        logger.info(id);
        try {
            logger.trace("Thoat findById");
            return query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
            logger.trace("Thoat findById");
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        logger.trace("Vao save");
        if (model.getId() != null) {
            em.merge(model);
            logger.info(model.toString());
        } else {
            em.persist(model);
            logger.info(model.toString());
        }
        logger.trace("Thoat save");
    }

    @Override
    public void remove(Long id) {
        logger.trace("Vao remove");
        Customer customer = findById(id);
        logger.info(customer);
        if (customer != null) {
            em.remove(customer);
        }
        logger.trace("Thoat remove");
    }
}
