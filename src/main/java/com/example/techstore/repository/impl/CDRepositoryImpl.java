package com.example.techstore.repository.impl;

import com.example.techstore.model.CD;
import com.example.techstore.repository.CDRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CDRepositoryImpl implements CDRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/cds.dat";
    private static ObjectOutputStream cdsOutput;

    private static Logger logger = LogManager.getLogger();

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
        CD cd = tryToFindCdByTitle(title);
        return cd;
    }

    private CD tryToFindCdByTitle(String title) {
        List<CD> cds = getAll();

        for(CD cd: cds) {
            if (cd.getTitle().equals(title)) {
                return cd;
            }
        }

        return null;
    }


    @Override
    public CD create(CD cd) {
        CD created = tryToCreateCd(cd);
        return created;
    }

    private CD tryToCreateCd(CD cd) {
        List<CD> cds = getAll();
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
    public List<CD> getAll() {
        try {
            ObjectInputStream cdsInput = new ObjectInputStream(new FileInputStream(dataLocation));
            return (ArrayList<CD>) cdsInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find cds data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read cds data.");
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }


    @Override
    public CD update(CD cd) {
        List<CD> cds = getAll();
        initializeOutput();
        Integer index = getIndexOfElement(cd, cds);

        CD updated = tryToUpdateCd(index, cd, cds);
        return updated;
    }

    private CD tryToUpdateCd(Integer index, CD cd, List<CD> cds) {
        try {
            if (index != null) {
                cds.set(index, cd);
                cdsOutput.writeObject(cds);
                cdsOutput.flush();
                cdsOutput.close();
                return cd;
            }
        } catch (IOException e) {
            logger.fatal("Failed to update cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void delete(CD cd) {

    }


    private static Integer getIndexOfElement(CD cd, List<CD> cds) {
        Integer index = null;

        for (int i = 0; i < cds.size(); i++) {
            CD currentCd = cds.get(i);
            if (currentCd.getTitle().equals(cd.getTitle())) {
                index = i;
            }
        }

        return index;
    }
}
