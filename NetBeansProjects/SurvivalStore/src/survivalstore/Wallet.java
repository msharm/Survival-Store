package survivalstore;

import java.util.Random;

public class Wallet {

	private static double balance;
        private static final int MIN = 0;
        private static final int MAX = 1000;

	/**
	 * 
	 */
	public Wallet() {
		// TODO Auto-generated constructor stub
            balance = setRandomStartingBalance(MIN, MAX);
	}
       
	
	/**
	 * 
	 * @return
	 */
	public static double getBalance() {
		return balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void deductFromBalance(double price) {
		this.balance = balance - price;
	}

	/**
	 * 
	 * @param min
	 * @param max
	 */
	public static double setRandomStartingBalance(double min, double max) {
		Random random = new Random();
		double randomStartingBalance = min + (max - min) * random.nextDouble();
		balance = randomStartingBalance;
                return balance;
	}
	
	
}
