package sheridan.smith.petsassignment.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PetDataRepositoryJdbcImpl implements PetDataRepositoryJdbc {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public PetDataRepositoryJdbcImpl(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate,
            JdbcTemplate jdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(PetEntityJdbc pet) {
        String update = "INSERT INTO pet "
                + "(first_name, last_name, pet_type, pet_gender, pet_vaccination) "
                + "VALUES "
                + "(:first_name, :last_name, :pet_type, :pet_gender, :pet_vaccination)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        GeneratedKeyHolder keys = new GeneratedKeyHolder();
        params.addValue("first_name", pet.getFirstName().trim());
        params.addValue("last_name", pet.getLastName().trim());
        params.addValue("pet_type", pet.getPetType());
        params.addValue("pet_gender", pet.getPetGender());
        params.addValue("pet_vaccination", pet.isPetVaccinated());
        namedParameterJdbcTemplate.update(update, params, keys);
        pet.setId(keys.getKey()!=null?keys.getKey().intValue():0);
    }

    @Override
    public PetEntityJdbc get(int id) {
        String query = "SELECT * FROM pet WHERE ID = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        PetEntityJdbc pet = null;
        params.addValue("id", id);
        try {
            pet = namedParameterJdbcTemplate.queryForObject(
                    query, params, new PetRowMapperJdbc());
        } catch (DataAccessException e) {
            // the code above throws an exception if the record is not found
        }
        return pet;
    }

    @Override
    public List<PetEntityJdbc> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM pet ORDER BY last_name, first_name",
                new PetRowMapperJdbc());
    }

    @Override
    public void update(PetEntityJdbc pet) {
        jdbcTemplate.update(
                "UPDATE pet SET "
                        + "first_name = ?, last_name = ?, "
                        + "pet_type = ?, pet_gender = ?, "
                        + "pet_vaccination = ? "
                        + "WHERE id = ?",
                pet.getFirstName().trim(), pet.getLastName().trim(),
                pet.getPetType(), pet.getPetGender(),
                pet.isPetVaccination(),
                pet.getId());
    }

    @Override
    public void delete(int id) {
        String update = "DELETE FROM pet WHERE id = ?";
        jdbcTemplate.update(update, id);
    }

    @Override
    public void deleteAll() {
        String update = "TRUNCATE TABLE pet";
        jdbcTemplate.update(update);
    }

}
