package orderedarray;

import java.util.Comparator;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;

/**
 * @author: Tessa Alessandro
 *
 * */

public class OrderedArrayTests{

	class IntegerComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer i1, Integer i2){
			return i1.compareTo(i2);
		} //compare
	} //end class IntegerComparator 

	private Integer i1, i2, i3;
	private OrderedArray<Integer> orderedArray;

	@Before
	public void createOrderedArray(){
		i1 = -12;
		i2 = 0;
		i3 = 4;
		orderedArray = new OrderedArray<Integer>(new IntegerComparator());
	}

	@Test
	public void testIsEmpty_zeroEl(){
		assertTrue(orderedArray.isEmpty());
	}

	@Test
	public void testIsEmpty_oneEl() throws Exception{
		orderedArray.add(i1);
		assertFalse(orderedArray.isEmpty());
	}


} //end class OrderedArrayTests



