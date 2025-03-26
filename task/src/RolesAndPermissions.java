import java.util.HashMap;
import java.util.Map;

public class RolesAndPermissions {
    private Map<String, String> adminCredentials = new HashMap<>();
    private Map<String, String> passengerCredentials = new HashMap<>();

    public boolean isPrivilegedUser(String username, String password) {
        return adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password);
    }

    public boolean registerAdmin(String username, String password) {
        if (adminCredentials.containsKey(username)) return false;
        adminCredentials.put(username, password);
        return true;
    }

    public String isPassengerRegistered(String email, String password) {
        return passengerCredentials.containsKey(email) && passengerCredentials.get(email).equals(password)
                ? email
                : null;
    }

    public void registerPassenger(String email, String password) {
        passengerCredentials.put(email, password);
    }
}
