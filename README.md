   Inheritance and Polymorphism in Java: Tax Calculation:

An Object-Oriented Programming (OOP) exercise in Java that calculates the tax paid by individuals and companies, using inheritance, an abstract class and polymorphism.

The program reads the data of several taxpayers, calculates each one's tax and prints the total amount collected.

   Calculation rules:

Taxpayer	Rule
Individual (Individuals)	Annual income below 20,000: 15% tax. Annual income of 20,000 or more: 25% tax. Then 50% of the health expenditures is deducted. The tax is never negative (the minimum is 0).
Company (Company)	16% of the annual income. With more than 10 employees, the rate drops to 14%.

   Concepts applied:

Abstract class: TaxPayer represents a generic taxpayer. It cannot be instantiated, because each type of taxpayer calculates tax in its own way.
Abstract method: tax() is declared in TaxPayer with no implementation, and the subclasses are required to implement it.
Inheritance: Individuals and Company use extends TaxPayer and reuse nome and rendaAnual, calling the superclass constructor with super(...).
Overriding (@Override): each subclass provides its own tax().
Polymorphism: Program stores everything in a List<TaxPayer> and calls tax() without knowing whether the object is an individual or a company. Each object runs its own version of the method.
Encapsulation: attributes are private and accessed through getters and setters.

  Project structure:
  
inheritance-polymorphism/

├── TaxPayer.java     # abstract class (nome, rendaAnual, tax())

├── Individuals.java  # individual taxpayer (gastosComSaude)

├── Company.java      # company taxpayer (numeroDoFuncionario)

└── Program.java      # main class (input and output)

   Class diagram:
   
1. abstract
TaxPayer
-String nome
-double rendaAnual
+tax() : double
2. Individuals
-double gastosComSaude
+tax() : double
3. Company
-Integer numeroDoFuncionario
+tax() : double
Polymorphism in the code

The snippet below, from Program, is the core of the exercise:

List<TaxPayer> list = new ArrayList<TaxPayer>();

list.add(new Individuals(name, anualIncome, he));
list.add(new Company(name, anualIncome, numberOfEmployees));

for (TaxPayer tp : list) {
    System.out.println(tp.getNome() + ": $" + String.format(" %.2f", tp.tax()));
}

The list holds TaxPayer references, but the objects are Individuals or Company. When tp.tax() is called, Java decides at runtime which version of the method to run, based on the actual type of the object.

Example run

Inputs used in this example:

#	Type	Name	Annual income	Health expenditures / Employees
1	Individual	Alex	50000.00	2000.00
2	Company	Acme	400000.00	25 employees
3	Company	Tech	30000.00	5 employees

Output:

Taxes Paid:
Alex: $ 11500.00
Acme: $ 56000.00
Tech: $ 4800.00

 Total Taxes: $ 72300.00

Checking the math:

Alex: 25% of 50000 = 12500, minus 50% of 2000 (1000) = 11500
Acme: more than 10 employees, so 14% of 400000 = 56000
Tech: 10 employees or fewer, so 16% of 30000 = 4800

   How to run:

Requirement: the JDK (Java Development Kit) installed.

Clone the repository:
bash
   git clone https://github.com/MicaelMoras/inheritance-polymorphism.git
   
With IntelliJ IDEA: open the folder, find the Program class and run its main method. From the terminal: inside the project folder, run:

bash

   javac -d out TaxPayer.java Company.java Individuals.java Program.java
   java -cp out HherancaePpolimofirmo.Program
   
Enter the number of taxpayers and, for each one, the type (i for individual, c for company), the name, the annual income and the extra data (health expenditures or number of employees).

Note: the name is read with Scanner.next(), so type it without spaces (for example, Acme or John).

Technologies
Java

Author

Micael — @MicaelMoras

GitHub: github.com/MicaelMoras

LinkedIn: https://www.linkedin.com/in/micael-moras-ab70b036b/
