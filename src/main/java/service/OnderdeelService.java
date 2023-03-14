package service;

import configuration.JPAConfiguration;
import entity.courses.Onderdeel;
import repository.OnderdeelRepository;

import java.util.List;

public class OnderdeelService {
    private final OnderdeelRepository repository;

    public OnderdeelService() {
        this.repository = new OnderdeelRepository(JPAConfiguration.getEntityManager());
    }

    public Onderdeel insertOnderdeel(Onderdeel onderdeel) {
        return repository.createOnderdeel(onderdeel);
    }

    public List<Onderdeel> getAllOnderdelen() {
        return repository.getOnderdelen();
    }

    public Onderdeel getOnderdeelByName(String onderwerp){ return repository.getOnderdeelByName(onderwerp);}

    public List<Onderdeel> getOnderdelenByDocent(int docentId){return repository.getOnderdelenByDocent(docentId);}

    public List<Onderdeel> getOnderdeelNamenByDocent(int id){return repository.getOnderdeelNamenByDocent(id);}
    public int deleteOnderdeel(String onderdeelNaam){ return repository.deleteOnderdeelByName(onderdeelNaam);}

    public int removeDocent(String onderdeelNaam){ return repository.removeDocent(onderdeelNaam);}

    public int addDocent(int idDocent, String naam){return repository.addDocent(idDocent, naam);}

    public Onderdeel addDocent1(Onderdeel addDocent){return repository.add1Docent(addDocent);}

}
