import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthenticationManager authManager = new AuthenticationManager();
        AdminPropertyManager adminManager = new AdminPropertyManager();
        Scanner scanner = new Scanner(System.in);


        System.out.println("       _____                                         _                 __  __                                                                     _                                  ");
        System.out.println("      |  __ \\                                       | |               |  \\/  |                                                                   | |           /\\                    ");
        System.out.println("      | |__) |  _ __    ___    _ __     ___   _ __  | |_   _   _      | \\  / |   __ _   _ __     __ _    __ _    ___   _ __ ___     ___   _ __   | |_         /  \\     _ __    _ __  ");
        System.out.println("      |  ___/  | '__|  / _ \\  | '_ \\   / _ \\ | '__| | __| | | | |     | |\\/| |  / _` | | '_ \\   / _` |  / _` |  / _ \\ | '_ ` _ \\   / _ \\ | '_ \\  | __|       / /\\ \\   | '_ \\  | '_ \\ ");
        System.out.println("      | |      | |    | (_) | | |_) | |  __/ | |    | |_  | |_| |     | |  | | | (_| | | | | | | (_| | | (_| | |  __/ | | | | | | |  __/ | | | | | |_       / ____ \\  | |_) | | |_) |");
        System.out.println("      |_|      |_|     \\___/  | .__/   \\___| |_|     \\__|  \\__, |     |_|  |_|  \\__,_| |_| |_|  \\__,_|  \\__, |  \\___| |_| |_| |_|  \\___| |_| |_|  \\__|     /_/    \\_\\ | .__/  | .__/ ");
        System.out.println("                              | |                           __/ |                                        __/ |                                                        | |     | |    ");
        System.out.println("                              |_|                          |___/                                        |___/                                                         |_|     |_|    ");


        try {
            // Authentication process
            System.out.println();
            System.out.println("Only authenticated users can access this app! ");
            System.out.println("============================================ ");
            System.out.println();
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            String role = authManager.authenticate(username, password);
            System.out.println("Login successful! Role: " + role);

            if ("ADMIN".equals(role)) {
                adminActions(scanner, adminManager);
            } else if ("USER".equals(role)) {
                userActions(adminManager);
            }
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    private static void adminActions(Scanner scanner, AdminPropertyManager adminManager) {
        while (true) {
            System.out.println("\nAdmin Options:");
            System.out.println("1. Add Property");
            System.out.println("2. View All Properties");
            System.out.println("3. View Properties by Type");
            System.out.println("4. View Properties by Number of Beds");
            System.out.println("5. Delete Property");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Collect property details interactively
                    System.out.println("Enter Property ID: ");
                    int propertyID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Enter Location: ");
                    String location = scanner.nextLine();

                    System.out.println("Enter Size (in sqm): ");
                    double size = scanner.nextDouble();

                    System.out.println("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.println("Enter Number of Beds: ");
                    int beds = scanner.nextInt();

                    System.out.println("Enter Number of Baths: ");
                    int baths = scanner.nextInt();

                    System.out.println("Does it have a yard? (true/false): ");
                    boolean yard = scanner.nextBoolean();

                    System.out.println("Enter House Type (1-Apartment, 2-SemiDetached, 3-Detached): ");
                    int typeChoice = scanner.nextInt();
                    HouseType.hType houseType = switch (typeChoice) {
                        case 1 -> HouseType.hType.typeApartment;
                        case 2 -> HouseType.hType.typeSemiDetached;
                        case 3 -> HouseType.hType.typeDetached;
                        default -> throw new IllegalArgumentException("Invalid type choice");
                    };

                    House house = new House(propertyID, location, size, price, beds, baths, yard, houseType);
                    adminManager.addProperty(house);
                }
                case 2 -> {
                    // View all properties
                    for (House house : adminManager.viewProperties()) {
                        house.displayDetails();
                        System.out.println();
                    }
                }
                case 3 -> {
                    // View properties by type
                    System.out.println("Enter House Type (1-Apartment, 2-SemiDetached, 3-Detached): ");
                    int typeChoice = scanner.nextInt();
                    HouseType.hType houseType = switch (typeChoice) {
                        case 1 -> HouseType.hType.typeApartment;
                        case 2 -> HouseType.hType.typeSemiDetached;
                        case 3 -> HouseType.hType.typeDetached;
                        default -> throw new IllegalArgumentException("Invalid type choice");
                    };
                    for (House house : adminManager.viewProperties(houseType)) {
                        house.displayDetails();
                        System.out.println();
                    }
                }
                case 4 -> {
                    // View properties by number of beds
                    System.out.println("Enter Number of Beds: ");
                    int beds = scanner.nextInt();
                    for (House house : adminManager.viewProperties(beds)) {
                        house.displayDetails();
                        System.out.println();
                    }
                }
                case 5 -> {
                    // Delete a property
                    System.out.println("Enter Property ID to delete: ");
                    int propertyID = scanner.nextInt();
                    try {
                        adminManager.deleteProperty(propertyID);
                    } catch (UnauthorizedAccessException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 6 -> {
                    // Exit
                    System.out.println("Exiting admin panel...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void userActions(AdminPropertyManager adminManager) {
        while (true) {
            System.out.println("\nUser Options:");
            System.out.println("1. View All Properties");
            System.out.println("2. View Properties by Type");
            System.out.println("3. View Properties by Number of Beds");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // View all properties
                    for (House house : adminManager.viewProperties()) {
                        house.displayDetails();
                        System.out.println();
                    }
                }
                case 2 -> {
                    // View properties by type
                    System.out.println("Enter House Type (1-Apartment, 2-SemiDetached, 3-Detached): ");
                    int typeChoice = scanner.nextInt();
                    HouseType.hType houseType = switch (typeChoice) {
                        case 1 -> HouseType.hType.typeApartment;
                        case 2 -> HouseType.hType.typeSemiDetached;
                        case 3 -> HouseType.hType.typeDetached;
                        default -> throw new IllegalArgumentException("Invalid type choice");
                    };
                    for (House house : adminManager.viewProperties(houseType)) {
                        house.displayDetails();
                        System.out.println();
                    }
                }
                case 3 -> {
                    // View properties by number of beds
                    System.out.println("Enter Number of Beds: ");
                    int beds = scanner.nextInt();
                    for (House house : adminManager.viewProperties(beds)) {
                        house.displayDetails();
                        System.out.println();
                    }
                }
                case 4 -> {
                    // Exit
                    System.out.println("Exiting user panel...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
