package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.IsInstanceOf;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	public final static int OFFSET = 1;
	public final static int NUMELEM = 100_000;
	public final static int TOMS = 1_000_000;
	
    private UseCollection() {
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static  long mesureAddingTime(List<Integer> l) {
    	long time = System.nanoTime();
    	if(l instanceof LinkedList<?>) {
    		LinkedList lis = (LinkedList) l;
    		for(int i = 0; i < NUMELEM; i++) {
        		lis.add(0, i);
        	}
    	} else {
    		ArrayList lis = (ArrayList) l;
    		for(int i = 0; i < NUMELEM; i++) {
        		lis.add(0, i);
        	}
    	}
    	
    	return (System.nanoTime() - time) * TOMS;
    }
	

    
    private static  long mesureReadingTime(List<Integer> l) {
    	long time = System.nanoTime();
    	int middleElem = l.size() / 2;
    	for(int i = 0; i < NUMELEM; i++) {
    		l.get(middleElem);
    	}
    	return (System.nanoTime() - time) * TOMS;
    }

    /**
     * @param s
     *            unused
     */
    public static  void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	List<Integer> arrList = new ArrayList<>();
    	for(int i = 1000; i < 2000; i++){
    		arrList.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	List<Integer> linList = new LinkedList<>(arrList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	Integer tmp = arrList.get(0);
    	int lastIndex = arrList.size() - UseCollection.OFFSET;
    	arrList.set(0, arrList.get(lastIndex));
    	arrList.set(lastIndex, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(Integer x: arrList) {
    		System.out.println(x + " ");
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long t1 = mesureAddingTime(arrList);
    	long t2 = mesureAddingTime(linList);
    	System.out.println((t1 > t2 ? "ArrayList is slower than LinkedList" : "LinkedList is slower than Arraylist") + " t1: " + t1  + " t2: " + t2);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	t1 = mesureReadingTime(arrList);
    	t2 = mesureReadingTime(linList);
    	System.out.println((t1 > t2 ? "ArrayList is slower than LinkedList" : "LinkedList is slower than Arraylist") + " t1: " + t1  + " t2: " + t2);
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Double> map = new HashMap<>();
    	map.put("Africa", 1_110_635_000.0);
    	map.put("Americas", 972_005_000.0);
    	map.put("Antartica", 0.0);
    	map.put("Asia", 4_298_723_000.0);
    	map.put("Europe", 742_452_000.0);
    	map.put("Oceania", 38_304_000.0);
        /*
         * 8) Compute the population of the world
         */
    	double sum = 0;
    	for(Double value: map.values()) {
    		sum += value;
    	}
    	System.out.println("population of the world: " + sum);
    	
    	
    }
}
