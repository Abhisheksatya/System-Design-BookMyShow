package in.scaler.bookmyshow.services;

import in.scaler.bookmyshow.exceptions.UserNotFoundException;
import in.scaler.bookmyshow.models.User;
import in.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signup(String name,
                       String email,
                       String password) {

        /*
        1. Check if the user already exists with the given email id.
        2. If yes, ask the user to login.
        2. If not, create a new user object with the given details.
        3. save it to DB.
         */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public User login(String email, String password) throws UserNotFoundException {
        //select * from users where email = ?
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with email: " + email + " not found");
        }

        User user = optionalUser.get();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //Compare the password
//        if (bCryptPasswordEncoder.encode(password).equals(user.getPassword())) {
//
//        }

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            //Login successfull.
            return user;
        }
        throw new RuntimeException("Password mismatch");
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseGet((Supplier<? extends User>) new RuntimeException("No record found"));
    }


}