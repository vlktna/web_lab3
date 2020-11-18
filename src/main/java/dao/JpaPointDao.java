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
        executeInsideTransaction(entityManager -> entityManager.persist(point));
    }

//    @Resource
//    UserTransaction utx;
//
//    @Override
//    public void deleteAll() {
//        try {
//
//            utx.begin();
//            Query query = em.createQuery("DELETE FROM Point");
//            query.executeUpdate();
//            utx.commit();
//        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
//            e.printStackTrace();
//        }
//    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
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
