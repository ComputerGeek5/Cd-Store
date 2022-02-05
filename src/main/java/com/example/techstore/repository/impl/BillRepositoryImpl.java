package com.example.techstore.repository.impl;

import com.example.techstore.model.Bill;
import com.example.techstore.repository.BillRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BillRepositoryImpl implements BillRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/bills.dat";
    private static ObjectOutputStream billsOutput;

    private static List<Bill> bills;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeData();
    }

    private static void initializeData() {
        bills = tryToInitializeData();
    }

    private static List<Bill> tryToInitializeData() {
        List<Bill> bills = new ArrayList<>();

        try {
            ObjectInputStream billsInput = new ObjectInputStream(new FileInputStream(dataLocation));
            bills = (ArrayList<Bill>) billsInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find bills data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read bills data.");
                e.printStackTrace();
            }
        }

        return bills;
    }

    private static void initializeOutput() {
        try {
            billsOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find bills data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Failed to read bills data.");
            e.printStackTrace();
        }
    }


    @Override
    public Bill create(Bill bill) {
        Bill created = tryToCreateBill(bill);
        return created;
    }

    private Bill tryToCreateBill(Bill bill) {
        initializeOutput();

        try {
            bills.add(bill);
            billsOutput.writeObject(bills);
            billsOutput.flush();
            return bill;
        } catch (IOException e) {
            logger.fatal("Failed to create bill.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Bill findById(String id) {
        Bill found = null;

        for(Bill bill: bills) {
            if (bill.getId().equals(id)) {
                found = bill;
            }
        }

        return found;
    }


    @Override
    public List<Bill> findAll() {
        return bills;
    }


    @Override
    public Bill update(Bill bill) {
        initializeOutput();
        Integer index = getIndexOfElement(bill, bills);

        Bill updated = tryToUpdateBill(index, bill, bills);
        return updated;
    }

    private static Bill tryToUpdateBill(Integer index, Bill bill, List<Bill> bills) {
        try {
            if (index != null) {
                bills.set(index, bill);
                billsOutput.writeObject(bills);
                billsOutput.flush();
                billsOutput.close();
                return bill;
            }
        } catch (IOException e) {
            logger.fatal("Failed to update cd.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Bill delete(Bill bill) {
        initializeOutput();
        Integer index = getIndexOfElement(bill, bills);

        Bill deleted = tryToDeleteBill(index, bills);
        return deleted;
    }

    private static Bill tryToDeleteBill(Integer index, List<Bill> bills) {
        try {
            if (index != null) {
                Bill bill = bills.remove((int) index);
                billsOutput.writeObject(bills);
                billsOutput.flush();
                billsOutput.close();
                return bill;
            }
        } catch (IOException e) {
            logger.fatal("Failed to delete supplier.");
            e.printStackTrace();
        }

        return null;
    }


    private Integer getIndexOfElement(Bill bill, Collection<Bill> bills) {
        Integer index = null;

        Integer i = 0;
        for(Bill currentCd: bills) {
            if (currentCd.getId().equals(bill.getId())) {
                index = i;
            }
            i++;
        }

        return index;
    }
}
