package com.example.techstore.repository.impl;

import com.example.techstore.model.Admin;
import com.example.techstore.model.Cashier;
import com.example.techstore.model.Manager;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.util.enumerator.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryImpl implements UserRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/users.dat";
    private static ObjectOutputStream usersOutput;

    private static Logger logger = LogManager.getLogger();

    private static void initializeOutput() {
        try {
            usersOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find users data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Failed to read users data.");
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = tryToFindUserByUsername(username);
        return user;
    }

    private User tryToFindUserByUsername(String username) {
        List<User> users = getAll();

        for (User user: users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }


    @Override
    public User create(User user) {
        User created = tryToCreateUser(user);
        return created;
    }

    private User tryToCreateUser(User user) {
        List<User> users = getAll();
        initializeOutput();

        try {
            addUser(user, users);
            usersOutput.writeObject(users);
            usersOutput.flush();
            return user;
        } catch (IOException e) {
            logger.fatal("Failed to create user.");
            e.printStackTrace();
        }

        return null;
    }

    private void addUser(User user, List<User> users) {
        if (user.getRole() == Role.ADMIN) {
            users.add(new Admin(user));
        } else if (user.getRole() == Role.MANAGER) {
            users.add(new Manager(user));
        } else {
            users.add(new Cashier(user));
        }
    }

    @Override
    public List<User> getAll() {
        try {
            ObjectInputStream usersInput = new ObjectInputStream(new FileInputStream(dataLocation));
            return (ArrayList<User>) usersInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find users data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read users data.");
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }


    @Override
    public User update(User user) {
        return null;
    }


    @Override
    public void delete(User user) {

    }
}
