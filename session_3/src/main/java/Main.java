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

        /*User user1 = new User("test user 4", "password4", "tester");
        User user2 = new User("test user 5", "password5", "developer");
        User user3 = new User("test user 6", "password6", "tester");

        userRepo.saveUser(user2);
        userRepo.saveUser(user3);
        userRepo.saveUser(user1);*/

        /*userRepo.deleteUser(1);
        userRepo.deleteUser(2);
        userRepo.deleteUser(3);*/

        System.out.println(userRepo.getAllUsers());

    }
}
