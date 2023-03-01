package service;

import configuration.JPAConfiguration;
import entity.courses.Richting;
import repository.RichtingRepository;

import java.util.List;

public class RichtingService {
    private final RichtingRepository repository;

    public RichtingService() {
        this.repository = new RichtingRepository(JPAConfiguration.getEntityManager());
    }

    public Richting insertRichting(Richting richting) {
        return repository.createRichting(richting);
    }

    public List<Richting> getAllRichtingen() {
        return repository.getRichtingen();
    }

    public List<Richting> getAllRichtingOpleiding(int id){return repository.getAllRichtingfromOpleiding(id);}

    public Richting getSpecificRichting(String richtingNaam){ return repository.getRichtingByName(richtingNaam);}

    public Richting getRichtingOpleiding(int id){return repository.getRichtingfromOpleiding(id);}

}
