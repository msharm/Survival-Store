package comparators;

import java.util.Comparator;

import app.Product;

/**
 * 
 * @author Reed
 *
 */
public class PriceComparator implements Comparator {
	public static int compare(Object productPra, Object productPra2) {
		Product productLoc = (Product)productPra;
		Product productLoc2 = (Product)productPra2;
		if(productLoc.getPriceNum() == productLoc2.getPriceNum()) {
			return 0;
		}
		else if(productLoc.getPriceNum() > productLoc2.getPriceNum()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
