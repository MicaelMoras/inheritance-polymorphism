# Tax Calculator

Java application that calculates the taxes paid by individuals and companies based on their annual income, healthcare expenses, and number of employees.

Built as a study project on **inheritance**, **abstract classes**, and **polymorphism** in Java (OOP).

## How it works

You enter the number of taxpayers and, for each one, their type, name, annual income, and additional information. The program calculates each taxpayer's tax and displays the total amount collected.

The tax rules depend on the taxpayer type:

- **Individuals:** Pay 15% tax on annual income below $20,000, or 25% on income of $20,000 or more. Then, 50% of healthcare expenses is deducted from the tax. The final tax cannot be negative.
- **Companies:** Pay 16% tax on annual income. For companies with more than 10 employees, the rate drops to 14%.

## Example

```text
Enter the number of taxpayers:
3

Taxpayer #1 data:
Individual or company (i/c)?
i
Name:
Alex
Annual income:
50000.00
Health expenditures:
2000.00

Taxpayer #2 data:
Individual or company (i/c)?
c
Name:
Acme
Annual income:
400000.00
Number of employees:
25

Taxpayer #3 data:
Individual or company (i/c)?
c
Name:
Tech
Annual income:
30000.00
Number of employees:
5

Taxes Paid:
Alex: $ 11500.00
Acme: $ 56000.00
Tech: $ 4800.00

Total Taxes: $ 72300.00
```

## Project structure

```text
tax-calculator/
└── src/
    └── taxcalculator/
        ├── TaxPayer.java    # abstract base class
        ├── Individuals.java # individual tax calculation
        ├── Company.java     # company tax calculation
        └── Program.java     # console entry point
```

## The design idea

`TaxPayer` is an abstract class that defines the common attributes and behavior shared by all taxpayers. Its abstract `tax()` method requires each subclass to implement its own tax calculation.

```java
public abstract class TaxPayer {
    private String nome;
    private double rendaAnual;

    public abstract double tax();
}
```

Both `Individuals` and `Company` extend `TaxPayer` and override the `tax()` method with their specific calculation rules.

The program stores different taxpayer objects in a single list:

```java
List<TaxPayer> list = new ArrayList<TaxPayer>();

list.add(new Individuals(name, anualIncome, he));
list.add(new Company(name, anualIncome, numberOfEmployees));

for (TaxPayer tp : list) {
    System.out.println(
        tp.getNome() + ": $" + String.format(" %.2f", tp.tax())
    );
}
```

Although the list stores references of type `TaxPayer`, each object executes its own implementation of `tax()` at runtime. This is **polymorphism**: the program can calculate taxes without needing to know the specific taxpayer type in advance.

The shared attributes are encapsulated in the base class, while each subclass is responsible for its own tax rules.

## Running

1. Clone the repository:

   ```bash
   git clone https://github.com/MicaelMoras/tax-calculator.git
   ```

2. Open the project in IntelliJ IDEA.

3. Run `Program.java` and follow the prompts in the console.

Requires a JDK (Java 8 or higher).

**Note:** Names must be entered without spaces because the program uses `Scanner.next()`.

## Technologies

- Java
- Object-Oriented Programming (OOP)

## Author

**Micael Moras**

- GitHub: [github.com/MicaelMoras](https://github.com/MicaelMoras)
- LinkedIn: [linkedin.com/in/micael-moras-ab70b036b](https://www.linkedin.com/in/micael-moras-ab70b036b/)

