package sheridan.smith.petsassignment.model;

import javax.validation.constraints.*;
import java.io.Serializable;

public class PetForm implements Serializable {

    private int id = 0;

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*")
    private String firstName = "";

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "[A-Za-z]*")
    private String lastName = "";

    @NotBlank
    @Pattern(regexp = "(Computer Programmer|Systems Technology|Engineering Technician|Systems Technician)?")
    private String petType = "";

    @NotNull
    @Min(1)
    @Max(3)
    private int petGender = 1;

    private boolean petVaccination = false;


    public PetForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String program) {
        this.petType = type;
    }

    public int getPetGender() {
        return petGender;
    }

    public void setPetGender(int gender) {
        this.petGender = gender;
    }

    public boolean isPetVaccination() {
        return petVaccinated;
    }

    public void setPetVaccination(boolean vaccination) {
        this.petVaccination = vaccination;
    }

}
