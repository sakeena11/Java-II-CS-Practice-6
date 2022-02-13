/**
  * CoinStar.java
  * @description Takes in coins, calculates value, and returns cash
  * @author Sakeena Younus
  * @version 1.0 2022-02-04
*/

import java.util.Scanner;

public class CoinStar{

  //------attributes------
  private int coins[] = new int[6], pennyValues[];
  private Scanner scan = new Scanner(System.in);
  private String[] currency = new String[]{"pennies", "nickels", "dimes", "quarters", "half dollars", "one dollar coins"};

  //------methods------

  /** constructor */
  public CoinStar() {}

    /** takes in coins from user */
  public void intake() {  //acting as a setter
    for (int i = 0; i < coins.length; i++) {
      System.out.print("Enter the number of " + currency[i] + ": ");
      coins[i] = scan.nextInt();
    }
  }

  /** calculates and prints total value */
  public int totalValue() {
    int money = 0;
    pennyValues = new int[]{1, 5, 10, 25, 50, 100, 500, 1000, 2000, 5000, 10000}; //coin values in pennies (pennies to $100 bills)

//bills
    for(int i = 0; i < 6; i++) {
      money += coins[i] * pennyValues[i];
    } // end of for loop

    System.out.println("You have $" + money/100.0); // OR: System.out.println("You have $" + (money/100 + 0.01 * (money%100)));
    return money;
  }

  public void makeChange(int money) {
    double amount;
//coins
    for(int i = 10; i >= 5; i--) {  //or i < 4
      if (money >= pennyValues[i]) {     //10,000 because money is calculates in pennies
        amount = pennyValues[i];
        money = money % pennyValues[i];
        System.out.println("You get " + amount + " $" + pennyValues[i]/100 + " bills");
    }
  }


  for (int i = 4; i >= 1; i--) {  //or i < 4
    if (money >= pennyValues[i]) {     //10,000 because money is calculates in pennies
      amount = pennyValues[i];
      money = money % pennyValues[i];
      System.out.println("You get " + amount+ " " + currency[i]);
  }
}
//pennies
    amount = money;
    System.out.println("You get " + amount + " pennies");
  } // end of makeChange method

  /** main method */
  public static void main(String[] args) {
    CoinStar machine = new CoinStar();
    machine.intake();
    int n = machine.totalValue(); //have to call to main method to print
    machine.makeChange(n);

    // //example of rounding
    //   double money = 12.01;
    //   money = 12.01 * 0.14;
    //   System.out.println(money);
    //
    //
    //   money = money * 100; //could also be: money*=100;
    //   long newMoney = Math.round(money);
    //   System.out.println(newMoney/100.0); //can't divide by 100 or integer division will occur

  } //end of main method
}
