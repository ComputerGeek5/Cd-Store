package com.example.techstore.util;

import com.example.techstore.model.Bill;
import com.example.techstore.model.Cd;
import com.example.techstore.model.Genre;
import com.example.techstore.model.Supplier;
import com.example.techstore.repository.*;
import com.example.techstore.repository.impl.BillRepositoryImpl;
import com.example.techstore.repository.impl.GenreRepositoryImpl;
import com.example.techstore.repository.impl.SupplierRepositoryImpl;
import com.example.techstore.repository.impl.UsersRepositoryImpl;
import com.example.techstore.statistics.BalanceStatistic;
import javafx.scene.chart.PieChart;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CdStatisticUtil {
    private static final GenreRepository genreRepository;
    private static final BillRepository billRepository;
    private static final SupplierRepository supplierRepository;

    static {
        genreRepository = new GenreRepositoryImpl();
        billRepository = new BillRepositoryImpl();
        supplierRepository = new SupplierRepositoryImpl();
    }

    public static List<PieChart.Data> searchCdsSoldByGenre(LocalDate fromDate, LocalDate toDate) {
        List<PieChart.Data> cdsSoldByGenre = new ArrayList<>();

        Set<Genre> genres = (Set<Genre>) genreRepository.findAll();
        for(Genre genre: genres) {
            PieChart.Data cdSoldByGenre = getCdsSoldByGenre(genre, fromDate, toDate);
            cdsSoldByGenre.add(cdSoldByGenre);
        }

        return cdsSoldByGenre;
    }

    private static PieChart.Data getCdsSoldByGenre(Genre genre, LocalDate fromDate, LocalDate toDate) {
        String genreName = genre.getName();
        double count = 0;

        List<Bill> bills = billRepository.findAll()
                .stream()
                .filter(bill -> {
                    if (fromDate == null || toDate == null) {
                        return true;
                    }

                    if ((bill.getIssueDate().equals(fromDate) || bill.getIssueDate().isAfter(fromDate)) && (bill.getIssueDate().equals(toDate) || bill.getIssueDate().isBefore(toDate))) {
                        return true;
                    }

                    return false;
                })
                .map(bill -> {
                        Bill newBill = new Bill();
                        newBill.setCds(
                            bill.getCds()
                                    .stream()
                                    .filter(cd -> cd.getGenre().getId().equals(genre.getId()))
                                    .collect(Collectors.toCollection(ArrayDeque::new)));
                        return newBill;
                    }
                )
                .collect(Collectors.toList());

        for (Bill bill: bills) {
           for (Cd cd: bill.getCds()) {
               count += cd.getSoldQuantity();
           }
        }

        PieChart.Data cdSoldByGenre = new PieChart.Data(genreName, count);
        return cdSoldByGenre;
    }

    public static List<PieChart.Data> searchCdsBoughtByGenre(LocalDate fromDate, LocalDate toDate) {
        List<PieChart.Data> cdsBoughtByGenre = new ArrayList<>();

        Set<Genre> genres = (Set<Genre>) genreRepository.findAll();
        for(Genre genre: genres) {
            PieChart.Data cdBoughtByGenre = getCdsBoughtByGenre(genre, fromDate, toDate);
            cdsBoughtByGenre.add(cdBoughtByGenre);
        }

        return cdsBoughtByGenre;
    }

    private static PieChart.Data getCdsBoughtByGenre(Genre genre, LocalDate fromDate, LocalDate toDate) {
        String genreName = genre.getName();
        double count = 0;

        List<Supplier> suppliers = supplierRepository.findAll()
                .stream()
                .filter(supplier -> {
                    if (fromDate == null || toDate == null) {
                        return true;
                    }

                    if ((supplier.getRegisterDate().equals(fromDate) || supplier.getRegisterDate().isAfter(fromDate)) && (supplier.getRegisterDate().equals(toDate) || supplier.getRegisterDate().isBefore(toDate))) {
                        return true;
                    }

                    return false;
                })
                .filter(supplier -> supplier.getCd().getGenre().getId().equals(genre.getId()))
                .collect(Collectors.toList());

        for (Supplier supplier: suppliers) {
            count += supplier.getCdQuantity();
        }

        PieChart.Data cdSoldByGenre = new PieChart.Data(genreName, count);
        return cdSoldByGenre;
    }
}
