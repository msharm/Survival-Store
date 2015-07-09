package comparators;

import java.util.Comparator;

import app.*;

public class CategoryComparator implements Comparator<Product> {
	@Override
	public int compare(Object productPra, Object productPra2) {
		Product productLoc = (Product)productPra;
		Product productLoc2 = (Product)productPra2;
		return productLoc.getCategory().compareTo(productLoc2.getCategory());
	}
}
