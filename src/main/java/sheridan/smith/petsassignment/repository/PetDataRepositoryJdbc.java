package sheridan.smith.petsassignment.repository;

import java.util.List;

public interface PetDataRepositoryJdbc {
    void insert(PetEntityJdbc pet);
    PetEntityJdbc get(int id);
    List<PetEntityJdbc> getAll();
    void update(PetEntityJdbc pet);
    void delete(int id);
    void deleteAll();
}
