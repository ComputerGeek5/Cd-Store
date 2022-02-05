package com.example.techstore.repository.impl;

import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class UsersRepositoryImpl implements UserRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/users.dat";
    private static ObjectOutputStream usersOutput;

    private static Set<User> users;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeData();
    }

    private static void initializeData() {
        users = tryToInitializeData();
    }

    private static Set<User> tryToInitializeData() {
        Set<User> users = new HashSet<>();

        try {
            ObjectInputStream usersInput = new ObjectInputStream(new FileInputStream(dataLocation));
            users = (HashSet<User>) usersInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find users data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read users data.");
                e.printStackTrace();
            }
        }

        return users;
    }

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
        initializeOutput();

        try {
            users.add(user);
            usersOutput.writeObject(users);
            usersOutput.flush();
            return user;
        } catch (IOException e) {
            logger.fatal("Failed to create user.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public User findById(String id) {
        User found = null;

        for(User user: users) {
            if (user.getId().equals(id)) {
                found = user;
            }
        }

        return found;
    }


    @Override
    public Set<User> findAll() {
        return users;
    }


    @Override
    public User update(User user) {
        initializeOutput();
        User before = findById(user.getId());

        User updated = tryToUpdateUser(before, user, users);
        return updated;
    }

    private static User tryToUpdateUser(User before, User after, Set<User> users) {
        try {
            users.remove(before);
            users.add(after);
            usersOutput.writeObject(users);
            usersOutput.flush();
            usersOutput.close();
            return after;
        } catch (IOException e) {
            logger.fatal("Failed to update cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public User delete(User user) {
        initializeOutput();
        user = findById(user.getId());

        User deleted = tryToDeleteUser(user, users);
        return deleted;
    }

    private static User tryToDeleteUser(User user, Set<User> users) {
        try {
            users.remove(user);
            usersOutput.writeObject(users);
            usersOutput.flush();
            usersOutput.close();
            return user;
        } catch (IOException e) {
            logger.fatal("Failed to delete supplier.");
            e.printStackTrace();
        }

        return null;
    }
}
