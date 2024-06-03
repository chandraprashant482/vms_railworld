import DAO.MaintenanceRecordDAO;
import DAO.OwnerDAO;
import DAO.VehicleDAO;
import DAO.VehicleTypeDAO;
import Model.MaintenanceRecord;
import Model.Owner;
import Model.Vehicle;
import Model.VehicleType;
import java.sql.Date;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class VehicleManagementSystem {
    private static VehicleDAO vehicleDAO = new VehicleDAO();
    private static OwnerDAO ownerDAO = new OwnerDAO();
    private static VehicleTypeDAO vehicleTypeDAO = new VehicleTypeDAO();
    private static MaintenanceRecordDAO maintenanceRecordDAO = new MaintenanceRecordDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Vehicle Management System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Add Owner");
            System.out.println("4. View All Owners");
            System.out.println("5. Add Vehicle Type");
            System.out.println("6. View All Vehicle Types");
            System.out.println("7. Add Maintenance Record");
            System.out.println("8. View All Maintenance Records");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        addVehicle(scanner);
                        break;
                    case 2:
                        viewAllVehicles();
                        break;
                    case 3:
                        addOwner(scanner);
                        break;
                    case 4:
                        viewAllOwners();
                        break;
                    case 5:
                        addVehicleType(scanner);
                        break;
                    case 6:
                        viewAllVehicleTypes();
                        break;
                    case 7:
                        addMaintenanceRecord(scanner);
                        break;
                    case 8:
                        viewAllMaintenanceRecords();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addVehicle(Scanner scanner) throws SQLException, SQLException {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter registration number: ");
        String registrationNumber = scanner.nextLine();
        System.out.print("Enter owner ID: ");
        int ownerId = scanner.nextInt();
        System.out.print("Enter vehicle type ID: ");
        int typeId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Vehicle vehicle = new Vehicle();
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setYear(year);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setOwnerId(ownerId);
        vehicle.setTypeId(typeId);

        try {
            vehicleDAO.addVehicle(vehicle);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Vehicle added successfully.");
    }

    private static void viewAllVehicles() throws SQLException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void addOwner(Scanner scanner) throws SQLException {
        System.out.print("Enter owner name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Owner owner = new Owner();
        owner.setName(name);
        owner.setAddress(address);
        owner.setPhone(phone);

        ownerDAO.addOwner(owner);
        System.out.println("Owner added successfully.");
    }

    private static void viewAllOwners() throws SQLException {
        List<Owner> owners = ownerDAO.getAllOwners();
        for (Owner owner : owners) {
            System.out.println(owner);
        }
    }

    private static void addVehicleType(Scanner scanner) throws SQLException {
        System.out.print("Enter vehicle type name: ");
        String typeName = scanner.nextLine();

        VehicleType type = new VehicleType();
        type.setTypeName(typeName);

        vehicleTypeDAO.addVehicleType(type);
        System.out.println("Vehicle type added successfully.");
    }

    private static void viewAllVehicleTypes() throws SQLException {
        List<VehicleType> types = vehicleTypeDAO.getAllVehicleTypes();
        for (VehicleType type : types) {
            System.out.println(type);
        }
    }

    private static void addMaintenanceRecord(Scanner scanner) throws SQLException, SQLException {
        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        System.out.print("Enter service date (yyyy-mm-dd): ");
        Date serviceDate = Date.valueOf(scanner.next());
        scanner.nextLine(); // consume newline
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter cost: ");
        double cost = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        MaintenanceRecord record = new MaintenanceRecord();
        record.setVehicleId(vehicleId);
        record.setServiceDate(serviceDate);
        record.setDescription(description);
        record.setCost(cost);

        maintenanceRecordDAO.addMaintenanceRecord(record);
        System.out.println("Maintenance record added successfully.");
    }

    private static void viewAllMaintenanceRecords() throws SQLException {
        List<MaintenanceRecord> records = maintenanceRecordDAO.getAllMaintenanceRecords();
        for (MaintenanceRecord record : records) {
            System.out.println(record);
        }
    }
}
