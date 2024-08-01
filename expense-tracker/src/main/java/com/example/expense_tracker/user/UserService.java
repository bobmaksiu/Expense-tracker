package com.example.expense_tracker.user;

import com.example.expense_tracker.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    public List<User> retrieveAllUsers() { return userRepository.findAll();}

    public User retrieveUserById(int id) { return userRepository.findById(id)
            .orElseThrow(UserNotFoundException::new);}

    public User addUser(User user) { return userRepository.save(user);}

    public User updateUser(int id, User user){
        User userToUpdate = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userToUpdate.setId(user.getId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setExpenseList(user.getExpenseList());
        return userRepository.save(userToUpdate);

    }

    public void deleteUser(int id) { userRepository.delete(retrieveUserById(id));}

}
