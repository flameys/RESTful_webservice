package repository;

import entity.StudentDetail;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDetailRepository {
    private EntityManager entityManager;

    public StudentDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE
    public StudentDetail createStudentDetail(StudentDetail addStudentDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(addStudentDetail);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addStudentDetail;
    }

    // READ-ALL
    public List<StudentDetail> getStudentDetails() {
        String query = "select sd from StudentDetail sd";
        TypedQuery<StudentDetail> typedQuery = entityManager.createQuery(query, StudentDetail.class);
        List<StudentDetail> studentDetailList = typedQuery.getResultList();
        return studentDetailList;
    }

    // DELETE ALL RECORDS
    public int deleteAllStudentDetails(){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from StudentDetail sd");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    //UPDATE
    public int updateStudentDetailAdres(String adres, int studentId){
        int rowsUpdated;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE StudentDetail sd SET sd.adress = :adres " +
                "where sd.id = :id ");
        query.setParameter("adres", adres);
        query.setParameter("id", studentId);
        rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();

        return rowsUpdated;
    }

    public int updateStudentDetailTelno(String tel, int studentId){
        int rowsUpdated;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE StudentDetail sd SET sd.telefoon_nummer = :telno " +
                "where sd.id = :id ");
        query.setParameter("telno", tel);
        query.setParameter("id", studentId);
        rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();

        return rowsUpdated;
    }

    public int deleteStudenDetailById(int id){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from StudentDetail sd where sd.id = :id");
        query.setParameter("id", id);
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;

    }

}
