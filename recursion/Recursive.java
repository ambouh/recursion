package recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
	//hasNoneSmaller - returns a boolean that determine whether 'list' has all elements 
	// greater than 'T elt'  
  public static <T extends Comparable<T>> boolean hasNoneSmaller(List<T> list,
                                                                 T elt) {
	  int index = 0;
	  return helper(list, elt, index);
    
  }
  
  /* helper is a recursive method that travels through 'list' to find 
   * all elements in this list greater than 'T elt'. 
   * returns true - If all elements are greater than 'T elt'. 
   * returns false - If one element is  smailler than 'T elt'.
   */
  private static <T extends Comparable<T>> boolean helper (List<T> list, 
		  T elt, int index) {
	  if (index < list.size()){
		  if (elt.compareTo(list.get(index)) > 0) {
			  return false;
		  } else {
			  return helper(list, elt, ++index);
		  } 
	  }
	  
	  return true;

  }
  
  //lastIdxOf - find the last position of 'T elt' inside of the 'list'. It is
  // accomplished by calling 'helper2' method.
  public static <T> int lastIdxOf(List <T> list, T element) {
    int index = 0, occurence = -1;
	  return helper2 (list, element, index, occurence);
  }
  
  /*
   * helper2 - is a recursive helper method that has a base (stops once index gets
   * to the list's size). it records every occurence of 'T elt' until the last element
   * of the 'list'. 
   * */
  private static <T> int helper2 (List<T> list, T elt, int index, int occurence) {
	  if (index < list.size()) {
		  if (elt.equals(list.get(index)))
			  occurence = index;
		  
			  occurence = helper2(list, elt, ++index, occurence);
	  }	  
	  return occurence;
  }

  public static <T> List<T> insertAfter(List<T> list, T elt, T newElt) {
    ArrayList<T> newList = new ArrayList<T>();
    return helper3(list, newList, elt, newElt, 0);
  }
  
  private static <T> List<T> helper3 (List<T> list, List<T> newList, 
		  T elt, T newElt, int index) {
	  
	  if (index < list.size()) {
		  if (elt.equals(list.get(index))) {
			  newList.add(list.get(index));
			  newList.add(newElt);
		  } else {
			 newList.add(list.get(index));		  
		  } 
		  helper3 (list, newList, elt, newElt, ++index); 
	  }
	  
	  return newList;
  }
  
  public static <T> List<T> removeNumTimes(List<T> list, T elt, int num) {
    ArrayList<T> newList = new ArrayList<T>();
    return helper4 (list, newList, elt, num, 0);
  }  
  
  private static <T> List<T> helper4 (List<T> list, ArrayList<T> newList, 
		  T elt, int num, int index){
	  
	  if (index < list.size()) {
		  
		  if (!elt.equals(list.get(index))) {
			  newList.add(list.get(index));
		  } else if ( num <= 0){
			  newList.add(list.get(index)); 
		  } else {
			  --num;
		  }
		  
	  }else {
		  return newList;
	  }
	  return helper4(list, newList, elt, num, ++index);
  }

  
  
}
