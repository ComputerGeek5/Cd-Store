package com.example.techstore.service;

import com.example.techstore.model.Supplier;
import com.example.techstore.repository.SupplierRepository;
import com.example.techstore.repository.impl.SupplierRepositoryImpl;

import java.util.List;

public class SupplierService {
    private static final SupplierRepository supplierRepository;

    static {
        supplierRepository = new SupplierRepositoryImpl();
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier delete(Supplier supplier) {
        return supplierRepository.delete(supplier);
    }
}
