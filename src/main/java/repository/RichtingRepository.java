package repository;

import entity.courses.Richting;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class RichtingRepository {
    private EntityManager entityManager;

    public RichtingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE
    public Richting createRichting(Richting richting) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(richting);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return richting;
    }

    // READ-ALL
    public List<Richting> getRichtingen() {
        String query = "select r from Richting r";
        TypedQuery<Richting> typedQuery = entityManager.createQuery(query, Richting.class);
        List<Richting> richtingList = typedQuery.getResultList();
        return richtingList;
    }

    // READ or GET 1 RECORD
    public Richting getRichtingByName(String richtingNaam) {
        Query query = entityManager.createQuery("select r from Richting r where r.naam = :naam ");
        query.setParameter("naam", richtingNaam);
        Richting result = (Richting) query.getSingleResult();

        return result;
    }

    public List<Richting> getAllRichtingfromOpleiding(int id){
        Query query = entityManager.createQuery("select r from Richting r inner join r.opleiding o where o.id = :id");
        query.setParameter("id", id);
        List<Richting> richtingList1 = query.getResultList();
        return richtingList1;
    }

    public Richting getRichtingfromOpleiding(int id){
        Query query = entityManager.createQuery("select r from Richting r inner join r.opleiding o where o.id = :id");
        query.setParameter("id", id);
        Richting result = (Richting) query.getSingleResult();
        return result;
    }

   /* public Richting getRichtingFromOpleiding(String naam){
        Query query = entityManager.createQuery("select r from Richting r" + "INNER JOIN r.opleiding o " +
                "where r.naam = :naam");
        query.setParameter("naam", naam);

    }*/

    // UPDATE
// DELETE ALL RECORDS
    public int deleteAllRichtingen(){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Richting r");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
