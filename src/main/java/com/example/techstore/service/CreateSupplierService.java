package com.example.techstore.service;

import com.example.techstore.model.Cd;
import com.example.techstore.model.Supplier;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.SupplierRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import com.example.techstore.repository.impl.SupplierRepositoryImpl;
import com.example.techstore.view.CreateSupplierView;

public class CreateSupplierService {
    private static final SupplierRepository supplierRepository;
    private static final CDRepository cdRepository;

    static {
        supplierRepository = new SupplierRepositoryImpl();
        cdRepository = new CDRepositoryImpl();
    }

    public Supplier create(CreateSupplierView view) {
        String chosenCd = (String) view.getCds().getValue();
        Cd cd = cdRepository.findByTitle(chosenCd);
        String name = view.getName().getText();
        int quantity = Integer.parseInt(view.getQuantity().getText());
        Supplier supplier = new Supplier(name, cd, quantity);

        Supplier created = supplierRepository.create(supplier);
        return created;
    }

    public Cd updateCd(Supplier supplier) {
        Cd cd = supplier.getCd();
        int boughtQuantity = cd.getBoughtQuantity() + supplier.getCdQuantity();
        cd.setBoughtQuantity(boughtQuantity);

        Cd updated = cdRepository.update(cd);
        return updated;
    }
}
