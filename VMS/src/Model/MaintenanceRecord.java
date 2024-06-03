package Model;
import java.sql.*;

import java.sql.Date;

public class MaintenanceRecord {
    private int id;
    private int vehicleId;
    private Date serviceDate;
    private String description;
    private double cost;

    // Constructors
    public MaintenanceRecord() {}

    public MaintenanceRecord(int id, int vehicleId, Date serviceDate, String description, double cost) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MaintenanceRecord{id=" + id + ", vehicleId=" + vehicleId + ", serviceDate=" + serviceDate +
                ", description='" + description + "', cost=" + cost + "}";
    }
}
