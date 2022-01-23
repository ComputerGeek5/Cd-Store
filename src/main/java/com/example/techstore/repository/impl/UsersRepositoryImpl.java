package com.example.techstore.repository.impl;

import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class UsersRepositoryImpl implements UserRepository {
    public static ObjectInputStream usersInput;
    public static ObjectOutputStream usersOutput;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeInput();
        initializeOutput();
    }

    private static void initializeInput() {
        try {
            usersInput = new ObjectInputStream(new FileInputStream("./src/main/java/com/example/techstore/data/users.dat"));
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find users data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Couldn't read users data.");
            e.printStackTrace();
        }
    }

    private static void initializeOutput() {
        try {
            usersOutput = new ObjectOutputStream(new FileOutputStream("./src/main/java/com/example/techstore/data/users.dat"));
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
        User user = null;

        try {
            while ((user = (User) usersInput.readObject()) != null) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        } catch (IOException e) {
            logger.fatal("Couldn't read user from file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.fatal("Couldn't map data to a user.");
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User create(User user) {
        User created = tryToCreateUser(user);
        return created;
    }

    private static User tryToCreateUser(User user) {
        User created = null;

        try {
            usersOutput.writeObject(user);
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
