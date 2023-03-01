package service;

import configuration.JPAConfiguration;
import entity.courses.ModuleDuur;
import repository.ModuleRepository;

import java.util.List;

public class ModuleService {
    private final ModuleRepository repository;

    public ModuleService() {
        this.repository = new ModuleRepository(JPAConfiguration.getEntityManager());
    }

    public ModuleDuur insertModule(ModuleDuur module) {
        return repository.createModule(module);
    }

    public List<ModuleDuur> getAllModules() {return repository.getModules();}

    public List<ModuleDuur> getModules(int id){return repository.getAllModulesfromRichting(id);}

    public ModuleDuur getSpecificModule(String moduleNaam){ return repository.getModuleByName(moduleNaam);}

    public ModuleDuur getSpecificModuleById(int moduleId){ return repository.getModuleById(moduleId);}

}
