package DAO;

import Model.VehicleType;
import Util.DBUtil;
import java.util.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class VehicleTypeDAO {
    public void addVehicleType(VehicleType type) throws SQLException {
        String query = "INSERT INTO VehicleType (type_name) VALUES (?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, type.getTypeName());
            pst.executeUpdate();
        }
    }

    public List<VehicleType> getAllVehicleTypes() throws SQLException {
        String query = "SELECT * FROM VehicleType";
        List<VehicleType> types = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                VehicleType type = new VehicleType();
                type.setId(rs.getInt("id"));
                type.setTypeName(rs.getString("type_name"));
                types.add(type);
            }
        }
        return types;
    }

    // Implement other methods such as updateVehicleType, deleteVehicleType, getVehicleTypeById
}
