package codeStates.burgerqueen;

import codeStates.burgerqueen.product.Product;
import codeStates.burgerqueen.product.subproduct.Drink;
import codeStates.burgerqueen.product.subproduct.Hamburger;
import codeStates.burgerqueen.product.subproduct.Side;

//ë©ë´ì¶ë ¥
public class Menu {
    private Product[] products;

    public Menu(Product[] products){
        this.products = products;
    }

    public void printMenu(){
        System.out.println("[ð»] ë©ë´");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println("(0) ì¥ë°êµ¬ë");
        System.out.println("(+) ì£¼ë¬¸íê¸°");
        System.out.println("-".repeat(60));
        System.out.println("[ð£] ë©ë´ë¥¼ ì íí´ì£¼ì¸ì : ");
    }

    protected void printDrinks(boolean printPrice) {
        System.out.println("ð¥¤ ìë£");
        for(Product product:products){
            if(product instanceof Drink){
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    protected void printSides(boolean printPrice) {
        System.out.println("ð ì¬ì´ë");
        for(Product product:products){
            if(product instanceof Side){
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    protected void printHamburgers(boolean printPrice) {
        System.out.println("ð íë²ê±°");
        for(Product product:products){
            if(product instanceof Hamburger){
                printEachMenu(product,printPrice);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product,boolean printPrice) {
        if(printPrice) System.out.printf(
                "   (%d) %s %5dKcal %5dì\n",
                product.getId(), product.getName(), product.getKcal(), product.getPrice()
        );
        else System.out.printf(
                "   (%d) %s %5dKcal\n",
                product.getId(), product.getName(), product.getKcal()
        );
    }
}
