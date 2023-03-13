package service;

import configuration.JPAConfiguration;
import entity.Docent;
import repository.DocentRepository;

import java.util.List;

public class DocentService {
    private final DocentRepository repository;

    public DocentService() {
        this.repository = new DocentRepository(JPAConfiguration.getEntityManager());
    }

    public Docent insertDocent(Docent docent) {
        return repository.createDocent(docent);
    }

    public List<Docent> getAllDocenten() {
        return repository.getDocenten();
    }

    public Docent getDocentById(int docentId){return repository.getDocentById(docentId);}

    public Docent getSpecificDocent(String voornaam, String achternaam){return repository.getDocentByName(voornaam, achternaam);}

    public void deleteDocent(Docent docent){
        repository.deleteDocent(docent);
    }

    public int changeDocent(String achternaam, String voornaam, String datum, int docentId){
        return repository.updateDocent(achternaam, voornaam, datum, docentId);
    }

}
