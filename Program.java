package taxcalculator;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<TaxPayer>();
        System.out.println(" Enter the of taxpayers ");
        int s = sc.nextInt();

        for (int i = 1; i <= s; i++) {
            System.out.println("Taxpayer #" + i + "data:");
            System.out.println("Individual or company (i/c)?");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Anual income");
            double anualIncome = sc.nextDouble();

            if( type == 'i'){
                System.out.println("Health expenditures: ");
                double he = sc.nextDouble();
                Individuals x = new Individuals(name, anualIncome, he);
                list.add(x);
            }
            else{
                System.out.println("Number of employees");
                Integer numberOfEmployees = sc.nextInt();
                list.add(new Company(name,anualIncome, numberOfEmployees));
            }

        }
        System.out.println();
        System.out.println("Taxes Paid: ");
        for(TaxPayer tp : list){
            System.out.println(tp.getNome() + ": $" + String.format(" %.2f", tp.tax()));
        }
        System.out.println();
        double sum = 0.0;
        for(TaxPayer tp : list){
            sum += tp.tax();
        }
        System.out.println(" Total Taxes: $" + String.format(" %.2f", sum));

         sc.close();
    }
}
