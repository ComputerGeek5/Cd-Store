package com.example.techstore.util;

import com.example.techstore.model.Bill;
import com.example.techstore.model.Employee;
import com.example.techstore.model.Supplier;
import com.example.techstore.repository.BillRepository;
import com.example.techstore.repository.SupplierRepository;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.BillRepositoryImpl;
import com.example.techstore.repository.impl.SupplierRepositoryImpl;
import com.example.techstore.repository.impl.UsersRepositoryImpl;
import com.example.techstore.statistics.BalanceStatistic;
import com.example.techstore.util.enumerator.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceStatisticUtil {
    private static final BillRepository billRepository;
    private static final SupplierRepository supplierRepository;
    private static final UserRepository userRepository;

    static {
        billRepository = new BillRepositoryImpl();
        supplierRepository = new SupplierRepositoryImpl();
        userRepository = new UsersRepositoryImpl();
    }

    public static List<BalanceStatistic> search(LocalDate fromDate, LocalDate toDate) {
        List<BalanceStatistic> balanceStatistics = new ArrayList<>();

        BalanceStatistic soldStatistic = calculateSoldAmount(fromDate, toDate);
        BalanceStatistic boughtStatistic = calculateBoughtAmount(fromDate, toDate);
        BalanceStatistic salaryStatistic = calculateSalaries(fromDate, toDate);
        balanceStatistics.addAll(Arrays.asList(soldStatistic, boughtStatistic, salaryStatistic));

        BalanceStatistic profitStatistic = calculateProfit(balanceStatistics);
        balanceStatistics.add(profitStatistic);

        return balanceStatistics;
    }

    private static BalanceStatistic calculateSoldAmount(LocalDate fromDate, LocalDate toDate) {
        String source = "Sold";
        BalanceStatistic.Type type = BalanceStatistic.Type.DEBIT;
        double amount = 0;

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
                .collect(Collectors.toList());

        for (Bill bill: bills) {
            amount += bill.getTotal();
        }

        BalanceStatistic soldStatistic = new BalanceStatistic(source, amount, type);
        return soldStatistic;
    }

    private static BalanceStatistic calculateBoughtAmount(LocalDate fromDate, LocalDate toDate) {
        String source = "Bought";
        BalanceStatistic.Type type = BalanceStatistic.Type.CREDIT;
        double amount = 0;

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
                .collect(Collectors.toList());

        for (Supplier supplier: suppliers) {
            int quantity = supplier.getCdQuantity();
            double buyPrice = supplier.getCd().getBuyPrice();

            amount += quantity * buyPrice;
        }

        BalanceStatistic boughtStatistic = new BalanceStatistic(source, amount, type);
        return boughtStatistic;
    }

    private static BalanceStatistic calculateSalaries(LocalDate fromDate, LocalDate toDate) {
        String source = "Salaries";
        BalanceStatistic.Type type = BalanceStatistic.Type.CREDIT;
        double amount = 0;

        List<Employee> employees = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.MANAGER || user.getRole() == Role.CASHIER)
                .map(user -> (Employee) user)
                .collect(Collectors.toList());

        for (Employee employee: employees) {
            amount += employee.getSalary();
        }

        BalanceStatistic salaryStatistic = new BalanceStatistic(source, amount, type);
        return salaryStatistic;
    }

    private static BalanceStatistic calculateProfit(List<BalanceStatistic> balanceStatistics) {
        String source = "Profit";
        BalanceStatistic.Type type = null;
        double amount = 0;

        for (BalanceStatistic balanceStatistic : balanceStatistics) {
            if (balanceStatistic.getType() == BalanceStatistic.Type.CREDIT) {
                amount -= balanceStatistic.getAmount();
            } else if (balanceStatistic.getType() == BalanceStatistic.Type.DEBIT) {
                amount += balanceStatistic.getAmount();
            }
        }

        BalanceStatistic profitStatistic = new BalanceStatistic(source, amount, type);
        return profitStatistic;
    }
}
