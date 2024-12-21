/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author jfox
 */
public class SalesTracking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SalesPerson> salesPeople = new ArrayList<>();

        // Input data for 3 salespeople
        for (int i = 0; i < 3; i++) {
            System.out.print("Please enter sales person name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter your sales person title: ");
            String title = scanner.nextLine();

            System.out.print("How many sales values will you enter for this sales person? ");
            int numberOfSales = scanner.nextInt();

            ArrayList<Double> sales = new ArrayList<>();
            for (int j = 0; j < numberOfSales; j++) {
                System.out.print("Please enter sales figure for " + name + ": ");
                sales.add(scanner.nextDouble());
            }
            scanner.nextLine(); // Consume the newline

            salesPeople.add(new SalesPerson(name, title, sales));
        }

        // Generate sales report
        generateSalesReport(salesPeople);

        scanner.close();
    }

    public static void generateSalesReport(ArrayList<SalesPerson> salesPeople) {
        double companyTotalSales = 0;

        System.out.println("\n--- Sales Report ---");
        for (SalesPerson sp : salesPeople) {
            Iterator<Double> salesIterator = sp.iterSales();
            double totalSales = 0, minSale = Double.MAX_VALUE, maxSale = Double.MIN_VALUE;
            int count = 0;

            while (salesIterator.hasNext()) {
                double sale = salesIterator.next();
                totalSales += sale;
                minSale = Math.min(minSale, sale);
                maxSale = Math.max(maxSale, sale);
                count++;
            }

            double averageSales = count > 0 ? totalSales / count : 0;
            companyTotalSales += totalSales;

            System.out.println("Salesperson: " + sp.getName() + ", " + sp.getTitle());
            System.out.println("  Total Sales: " + totalSales);
            System.out.println("  Min Sale: " + minSale);
            System.out.println("  Max Sale: " + maxSale);
            System.out.println("  Average Sale: " + averageSales);
        }

        System.out.println("\nTotal Sales for the Company: " + companyTotalSales);
    }
}

