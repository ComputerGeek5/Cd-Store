package com.example.techstore.repository.impl;

import com.example.techstore.model.CD;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.CDRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public class CDRepositoryImpl implements CDRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/cds.dat";
    private static ObjectOutputStream cdsOutput;

    private static Set<CD> cds;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeData();
    }

    private static void initializeData() {
        cds = tryToInitializeData();
    }

    private static Set<CD> tryToInitializeData() {
        Set<CD> cds = new HashSet<>();

        try {
            ObjectInputStream cdsInput = new ObjectInputStream(new FileInputStream(dataLocation));
            cds = (Set<CD>) cdsInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find cds data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read cds data.");
                e.printStackTrace();
            }
        }

        return cds;
    }

    private static void initializeOutput() {
        try {
            cdsOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find cds data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Failed to read cds data.");
            e.printStackTrace();
        }
    }


    @Override
    public CD findByTitle(String title) {
        CD found = null;

        for(CD cd: cds) {
            if (cd.getTitle().equals(title)) {
                found = cd;
            }
        }

        return found;
    }


    @Override
    public CD findById(String id) {
        CD found = null;

        for(CD cd: cds) {
            if (cd.getId().equals(id)) {
                found = cd;
            }
        }

        return found;
    }


    @Override
    public CD create(CD cd) {
        CD created = tryToCreateCd(cd);
        return created;
    }

    private CD tryToCreateCd(CD cd) {
        initializeOutput();

        try {
            cds.add(cd);
            cdsOutput.writeObject(cds);
            cdsOutput.flush();
            cdsOutput.close();
            return cd;
        } catch (IOException e) {
            logger.fatal("Failed to create cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Set<CD> findAll() {
        return cds;
    }


    @Override
    public CD update(CD cd) {
        initializeOutput();
        CD before = findById(cd.getId());

        CD updated = tryToUpdateCd(before, cd, cds);
        return updated;
    }

    private CD tryToUpdateCd(CD before, CD after, Set<CD> cds) {
        try {
            cds.remove(before);
            cds.add(after);
            cdsOutput.writeObject(cds);
            cdsOutput.flush();
            cdsOutput.close();
            return after;
        } catch (IOException e) {
            logger.fatal("Failed to update cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public CD delete(CD cd) {
        initializeOutput();
        cd = findById(cd.getId());

        CD deleted = tryToDeleteCD(cd, cds);
        return deleted;
    }

    private static CD tryToDeleteCD(CD cd, Set<CD> cds) {
        try {
                cds.remove(cd);
                cdsOutput.writeObject(cds);
                cdsOutput.flush();
                cdsOutput.close();
                return cd;
        } catch (IOException e) {
            logger.fatal("Failed to delete supplier.");
            e.printStackTrace();
        }

        return null;
    }
}
