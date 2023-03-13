package repository;

import entity.Docent;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DocentRepository {
    private EntityManager entityManager;

    public DocentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE
    public Docent createDocent(Docent addDocent) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(addDocent);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addDocent;
    }

    // READ-ALL
    public List<Docent> getDocenten() {
        String query = "select d from Docent d";
        TypedQuery<Docent> typedQuery = entityManager.createQuery(query, Docent.class);
        List<Docent> docentList = typedQuery.getResultList();
        return docentList;
    }

    // READ or GET 1 RECORD
    public Docent getDocentByName(String docentVoornaam, String docentAchternaam) {
        Query query = entityManager.createQuery("select d from Docent d where d.voornaam = :voornaam " +
                "and d.naam = :achternaam");
        query.setParameter("voornaam", docentVoornaam);
        query.setParameter("achternaam", docentAchternaam);
        Docent result = (Docent) query.getSingleResult();

        return result;
    }

    public Docent getDocentById(int docentId) {
        Query query = entityManager.createQuery("select d from Docent d where d.id = :id ");
        query.setParameter("id", docentId);
        Docent result = (Docent) query.getSingleResult();

        return result;
    }

// UPDATE

    public int updateDocent(String achternaam, String voornaam, String datum, int docentId) {
        int rowsUpdated;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Docent d SET d.naam = :naam, d.voornaam = :voornaam, d.datumIndienst = :datum " +
                "where d.id = :id ");
        query.setParameter("naam", achternaam);
        query.setParameter("voornaam", voornaam);
        query.setParameter("datum", datum);
        query.setParameter("id", docentId);
        rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();

        return rowsUpdated;
    }

    // DELETE ALL RECORDS
    public int deleteAllDocenten() {
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Docent d");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    // DELETE SPECIFIC RECORD
    public int deleteDocentByName(String docentNaam) {
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Docent d WHERE d.voornaam = :voornaam");
        query.setParameter("voornaam", docentNaam);
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;

    }

   /* public int deleteDocentByName(int docentId) {
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE o.docent from Onderdeel o");
        query.setParameter("voornaam", docentNaam);
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;

    }*/

    // DELETE ENTITY OBJECT AND ITS OTHER ASSOCIATED ENTITY'S OBJECTS (that referenced them)
    public void deleteDocent(Docent docent) {
        try {
            entityManager.getTransaction().begin();
            System.out.println("Docent record: " + docent.getVoornaam() + " " +
                    docent.getNaam() + " " + "has been deleted.");
            entityManager.remove(docent);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }


    }

}
