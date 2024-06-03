package DAO;

import Model.MaintenanceRecord;
import Util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceRecordDAO {
    public void addMaintenanceRecord(MaintenanceRecord record) throws SQLException {
        String query = "INSERT INTO MaintenanceRecord (vehicle_id, service_date, description, cost) VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, record.getVehicleId());
            pst.setDate(2, record.getServiceDate());
            pst.setString(3, record.getDescription());
            pst.setDouble(4, record.getCost());
            pst.executeUpdate();
        }
    }

    public List<MaintenanceRecord> getAllMaintenanceRecords() throws SQLException {
        String query = "SELECT * FROM MaintenanceRecord";
        List<MaintenanceRecord> records = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                MaintenanceRecord record = new MaintenanceRecord();
                record.setId(rs.getInt("id"));
                record.setVehicleId(rs.getInt("vehicle_id"));
                record.setServiceDate(rs.getDate("service_date"));
                record.setDescription(rs.getString("description"));
                record.setCost(rs.getDouble("cost"));
                records.add(record);
            }
        }
        return records;
    }


}
