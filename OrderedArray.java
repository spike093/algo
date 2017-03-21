package orderedarray;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *  @author Tessa Alessandro
 *  @param T: type of the ordered array elements
 *
 **/

public class OrderedArray<T> {
	private ArrayList<T> array = null;
	private Comparator<? super T> comparator;
	
	/**
	 *  It creates an empty ordered array and returns
	 *  the created array.
	 *  It accepts as imput a comparator implementing the precedence
	 *  relation between array elements.
	 *  @param comparator: a comparator implementing the 
	 *  precedence relation between the array elements.
	 **/
	public OrderedArray(Comparator<? super T> comparator){
		this.array = new ArrayList<>();
		this.comparator = comparator;
	} //orderedArray

	/**
	 *  @return: true if and only if this ordered array is empty
	 **/
	public boolean isEmpty(){
		return (this.array).isEmpty();
	}//isEmpty

	/**
	 *  @return: the number of elements currently stored in this ordered arryay
	 **/
	public int size(){
		return (this.array).size();
	} //size

	/**
	 *  Adds a new element in the ordered array in the right position
	 *  @param element: the elemento to be added
	 *  @throws orderedarray.OrderedArrayException: if and only if the paramenter is null
	 **/
	public void add(T element) throws OrderedArrayException{
		if(element == null) throw new OrderedArrayException("add: element cannot be null");
		int index = getIndexInsert(element);
		(this.array).add(index, element);
	} //add

	/**
	 * 	@param i: index of the element that should be returned
	 * 	@return: the element at position i
	 * 	@throws orderdarray.OrderedArrayException: if and only if i is out of the array bounds
	 **/
	public T get(int i) throws OrderedArrayException{
		if(i<0 || i>=(this.array).size()) throw new OrderedArrayException("Index " + i + " is out of bounds");
		return (this.array).get(i);
	}//get

	// returns the position where the new element has to be inserted
	private int getIndexInsert(T element){
		int index = 0;
		boolean cont = true;
		T currEl = null;
		while( cont && (index < (this.array).size() ) ){
			currEl = (this.array).get(index);
			if( (this.comparator).compare( element, currEl ) < 0 ) 
				cont = false;
			else
				index++;
		} //end while
		return index;
	}//getIndexInsert

}//end class OrderedArray
