package repository;

import entity.courses.ModuleDuur;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ModuleRepository {
    private EntityManager entityManager;

    public ModuleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE
    public ModuleDuur createModule(ModuleDuur module) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(module);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return module;
    }

    // READ-ALL
    public List<ModuleDuur> getModules() {
        String query = "select md from ModuleDuur md";
        TypedQuery<ModuleDuur> typedQuery = entityManager.createQuery(query, ModuleDuur.class);
        List<ModuleDuur> moduleList = typedQuery.getResultList();
        return moduleList;
    }

    public List<ModuleDuur> getAllModulesfromRichting(int id){
        Query query = entityManager.createQuery("select m from ModuleDuur m " + "INNER JOIN m.richting r " +
                "where r.id = :id");
        query.setParameter("id", id);
        List<ModuleDuur> moduleList = query.getResultList();
        /*TypedQuery<Richting> typedQuery = entityManager.createQuery(query, Richting.class);
        List<Richting> richtingList = typedQuery.getResultList();*/
        return moduleList;
    }

    // READ or GET 1 RECORD
    public ModuleDuur getModuleByName(String moduleNaam) {
        Query query = entityManager.createQuery("select md from ModuleDuur md where md.naam = :naam ");
        query.setParameter("naam", moduleNaam);
        ModuleDuur result = (ModuleDuur) query.getSingleResult();

        return result;
    }

    public ModuleDuur getModuleById(int moduleId) {
        Query query = entityManager.createQuery("select md from ModuleDuur md where md.id = :id ");
        query.setParameter("id", moduleId);
        ModuleDuur result = (ModuleDuur) query.getSingleResult();

        return result;
    }

// UPDATE

    // DELETE ALL RECORDS
    public int deleteAllModules(){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from ModuleDuur md");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    // DELETE SPECIFIC RECORD
    public int deleteModuleByName(String moduleNaam){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from ModuleDuur md WHERE md.naam = :naam");
        query.setParameter("naam", moduleNaam);
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    // DELETE ENTITY OBJECT AND ITS OTHER ASSOCIATED ENTITY'S OBJECTS (that referenced them)
    public void deleteModule(ModuleDuur module){
        try {
            entityManager.getTransaction().begin();
            System.out.println("Module record: " + module.getNaam() + " " +
                    "has been deleted.");
            entityManager.remove(module);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }


    }

}
