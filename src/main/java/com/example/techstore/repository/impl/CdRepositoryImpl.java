package com.example.techstore.repository.impl;

import com.example.techstore.Application;
import com.example.techstore.model.Cd;
import com.example.techstore.repository.CdRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

import static com.example.techstore.util.Constant.baseLocation;

public class CdRepositoryImpl implements CdRepository {
    //        Test
    private static final String dataLocation = "./src/main/resources/com/example/techstore/static/data/cds.dat";

    //        Production
//    private static String dataLocation = baseLocation + "/data/cds.dat";
    private static ObjectOutputStream cdsOutput;

    private static Set<Cd> cds;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeData();
    }

    private static void initializeData() {
        cds = tryToInitializeData();
    }

    private static Set<Cd> tryToInitializeData() {
        Set<Cd> cds = new HashSet<>();

        try {
            ObjectInputStream cdsInput = new ObjectInputStream(new FileInputStream(dataLocation));
            cds = (Set<Cd>) cdsInput.readObject();
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
    public Cd findByTitle(String title) {
        for(Cd cd: cds) {
            if (cd.getTitle().equals(title)) {
                return cd;
            }
        }

        return null;
    }


    @Override
    public Cd findById(String id) {
        Cd found = null;

        for(Cd cd: cds) {
            if (cd.getId().equals(id)) {
                found = cd;
            }
        }

        return found;
    }


    @Override
    public Cd create(Cd cd) {
        Cd created = tryToCreateCd(cd);
        return created;
    }

    private Cd tryToCreateCd(Cd cd) {
        initializeOutput();

        try {
            boolean unique = cds.add(cd);
            if (unique) {
                cdsOutput.writeObject(cds);
                cdsOutput.flush();
                return cd;
            }
        } catch (IOException e) {
            logger.fatal("Failed to create cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Set<Cd> findAll() {
        return cds;
    }


    @Override
    public Cd update(Cd cd) {
        initializeOutput();
        Cd before = findById(cd.getId());

        Cd updated = tryToUpdateCd(before, cd, cds);
        return updated;
    }

    private Cd tryToUpdateCd(Cd before, Cd after, Set<Cd> cds) {
        try {
            cds.remove(before);
            boolean unique = cds.add(after);
            if (unique) {
                cdsOutput.writeObject(cds);
                cdsOutput.flush();
                return after;
            }
        } catch (IOException e) {
            logger.fatal("Failed to update cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Cd delete(Cd cd) {
        initializeOutput();
        cd = findById(cd.getId());

        Cd deleted = tryToDeleteCD(cd, cds);
        return deleted;
    }

    private static Cd tryToDeleteCD(Cd cd, Set<Cd> cds) {
        try {
            cds.remove(cd);
            cdsOutput.writeObject(cds);
            cdsOutput.flush();
            return cd;
        } catch (IOException e) {
            logger.fatal("Failed to delete cd.");
            e.printStackTrace();
        }

        return null;
    }
}
