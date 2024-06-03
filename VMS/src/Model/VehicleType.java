package Model;

public class VehicleType {
    private int id;
    private String typeName;

    // Constructors
    public VehicleType() {}

    public VehicleType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "VehicleType{id=" + id + ", typeName='" + typeName + "'}";
    }
}
