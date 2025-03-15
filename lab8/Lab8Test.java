package labs.lab8;
import static org.junit.Assert.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import labs.lab8.*;
public class Lab8Test {
    private final double EPSILON = 1e-3;
    @Test
    public void problem1() {
        List<Pair<String, Color>> colors = new ArrayList<>();
        colors.add(new Pair<>("Juliet", Color.BLUE));
        colors.add(new Pair<>("Adam", Color.RED));
        colors.add(new Pair<>("Eve", Color.BLUE));
        Map<String, Color> colorMap = Main.problem1_listToMap(colors);
        assertEquals(Color.BLUE, colorMap.get("Juliet"));
        assertEquals(Color.RED, colorMap.get("Adam"));
        assertEquals(Color.BLUE, colorMap.get("Eve"));
        List<Pair<Integer, String>> places = new ArrayList<>();
        places.add(new Pair<>(5, "Sam"));
        places.add(new Pair<>(18, "Paris"));
        places.add(new Pair<>(3, "Halle"));
        places.add(new Pair<>(1, "Robert"));
        Map<Integer, String> placesMap = Main.problem1_listToMap(places);
        assertEquals("Robert", placesMap.get(1));
        assertEquals("Halle", placesMap.get(3));
        assertEquals("Sam", placesMap.get(5));
        assertEquals("Paris", placesMap.get(18));
        List<Pair<Double, Double>> nums1 = new ArrayList<>();
        nums1.add(new Pair<>(0.0, 5.9));
        Map<Double, Double> nums1Map = Main.problem1_listToMap(nums1);
        assertEquals(5.9, nums1Map.get(0.0), EPSILON);
        assertNull(nums1Map.get(5.9));
// empty list:
        List<Pair<String, Double>> empty = new ArrayList<>();
        Map<String, Double> emptyMap = Main.problem1_listToMap(empty);
        assertNull(emptyMap.get("Robert"));
    }
    @Test
    public void problem2() {
        List<String> a = Arrays.asList("apple", "orange", "apple");
        assertTrue(Main.problem2_isPalindrome(a));
        List<Color> b = Arrays.asList(Color.RED, Color.GREEN);
        assertFalse(Main.problem2_isPalindrome(b));
        List<Color> c = Arrays.asList(Color.RED, Color.GREEN, Color.BLUE,
                Color.GREEN, Color.RED);
        assertTrue(Main.problem2_isPalindrome(c));
    }
    @Test
    public void problem3() {
        ArrayList<String> a = new ArrayList<>();
        a.add("cupcake");
        a.add("banana");
        a.add("apple");
        assertEquals(false, Main.problem3_isIncreasing(a));
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
        b.add(4);
        b.add(6);
        b.add(8);
        assertEquals(true, Main.problem3_isIncreasing(b));
    }
    @Test
    public void problem4() {
        String sentence = "Mary had a little lamb";
        Iterable<String> it = Arrays.asList(sentence.split(" "));
        assertEquals("Mary, had, a, little, lamb", Main.problem4_getElements(it));
        assertEquals("3, 12, 78, 45, 44",
                Main.problem4_getElements(Arrays.asList(3, 12, 78, 45, 44)));
    }
    @Test
    public void problem5() {
        String[] words = { "Alpha", "Bravo", "Charlie", "Delta", "Echo",
                "Foxtrot", "Golf", "Hotel", "India", "Juliet",
                "Kilo", "Lima", "Mike", "November", "Oscar", "Papa",
                "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
                "Victor", "Whiskey", "X-Ray", "Yankee", "Zulu" };
        BinarySearcher<String> strSearcher = new BinarySearcher<>(words);
        assertEquals(13, strSearcher.search("November"));
        assertEquals(-1, strSearcher.search("October"));
        assertEquals(0, strSearcher.search("Alpha"));
        assertEquals(25, strSearcher.search("Zulu"));
        Integer[] ints = { 3, 4, 8, 13, 15, 28, 45, 46, 80, 95, 110, 112, 113,
                2000, 28938 };
        BinarySearcher<Integer> intSearcher = new BinarySearcher<>(ints);
        assertEquals(-1, intSearcher.search(-8));
        assertEquals(7, intSearcher.search(46));
        assertEquals(-1, intSearcher.search(-3));
        assertEquals(0, intSearcher.search(3));
        assertEquals(1, intSearcher.search(4));
        assertEquals(14, intSearcher.search(28938));
        assertEquals(13, intSearcher.search(2000));
        Double[] dbls = { -10.22, -9.0, -3.229, 0.0, 4.4, 18.2, 99.003, 101.0,
                283.88978, 329.0, 444003.1, 500999.882,
                278397483.3 };
        BinarySearcher<Double> dblSearcher = new BinarySearcher<>(dbls);
        assertEquals(-1, dblSearcher.search(4.0));
        assertEquals(-1, dblSearcher.search(9.0));
        assertEquals(3, dblSearcher.search(0.0));
        assertEquals(7, dblSearcher.search(101.0));
        assertEquals(8, dblSearcher.search(283.88978));
    }
}