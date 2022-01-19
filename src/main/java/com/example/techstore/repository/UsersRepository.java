package com.example.techstore.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class UsersRepository {
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
}
