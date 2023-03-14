package service;

import configuration.JPAConfiguration;
import entity.StudentDetail;
import repository.StudentDetailRepository;

public class StudentDetailService {
    private StudentDetailRepository studentDetailRepository;

    public StudentDetailService() {
        this.studentDetailRepository = new StudentDetailRepository(JPAConfiguration.getEntityManager()); }

    public StudentDetail createStudentDetail(StudentDetail studentDetail){ return studentDetailRepository.createStudentDetail(studentDetail); }

    public int deleteStudentdetailById(int id){return studentDetailRepository.deleteStudenDetailById(id);}

    public int updateStudentdetailAdres(String adres, int id){return studentDetailRepository.updateStudentDetailAdres(adres, id);}

    public int updateStudentdetailTel(String telno, int id){return studentDetailRepository.updateStudentDetailTelno(telno, id);}

    public StudentDetail updateStudentDetail(StudentDetail detail){return studentDetailRepository.updateDetail(detail);}

}
