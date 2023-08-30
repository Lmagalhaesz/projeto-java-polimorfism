package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.println("Product #" + i+1 + "data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char res = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(res == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			} else if(res == 'c') {
				product.add(new Product(name, price));
			} else if(res == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				product.add(new UsedProduct(name, price, date));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product prod : product) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
