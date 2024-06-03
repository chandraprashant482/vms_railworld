package DAO;

import Model.Owner;
import Util.DBUtil;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
    public void addOwner(Owner owner) throws SQLException {
        String query = "INSERT INTO Owner (name, address, phone) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, owner.getName());
            pst.setString(2, owner.getAddress());
            pst.setString(3, owner.getPhone());
            pst.executeUpdate();
        }
    }

    public List<Owner> getAllOwners() throws SQLException {
        String query = "SELECT * FROM Owner";
        List<Owner> owners = new ArrayList<>();
        try (Connection con = DBUtil.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Owner owner = new Owner();
                owner.setId(rs.getInt("id"));
                owner.setName(rs.getString("name"));
                owner.setAddress(rs.getString("address"));
                owner.setPhone(rs.getString("phone"));
                owners.add(owner);
            }
        }
        return owners;
    }

    // Implement other methods such as updateOwner, deleteOwner, getOwnerById
}

