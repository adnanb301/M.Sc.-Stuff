import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminPropertyManager implements PropertyOperations {
    private static final String FILE_NAME = "houses.csv";
    private List<House> properties;

    public AdminPropertyManager() {
        this.properties = new ArrayList<>();
        loadPropertiesFromFile();
    }

    @Override
    public void addProperty(House house) {
        properties.add(house);
        savePropertiesToFile();
        System.out.println("Property added successfully and saved to file!");
    }

    @Override
    public List<House> viewProperties() {
        return properties;
    }

    @Override
    public void deleteProperty(int propertyID) throws UnauthorizedAccessException {
        boolean removed = properties.removeIf(house -> house.propertyID.equals(propertyID));
        if (removed) {
            savePropertiesToFile();
            System.out.println("Property deleted successfully and changes saved to file!");
        } else {
            throw new UnauthorizedAccessException("Property with ID " + propertyID + " does not exist or cannot be deleted!");
        }
    }

    public List<House> viewProperties(HouseType.hType houseType) {
        List<House> result = new ArrayList<>();
        for (House house : properties) {
            if (house.houseType.equals(houseType)) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> viewProperties(int beds) {
        List<House> result = new ArrayList<>();
        for (House house : properties) {
            if (house.beds.equals(beds)) {
                result.add(house);
            }
        }
        return result;
    }

    private void savePropertiesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (House house : properties) {
                writer.write(house.propertyID + "," + house.location + "," + house.size + "," +
                        house.price + "," + house.beds + "," + house.baths + "," +
                        house.yard + "," + house.houseType + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving properties to file: " + e.getMessage());
        }
    }

    private void loadPropertiesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    House house = new House(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]),
                            Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]),
                            Boolean.parseBoolean(parts[6]),
                            HouseType.hType.valueOf(parts[7])
                    );
                    properties.add(house);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting with an empty property list.");
        } catch (IOException e) {
            System.out.println("Error reading properties from file: " + e.getMessage());
        }
    }
}
