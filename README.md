# Sales Taxes

This is a project that prints out receipts for shopping baskets, showing a list with the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid.

This program follows these requirements:
- Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt;
- Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions;
- The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

## Building and Running

To build and run this project, follow these steps:

1. Clone the repository to your local machine;
2. Make sure you have Java(JDK 11 or above) and Gradle installed on your machine;
3. Run `gradle build` to build the project;
4. Navigate to  `build/libs`;
5. Run `java -jar SalesTaxes-1.0-SNAPSHOT.jar` to start the application;
6. Follow the prompts in the console to do add products to the shopping cart and finish shopping.

## Contact

If you have any questions or comments about this project, please contact me at manuele.castro@liferay.com
