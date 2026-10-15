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
Enter the number of tax payers: 3

Tax payer #1 data:
Individual or company (i/c)? i
Name: Alex
Anual income: 50000.00
Health expenditures: 2000.00

Tax payer #2 data:
Individual or company (i/c)? c
Name: Acme
Anual income: 400000.00
Number of employees: 25

Tax payer #3 data:
Individual or company (i/c)? c
Name: Tech
Anual income: 30000.00
Number of employees: 5

TAXES PAID:
Alex: $ 11500.00
Acme: $ 56000.00
Tech: $ 4800.00

TOTAL TAXES: $ 72300.00
```

## Project structure

```text
tax-calculator/
├── TaxPayer.java       # abstract base class
├── Individuals.java    # individual taxpayer and healthcare deduction
├── Company.java        # company taxpayer and employee-based tax rate
└── Program.java        # console entry point
```

## The design idea

`TaxPayer` is an abstract class that defines the common structure for all taxpayers. It declares the `tax()` method, which each subclass implements according to its own tax rules.

```java
public abstract class TaxPayer {
    private String nome;
    private Double rendaAnual;

    public abstract double tax();
}
```

Both `Individuals` and `Company` extend `TaxPayer` and override the `tax()` method.

The program stores different taxpayer objects in a single list and calculates their taxes through polymorphism:

```java
List<TaxPayer> list = new ArrayList<>();

list.add(new Individuals(name, annualIncome, healthExpenses));
list.add(new Company(name, annualIncome, numberOfEmployees));

for (TaxPayer taxpayer : list) {
    System.out.println(taxpayer.getNome() + ": " + taxpayer.tax());
}
```

The `Program` class does not need to know how each taxpayer calculates their taxes. Java selects the appropriate `tax()` implementation at runtime based on the actual object type.

This keeps the calculation rules specific to each class while allowing the program to handle all taxpayers through the same abstraction.

## Running

1. Clone the repository:

   ```bash
   git clone https://github.com/MicaelMoras/tax-calculator.git
   ```

2. Open the project in IntelliJ IDEA.

3. Run `Program.java` and follow the prompts in the console.

Requires a JDK (Java 8 or higher).

**Note:** Names must be entered without spaces because the program reads them using `Scanner.next()`.

## Technologies

- Java
- Object-Oriented Programming (OOP)

## Author

**Micael Moras**

- GitHub: [github.com/MicaelMoras](https://github.com/MicaelMoras)
- LinkedIn: [linkedin.com/in/micael-moras-ab70b036b](https://www.linkedin.com/in/micael-moras-ab70b036b/)

