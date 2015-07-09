package comparators;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import app.*;

/**
 * 
 * @author Reed
 *
 */
public abstract class NameComparator implements Comparator {
	@Override
	public int compare(Object productPra, Object productPra2) {
		Product productLoc = (Product)productPra;
		Product productLoc2 = (Product)productPra2;
		return productLoc.getName().compareTo(productLoc2.getName());
	}
}

