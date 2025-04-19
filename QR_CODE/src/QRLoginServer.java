import java.util.HashMap;
import java.util.Map;

public class QRLoginServer {
    private static Map<String, String> tokenDatabase = new HashMap<>();

    public static void storeToken(String userId, String token) {
        tokenDatabase.put(token, userId);
    }

    public static boolean validateToken(String token) {
        return tokenDatabase.containsKey(token);
    }

    public static void main(String[] args) {
        String userId = "user123";
        String token = "ABC123";

        storeToken(userId, token);

        // Simulăm verificarea tokenului
        String receivedToken = "ABC123";
        if (validateToken(receivedToken)) {
            System.out.println("Autentificare reușită pentru utilizatorul: " + tokenDatabase.get(receivedToken));
        } else {
            System.out.println("Token invalid!");
        }
    }
}
