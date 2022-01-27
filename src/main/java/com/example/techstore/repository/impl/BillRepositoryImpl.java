package com.example.techstore.repository.impl;

import com.example.techstore.model.Bill;
import com.example.techstore.repository.BillRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillRepositoryImpl implements BillRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/bills.dat";
    private static ObjectOutputStream billsOutput;
    private static List<Bill> bills;

    private static Logger logger = LogManager.getLogger();

    private static void initializeOutput() {
        try {
            billsOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find bills data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Couldn't read bills data.");
            e.printStackTrace();
        }
    }


    @Override
    public Bill create(Bill bill) {
        Bill created = tryToCreateBill(bill);
        return created;
    }

    private Bill tryToCreateBill(Bill bill) {
        bills = getAll();
        initializeOutput();

        try {
            bills.add(bill);
            billsOutput.writeObject(bill);
            billsOutput.flush();
            return bill;
        } catch (IOException e) {
            logger.fatal("Couldn't create bill.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Bill> getAll() {
        try {
            ObjectInputStream billsInput = new ObjectInputStream(new FileInputStream(dataLocation));
            return (ArrayList<Bill>) billsInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Couldn't find bills data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Couldn't read bills data.");
                e.printStackTrace();
            }
        }

        return new ArrayList<>();
    }


    @Override
    public Bill update(Bill bill) {
        return null;
    }


    @Override
    public void delete(Bill bill) {

    }
}
