import com.example.entity.Flight;
import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //user entity test
        UserRepository userRepo = new UserRepository();
        User user1 = new User("test user 1", "password1", "tester");
        User user2 = new User("test user 2", "password2", "developer");
        User user3 = new User("test user 3", "password3", "tester");
        userRepo.saveUser(user1);
        userRepo.saveUser(user2);
        userRepo.saveUser(user3);


    }
}
