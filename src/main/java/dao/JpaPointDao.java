package dao;

import entity.Point;
import javax.persistence.*;
import java.util.List;
import java.util.function.Consumer;

public class JpaPointDao implements Dao<Point> {

    private static final String PERSISTENCE_UNIT_NAME = "Points";
    private EntityManager em;
    private EntityManagerFactory emf;

    public void createEntityManager() {
        this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.em = emf.createEntityManager();
    }

    public void closeEntity() {
        this.em.close();
        this.emf.close();
    }

    @Override
    public List<Point> getAll() {
        Query query = em.createQuery("SELECT p FROM Point p");
        return query.getResultList();
    }

    @Override
    public void save(Point point) {
        executeSessionTransaction(entityManager -> entityManager.persist(point));
    }

    @Override
    public void deleteAll() {
        executeQueryTransaction("DELETE FROM Point");
    }

    private void executeQueryTransaction(String request){
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Query query = em.createQuery(request);
            query.executeUpdate();
            tx.commit();
        } catch (RollbackException e) {
            tx.rollback();
            throw e;
        }
    }

    private void executeSessionTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
