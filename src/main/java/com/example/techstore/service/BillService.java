package com.example.techstore.service;

import com.example.techstore.controller.HomeController;
import com.example.techstore.statistics.CashierStatistic;
import com.example.techstore.model.Bill;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.BillRepository;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.BillRepositoryImpl;
import com.example.techstore.repository.impl.UsersRepositoryImpl;
import com.example.techstore.util.enumerator.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillService {
    private static final UserRepository userRepository;
    private static final BillRepository billRepository;

    static {
        userRepository = new UsersRepositoryImpl();
        billRepository = new BillRepositoryImpl();
    }

    public List<CashierStatistic> getAll() {
        List<User> users = getCashiers();
        List<CashierStatistic> cashierStatistics = getCashierStatistics(users, null, null);

        return cashierStatistics;
    }

    public List<CashierStatistic> search(LocalDate fromDate, LocalDate toDate) {
        List<User> users = getCashiers();
        List<CashierStatistic> cashierStatistics = getCashierStatistics(users, fromDate, toDate);

        return cashierStatistics;
    }

    private static List<User> getCashiers() {
        if (HomeController.getUser().getRole() == Role.ADMIN) {
            return userRepository.findAll()
                    .stream()
                    .filter(user -> user.getRole() == Role.CASHIER || user.getRole() == Role.ADMIN)
                    .collect(Collectors.toList());
        } else {
            return userRepository.findAll()
                    .stream()
                    .filter(user -> user.getRole() == Role.CASHIER)
                    .collect(Collectors.toList());
        }
    }

    private static List<CashierStatistic> getCashierStatistics(List<User> users, LocalDate fromDate, LocalDate toDate) {
        List<CashierStatistic> cashierStatistics = new ArrayList<>();

        for (User user: users) {
            List<Bill> billsData = billRepository.findAll()
                    .stream()
                    .filter(bill -> bill.getIssuer().getId().equals(user.getId()))
                    .filter(bill -> {
                        if (fromDate == null || toDate == null) {
                            return true;
                        }

                        if ((bill.getIssueDate().equals(fromDate) || bill.getIssueDate().isAfter(fromDate)) && (bill.getIssueDate().equals(toDate) || bill.getIssueDate().isBefore(toDate))) {
                            return true;
                        }

                        return false;
                    })
                    .collect(Collectors.toList());

            String issuer = user.getName();
            int bills = billsData.size();
            int cds = 0;
            double profit = 0;

            for (Bill bill: billsData) {
                cds += bill.getCds().size();
                profit += bill.getTotal();
            }

            CashierStatistic cashierStatistic = new CashierStatistic(issuer, bills, cds, profit);
            cashierStatistics.add(cashierStatistic);
        }

        return cashierStatistics;
    }
}
