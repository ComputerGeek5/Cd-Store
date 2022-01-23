package com.example.techstore.repository.impl;

import com.example.techstore.model.CD;
import com.example.techstore.repository.CDRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class CDRepositoryImpl implements CDRepository {
    public static ObjectInputStream cdsInput;
    public static ObjectOutputStream cdsOutput;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeInput();
        initializeOutput();
    }

    private static void initializeInput() {
        try {
            cdsInput = new ObjectInputStream(new FileInputStream("./src/main/java/com/example/techstore/data/cds.dat"));
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find cds data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Couldn't read cds data.");
            e.printStackTrace();
        }
    }

    private static void initializeOutput() {
        try {
            cdsOutput = new ObjectOutputStream(new FileOutputStream("./src/main/java/com/example/techstore/data/cds.dat", true));
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find cds data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Couldn't read cds data.");
            e.printStackTrace();
        }
    }

    @Override
    public CD findByTitle(String title) {
        CD cd = tryToFindCdByTitle(title);
        return cd;
    }

    private static CD tryToFindCdByTitle(String title) {
        CD cd = null;

        try {
            while ((cd = (CD) cdsInput.readObject()) != null) {
                if (cd.getTitle().equals(title)) {
                    return cd;
                }
            }
        } catch (IOException e) {
            logger.fatal("Couldn't read CD from file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.fatal("Couldn't map data to a CD.");
            e.printStackTrace();
        }

        return cd;
    }

    @Override
    public CD create(CD cd) {
        CD created = tryToCreateCd(cd);
        return created;
    }

    private static CD tryToCreateCd(CD cd) {
        CD created = null;

        try {
            cdsOutput.writeObject(cd);
            created = cd;
        } catch (IOException e) {
            logger.fatal("Couldn't create cd.");
            e.printStackTrace();
        }

        return created;
    }

    @Override
    public List<CD> getAll() {
        return null;
    }

    @Override
    public CD update(CD cd) {
        return null;
    }

    @Override
    public void delete(CD cd) {

    }
}
