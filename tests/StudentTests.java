package tests;

import java.util.ArrayList;
import java.util.List;

import recursion.Recursive;

import org.junit.*;

import static org.junit.Assert.*;

public class StudentTests {

 @Test (expected = NullPointerException.class)
	public void studentTest1() {
	 Recursive.hasNoneSmaller(null, null);
}
 @Test (expected = NullPointerException.class)
	public void studentTest1_2() {
	Recursive.insertAfter(null, null, null);
 }
 
 @Test (expected = NullPointerException.class)
	public void studentTest1_3() {
	 Recursive.lastIdxOf(null, null);
 }
 
 @Test (expected = NullPointerException.class)
	public void studentTest1_4() {
	 Recursive.removeNumTimes(null, null, 0);
 }
 
 
 //tests hasNoneSmaller true if everything is greater
 @Test public void studentTest2() {
	 assertTrue(Recursive.hasNoneSmaller(sampleList1(), 'a'));
	 assertTrue(Recursive.hasNoneSmaller(sampleList2(), -10));
 }
 
 @Test public void studentTest2_5() {
	 //list is empty
	 List<Integer> list = new ArrayList<Integer>();
	Boolean result = Recursive.hasNoneSmaller(list, 1);
	
	assertTrue(result);
 }
 
 //test if element isn't in the list of lastIdxof, -1 <-- expected
 @Test public void studentTest3() {
	 assertEquals (Recursive.lastIdxOf(sampleList2(), 1000), -1);
	 assertEquals (Recursive.lastIdxOf(sampleList1(), 'a'), -1);
	 assertEquals (Recursive.lastIdxOf(sampleList3(), "Pete"), -1);
 }
 
 //test if old list is same as new list but don't change each other
 @Test public void studentTest4() {
	 List<String> newList = Recursive.insertAfter(sampleList3(), "petey", "t");
	 List<String> oldList = sampleList3();
	 assertEquals (newList, oldList);	
	 newList = Recursive.removeNumTimes(newList, "pete", 2);
	 
	 //check size
	 assertEquals (newList.size(), 4);
	 
	 //check elements on newList
	 assertEquals (ListToStr.listToStr(newList),"bob suzy luke paul" );
	 assertEquals (ListToStr.listToStr(oldList), "bob pete suzy luke paul" );
 }
 
 /*- test if first elm is less
- test if last elm is less
- test if mid elm is less
- test if elm is equal
- test if everything is smaller */
 @Test public void studentTest5() {
	 assertFalse(Recursive.hasNoneSmaller(sampleList4(), 4));
	 assertFalse(Recursive.hasNoneSmaller(sampleList5(), 4));
	 assertTrue(Recursive.hasNoneSmaller(sampleList6(), 4));
	 assertTrue(Recursive.hasNoneSmaller(sampleList6(), 5));
 }
 /*- test if elm is first
  *- test if elm is last 
  *- test if elm is twice
- test if elm is mid*/
 @Test public void studentTest6() {
	 assertEquals(Recursive.lastIdxOf(sampleList4(), 3), 0);
	 assertEquals(Recursive.lastIdxOf(sampleList5(), 3), 4);
	 assertEquals(Recursive.lastIdxOf(sampleList1(), 'i'), 4);
	 assertEquals(Recursive.lastIdxOf(sampleList6(), 5), 4);
	 assertEquals(Recursive.lastIdxOf(sampleList6(), 7), -1);
 }
 
 //adds first in inserAfter
 @Test public void studentTest7() {
	 List<Integer> newList = Recursive.insertAfter(sampleList4(), 3, 444);
	 
	 assertEquals(ListToStr.listToStr(newList), "3 444 5 5 5 5");
 }
 
 //adds last in inserAfter
 @Test public void studentTest8() {
 List<Integer> newList = Recursive.insertAfter(sampleList5(), 3, 444);
	 
	 assertEquals(ListToStr.listToStr(newList), "5 5 5 5 3 444");
 }
 
 //adds first & last in inserAfter
 @Test public void studentTest9() {
 List<Character> newList = Recursive.insertAfter(sampleList1(), 'i', 'u');
	 
	 assertEquals(ListToStr.listToStr(newList), "n i u t w i u t");
 }
 
//adds after everything in inserAfter
 @Test public void studentTest10() {
List<Integer> newList = Recursive.insertAfter(sampleList6(), 5, 444);
	 
	 assertEquals(ListToStr.listToStr(newList), "5 444 5 444 5 444 5 444 5 444");
 }
 
 @Test public void studentTest11() {
	 List<Integer> newList = Recursive.insertAfter(sampleList2(), 0, 2);
	 List<Integer> newList2 = Recursive.removeNumTimes(newList, 1, 0);
	 
	 assertEquals (ListToStr.listToStr(newList), ListToStr.listToStr(newList2));
 }
 
 @Test public void studentTest12() {
	 List<Integer> newList = Recursive.insertAfter(sampleList2(), 1, 2);
	 List<Integer> newList2 = Recursive.removeNumTimes(newList, 1, 1);
	 
	 assertFalse(newList.equals(newList2));
 }
 
 @Test public void studentTest13() {
	 List<Integer> newList2 = Recursive.removeNumTimes(sampleList6(), 5, 100);
	 assertEquals (newList2.size(), 0);
	 
	 List<Integer> newList3 = Recursive.removeNumTimes(sampleList5(), 5, 100);
	 assertEquals (newList3.size(), 1);
 }
 //a new list that removes all first occuring elt 'num' number of times
 
 // private utility methods ////////////////////////////////////////////
 // Adds all elements of an array of any type to a list of the same type.
 private static <T> List<T> initList(List<T> list, T[] arr) {
   for (T elt : arr)
     list.add(elt);

   return list;
 }

 // Returns a multiple-element list containing Characters.
 private static List<Character> sampleList1() {
   return initList(new ArrayList<Character>(),
                   new Character[]{'n', 'i', 't', 'w', 'i', 't'});
 }

 // Returns a multiple-element list containing Integers.
 private static List<Integer> sampleList2() {
   return initList(new ArrayList<Integer>(),
                   new Integer[]{8, 1, 9, 2, 3, 4, 5, 7, 6, 5});
 }
 
 private static List<String> sampleList3() {
	 return initList(new ArrayList<String>(),
             new String[]{"bob", "pete", "suzy", "luke", "paul"});
 }
 
 // Returns a multiple-element list containing Integers.
 private static List<Integer> sampleList4() {
   return initList(new ArrayList<Integer>(),
                   new Integer[]{3, 5, 5, 5, 5});
 }
 
 private static List<Integer> sampleList5() {
	   return initList(new ArrayList<Integer>(),
	                   new Integer[]{5, 5, 5, 5, 3});
	 }
 
 private static List<Integer> sampleList6() {
	   return initList(new ArrayList<Integer>(),
	                   new Integer[]{5, 5, 5, 5, 5});
	 }
 }
