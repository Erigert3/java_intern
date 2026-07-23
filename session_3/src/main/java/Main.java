import com.example.entity.Flight;
import com.example.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-example-pu");

        EntityManager em = emf.createEntityManager();

        System.out.println("Connected successfully!");

        em.getTransaction().begin();
        createNewUser(em, "User", "test", "role");
        createNewFlight(em, "TIA", "FRA", "ITA");
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    private static void createNewUser(EntityManager em, String username, String password, String role){
        User user = new User(username, password, role);
        em.persist(user);
    }

    private static void createNewFlight(EntityManager em, String origin, String destination, String airline){
        Flight flight = new Flight(origin, destination, airline);
        em.persist(flight);
    }
}
