/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.println("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Price: ");
            double price = sc.nextDouble();
            
            if(ch == 'i'){
                System.out.println("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product pro = new ImportedProduct(name, price, customsFee);
                list.add(pro);
                
            }else if(ch == 'u'){
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                Product pro = new UsedProduct(name, price, manufactureDate);
                list.add(pro);
                
            }else{
                Product pro = new Product(name, price);
                list.add(pro);
            }

        }
        
        System.out.println("");
        System.out.println("PRICE TAGS:");
        for(Product pro : list){
            System.out.println(pro.priceTag());
        }
        
        sc.close();
    }
}
