package sheridan.smith.petsassignment.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRowMapperJdbc implements RowMapper<PetEntityJdbc> {

    @Override
    public PetEntityJdbc mapRow(ResultSet rs, int rowNum) throws SQLException {
        PetEntityJdbc entityJdbc = new PetEntityJdbc();
        entityJdbc.setId(rs.getInt("id"));
        entityJdbc.setFirstName(rs.getString("first_name"));
        entityJdbc.setLastName(rs.getString("last_name"));
        entityJdbc.setPetType(rs.getString("pet_type"));
        entityJdbc.setPetGender(rs.getInt("pet_gender"));
        entityJdbc.setPetVaccination(rs.getBoolean("pet_vaccination"));
        return entityJdbc;
    }
}
