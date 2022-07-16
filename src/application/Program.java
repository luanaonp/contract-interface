package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
	
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int numberContract = sc.nextInt();
		System.out.print("Date(dd/MM/yyy): ");
		Date dateContract = sdf.parse(sc.nextLine());
		System.out.print("Value: ");
		Double valueContract = sc.nextDouble();
		
		Contract ct = new Contract(numberContract, dateContract, valueContract);
		
		System.out.print("Enter number of installments: ");
		int n = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(ct , n);

		
		System.out.println("Installments:");
		for(Installment x : ct.getInstallments()){
			System.out.println(x);
		}
			
		sc.close();

	}

}
