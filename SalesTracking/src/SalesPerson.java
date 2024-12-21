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
// SalesPerson class
class SalesPerson {
    private String name;
    private String title;
    private ArrayList<Double> sales;

    // Constructor
    public SalesPerson(String name, String title, ArrayList<Double> sales) {
        this.name = name;
        this.title = title;
        this.sales = new ArrayList<>(sales);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Double> getSales() {
        return sales;
    }

    // Iterator for sales
    public Iterator<Double> iterSales() {
        return sales.iterator();
    }

    // Add a sale to the list
    public void addSale(double sale) {
        sales.add(sale);
    }
}
