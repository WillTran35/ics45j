package labs.lab8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
/**
 * Given a List<Pair<K, V>> as a parameter, returns a Map<K, V> of the pairs
 in
 * the list (Each pair's first element is mapped to its second element)
 *
 * @param <K> type of the first element in each pair
 * @param <V> type of the second element in each pair
 * @param list the list to make into a map
 *
 * @return a map of the pairs in the list, with each pair's first element
mapped
 * to its second element
 */

    public static <K, V> Map<K,V> problem1_listToMap(List<Pair<K, V>> list){
        Map <K,V> result = new HashMap<>();
        for (Pair<K,V> p : list){
            result.put(p.getFirst(), p.getSecond());
        }
        return result;
}
// WRITE YOUR CODE FOR PROBLEM 1 HERE
/**
 * Checks whether a generic list is a palindrome; that is, whether
 * the values at index i and n - 1 - i are equal to each other, where n
 * is the size of the list.
 *
 * @param <T> the type of element in the List
 * @param a the List
 *
 * @return true if it is a palindrome, or false if not
 */
// WRITE YOUR CODE FOR PROBLEM 2 HERE
    public static <T> boolean problem2_isPalindrome(List<T> a){
        int start = 0;
        int end = a.size() - 1;
        while (start < end){
            if (!a.get(start).equals(a.get(end))){
                return false;
            }
            start ++ ;
            end -- ;
        }
        return true;
    }
/**
 * Takes as a parameter a generic array list and returns true if it its
 elements
 * are in increasing order, or false if not. Increasing order in this case
 means
 * non-decreasing, so there can be multiple equivalent elements next to each
 * other (e.g., 0, 2, 2, 4) and it will still be considered increasing.
 Require
 * that the array list elements implement the Comparable interface.
 *
 * @param <T> type of the elements of array list a
 * @param a input array list
 *
 * @return true if the elements are in increasing order, false if not
 */
// WRITE YOUR CODE FOR PROBLEM 3 HERE
    public static <T extends Comparable> boolean problem3_isIncreasing(List<T> a){
        for (int i = 1 ; i < a.size(); i ++){
            if (a.get(i).compareTo(a.get(i-1)) < 0){
                return false;
            }
        }
        return true;
    }
/**
 * Takes as a parameter any object that implements the Iterable<E> interface,
 and
 * returns a String containing its elements (whatever is returned by that
 * element's toString method), each one separated by a comma and a space.
 *
 * @param <T> type of the iterable parameter
 * @param <E> type of the elements contained in T
 * @param iterable object to get elements from
 *
 * @return a String containing iterable's elements (whatever is returned by
that
 * element's toString method), each one separated by a comma and a space
 */
// WRITE YOUR CODE FOR PROBLEM 4 HERE
    public static <T extends Iterable<E>, E>  String problem4_getElements(Iterable<E> iterable){
        String result ="";
        for (E x : iterable){
            if (result.length() > 0){
                result += ", ";
            }
            result += x;
        }
        return result;
    }
}