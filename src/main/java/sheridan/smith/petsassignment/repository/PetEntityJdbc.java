package sheridan.smith.petsassignment.repository;

public class PetEntityJdbc {

    private int id = 0;
    private String firstName = "";
    private String lastName = "";
    private String petType = "";
    private int petGender = 1;
    private boolean petVaccination = false;

    public PetEntityJdbc() {
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

    public void setPetType(String type) {
        this.petType = type;
    }

    public int getPetGender() {
        return petGender;
    }

    public void setPetGender(int gender) {
        this.petGender = gender;
    }

    public boolean isPetVaccination() {
        return petVaccination;
    }

    public void setPetVaccination(boolean vaccination) {
        this.petVaccination = vaccination;
    }

}
