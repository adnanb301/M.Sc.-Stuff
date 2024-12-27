import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private Map<String, String[]> users;

    public AuthenticationManager() {
        users = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.put(parts[0], new String[]{parts[1], parts[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }

    public String authenticate(String username, String password) throws AuthenticationException {
        if (users.containsKey(username)) {
            String[] details = users.get(username);
            if (details[0].equals(password)) {
                return details[1]; // Return role
            }
        }
        throw new AuthenticationException("Invalid username or password!");
    }
}
