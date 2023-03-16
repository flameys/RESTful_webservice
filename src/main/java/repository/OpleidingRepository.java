package repository;

import entity.courses.Opleiding;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class OpleidingRepository {
    private EntityManager entityManager;

    public OpleidingRepository(EntityManager entityManager) {
        this.entityManager = entityManager; }

    // CREATE
    public Opleiding createOpleiding(Opleiding opleiding) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(opleiding);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return opleiding;
    }

    // READ-ALL
    public List<Opleiding> getOpleidingen() {
        String query = "select o from Opleiding o";
        TypedQuery<Opleiding> typedQuery = entityManager.createQuery(query, Opleiding.class);
        List<Opleiding> opleidingList = typedQuery.getResultList();
        return opleidingList;
    }

    public Opleiding getOpleiding(String oplNaam){
        Query query = entityManager.createQuery("select o from Opleiding o where o.naam = :naam");
        query.setParameter("naam", oplNaam);
        Opleiding result = (Opleiding) query.getSingleResult();
        return result;
    }

    public Opleiding getOpleidingById(int oplId){
        Query query = entityManager.createQuery("select o from Opleiding o where o.id = :id");
        query.setParameter("id", oplId);
        Opleiding result = (Opleiding) query.getSingleResult();
        return result;
    }

// UPDATE

    // DELETE ALL RECORDS
    public int deleteAllOpleidingen(){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Opleiding opl");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
