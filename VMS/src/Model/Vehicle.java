package Model;

public class Vehicle {
    private int id;
    private String make;
    private String model;
    private int year;
    private String registrationNumber;
    private int ownerId;
    private int typeId;

    // Constructors
    public Vehicle() {}

    public Vehicle(int id, String make, String model, int year, String registrationNumber, int ownerId, int typeId) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
        this.ownerId = ownerId;
        this.typeId = typeId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Vehicle{id=" + id + ", make='" + make + "', model='" + model + "', year=" + year +
                ", registrationNumber='" + registrationNumber + "', ownerId=" + ownerId + ", typeId=" + typeId + "}";
    }
}
