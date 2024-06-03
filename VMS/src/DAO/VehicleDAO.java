package DAO;

import Model.Vehicle;
import Util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public void addVehicle(Vehicle vehicle) throws SQLException {
        String query = "INSERT INTO Vehicle (make, model, year, registration_number, owner_id, type_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, vehicle.getMake());
            pst.setString(2, vehicle.getModel());
            pst.setInt(3, vehicle.getYear());
            pst.setString(4, vehicle.getRegistrationNumber());
            pst.setInt(5, vehicle.getOwnerId());
            pst.setInt(6, vehicle.getTypeId());
            pst.executeUpdate();
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        String query = "SELECT * FROM Vehicle";
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setMake(rs.getString("make"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setYear(rs.getInt("year"));
                vehicle.setRegistrationNumber(rs.getString("registration_number"));
                vehicle.setOwnerId(rs.getInt("owner_id"));
                vehicle.setTypeId(rs.getInt("type_id"));
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    // Implement other methods such as updateVehicle, deleteVehicle, getVehicleById
}
