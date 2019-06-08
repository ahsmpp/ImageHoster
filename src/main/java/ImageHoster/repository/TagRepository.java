package ImageHoster.repository;

import ImageHoster.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class TagRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Tag createTag(Tag tag) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(tag);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return tag;
    }

    public Tag checkTag(String tagName) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Tag> typedQuery = em.createQuery("SELECT t FROM Tag t WHERE t.name = :tagName", Tag.class);
            typedQuery.setParameter("tagName", tagName);

            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
