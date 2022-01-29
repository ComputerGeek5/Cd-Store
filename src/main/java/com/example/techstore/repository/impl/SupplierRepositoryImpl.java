package com.example.techstore.repository.impl;

import com.example.techstore.model.Supplier;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.SupplierRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/suppliers.dat";
    private static ObjectOutputStream suppliersOutput;

    private static final Logger logger = LogManager.getLogger();


    private static void initializeOutputs() {
        try {
            suppliersOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find suppliers data.");
            e.printStackTrace();
        } catch (IOException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read suppliers data.");
                e.printStackTrace();
            }
        }
    }

    @Override
    public Supplier create(Supplier supplier) {
        Supplier created = tryToCreateSupplier(supplier);
        return created;
    }

    private Supplier tryToCreateSupplier(Supplier supplier) {
        initializeOutputs();
        List<Supplier> suppliers = getAll();

        try {
            suppliers.add(supplier);
            suppliersOutput.writeObject(supplier);
            suppliersOutput.flush();
            return supplier;
        } catch (IOException e) {
            logger.fatal("Failed to create supplier.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Supplier> getAll() {
        try {
            ObjectInputStream suppliersInput = new ObjectInputStream(new FileInputStream(dataLocation));
            return (ArrayList<Supplier>) suppliersInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find suppliers data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read suppliers data.");
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }

    @Override
    public Supplier update(Supplier supplier) {
        return null;
    }

    @Override
    public void delete(Supplier supplier) {

    }
}
