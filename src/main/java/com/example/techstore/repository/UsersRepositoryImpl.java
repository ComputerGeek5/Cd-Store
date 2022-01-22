package com.example.techstore.repository;

import com.example.techstore.model.abst.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

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
            logger.fatal("Couldn't read entity from file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.fatal("Couldn't map to an appropriate entity.");
            e.printStackTrace();
        }

        return user;
    }
}
