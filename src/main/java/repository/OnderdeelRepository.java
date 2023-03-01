package repository;

import entity.courses.Onderdeel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class OnderdeelRepository {
    private EntityManager entityManager;

    public OnderdeelRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE
    public Onderdeel createOnderdeel(Onderdeel onderdeel) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(onderdeel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return onderdeel;
    }

    // READ-ALL
    public List<Onderdeel> getOnderdelen() {
        String query = "select ond from Onderdeel ond";
        TypedQuery<Onderdeel> typedQuery = entityManager.createQuery(query, Onderdeel.class);
        List<Onderdeel> onderdeelList = typedQuery.getResultList();
        return onderdeelList;
    }

    // READ or GET 1 RECORD
    public Onderdeel getOnderdeelByName(String onderdeelNaam) {
        Query query = entityManager.createQuery("select o from Onderdeel o where o.naam = :naam ");
        query.setParameter("naam", onderdeelNaam);
        Onderdeel result = (Onderdeel) query.getSingleResult();

        return result;
    }

    public List<Onderdeel> getOnderdelenByDocent(int docentId){
        Query query = entityManager.createQuery("select o from Onderdeel o inner join o.docent d where d.id = :id");
        query.setParameter("id", docentId);
        List<Onderdeel> alleOnderdelen = query.getResultList();
        return alleOnderdelen;
    }

// UPDATE

    // DELETE ALL RECORDS
    public int deleteAllOnderdelen(){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Onderdeel o");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }



    // DELETE SPECIFIC RECORD
    public int deleteOnderdeelByName(String onderdeelNaam){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Onderdeel o WHERE o.naam = :naam");
        query.setParameter("naam", onderdeelNaam);
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;

    }

    // DELETE ENTITY OBJECT AND ITS OTHER ASSOCIATED ENTITY'S OBJECTS (that referenced them)
    public void deleteOnderdeel(Onderdeel onderdeel){
        try {
            entityManager.getTransaction().begin();
            System.out.println("Onderdeel record: " + onderdeel.getNaam() + " " +
                    "has been deleted.");
            entityManager.remove(onderdeel);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }


    }

}
