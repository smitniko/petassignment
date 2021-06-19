package sheridan.smith.petsassignment.service;

import sheridan.smith.petsassignment.model.PetForm;
import sheridan.smith.petsassignment.repository.PetDataRepositoryJdbc;
import sheridan.smith.petsassignment.repository.PetEntityJdbc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class PetDataServiceJdbcImpl implements PetDataService {

    PetDataRepositoryJdbc petDataRepositoryJdbc;

    public PetDataServiceJdbcImpl(PetDataRepositoryJdbc repository){
        this.petDataRepositoryJdbc = repository;
    }

    private static void copyFormToEntity(PetForm form, PetEntityJdbc pet){
        //pet.setId(form.getId());
        pet.setFirstName(form.getFirstName());
        pet.setLastName(form.getLastName());
        pet.setPetType(form.getPetType());
        pet.setPetGender(form.getPetGender());
        pet.setPetVaccination(form.isPetVaccinated());
    }

    private static void copyEntityToForm(PetEntityJdbc pet, PetForm form){
        form.setId(pet.getId());
        form.setFirstName(pet.getFirstName());
        form.setLastName(pet.getLastName());
        form.setPetType(pet.getPetType());
        form.setPetGender(pet.getPetGender());
        form.setPetVaccination(pet.isPetVaccinated());
    }


    public void insertPetForm(PetForm form){
        PetEntityJdbc pet = new PetEntityJdbc();
        copyFormToEntity(form, pet);
        petDataRepositoryJdbc.insert(pet);
        form.setId(pet.getId());
    }

    public PetForm getPetForm(int id){
        PetEntityJdbc pet = petDataRepositoryJdbc.get(id);
        if(pet != null){
            PetForm form = new PetForm();
            copyEntityToForm(pet, form);
            return form;
        }else{
            return null;
        }

    }

    public List<PetForm> getAllPetForms(){
        List<PetForm> forms = new ArrayList<>();
        List<PetEntityJdbc> pets = petDataRepositoryJdbc.getAll();
        for(PetEntityJdbc entity: pets){
            PetForm form = new PetForm();
            copyEntityToForm(entity, form);
            forms.add(form);
        }
        return forms;
    }

    public void updatePetForm(PetForm form){
        PetEntityJdbc pet = petDataRepositoryJdbc.get(form.getId());
        if(pet != null){
            copyFormToEntity(form, pet);
            petDataRepositoryJdbc.update(pet);
        }
    }

    public void deletePetForm(int id){
        petDataRepositoryJdbc.delete(id);
    }

    public void deleteAllPetForms(){
        petDataRepositoryJdbc.deleteAll();
    }
}
