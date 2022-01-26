package com.example.techstore.repository.impl;

import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.util.io.MyObjectOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryImpl implements UserRepository {
    private static List<User> users;
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/users.dat";
    public static ObjectOutputStream usersOutput;
    private static Logger logger = LogManager.getLogger();

    static {
        getUsers();
        initializeOutput();
    }

    private static void getUsers() {
        try {
            ObjectInputStream usersInput = new ObjectInputStream(new FileInputStream(dataLocation));
            users = (List<User>) usersInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find users data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            logger.fatal("Couldn't read users data.");
            e.printStackTrace();
            users = new ArrayList<>();
        }
    }

    private static void initializeOutput() {
        try {
            usersOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find users data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Couldn't read users data.");
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = tryToFindUserByUsername(username);
        return user;
    }

    private static User tryToFindUserByUsername(String username) {
        getUsers();

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

    private static User tryToCreateUser(User user) {
        User created = null;

        try {
            users.add(created);
            usersOutput.writeObject(users);
            usersOutput.flush();
            created = user;
        } catch (IOException e) {
            logger.fatal("Couldn't create user.");
            e.printStackTrace();
        }

        return created;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
