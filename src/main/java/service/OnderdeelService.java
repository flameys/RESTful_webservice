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

    public int deleteOnderdeel(String onderdeelNaam){ return repository.deleteOnderdeelByName(onderdeelNaam);}

}
