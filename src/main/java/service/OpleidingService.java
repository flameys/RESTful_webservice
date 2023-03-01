package service;

import configuration.JPAConfiguration;
import entity.courses.Opleiding;
import repository.OpleidingRepository;

import java.util.List;

public class OpleidingService {
    private final OpleidingRepository repository;

    public OpleidingService() {
        this.repository = new OpleidingRepository(JPAConfiguration.getEntityManager());
    }

    public Opleiding createOpleiding(Opleiding opleiding) {
        return repository.createOpleiding(opleiding);
    }

    public List<Opleiding> getAllOpleidingen() {
        return repository.getOpleidingen();
    }

    public Opleiding getOneOpleiding(String oplNaam){return repository.getOpleiding(oplNaam);}

}
