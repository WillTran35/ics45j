package labs.lab7;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import labs.lab7.*;
import org.junit.Test;
public class Lab7Test {
    @Test
    public void problem1() {
        assertEquals(0, Main.problem1_countEars(0));
        assertEquals(2, Main.problem1_countEars(1));
        assertEquals(5, Main.problem1_countEars(2));
        assertEquals(7, Main.problem1_countEars(3));
        assertEquals(10, Main.problem1_countEars(4));
        assertEquals(12, Main.problem1_countEars(5));
        assertEquals(15, Main.problem1_countEars(6));
        assertEquals(25, Main.problem1_countEars(10));
    }
    @Test
    public void problem2() {
        assertTrue(Main.problem2_arrayTimesTen(new int[] { 1, 2, 20 }, 0));
        assertTrue(Main.problem2_arrayTimesTen(new int[] { 3, 30, 0 }, 0));
        assertFalse(Main.problem2_arrayTimesTen(new int[] { 3 }, 0));
        assertFalse(Main.problem2_arrayTimesTen(new int[] { 18, 2, 4, 12, 8,
                120 }, 0));
        assertFalse(Main.problem2_arrayTimesTen(new int[] { 18, 2, 4, 12, 80, 8
        }, 0));
        assertTrue(Main.problem2_arrayTimesTen(new int[] { 18, 2, 4, 12, 120,
                8, 120 }, 0));
    }
    @Test
    public void problem3() {
        assertEquals(true, Main.problem3_contains6(new int[] {1, 6, 4}, 0)); //returns true
        assertEquals(false, Main.problem3_contains6(new int[] {1, 4}, 0)); //returns false
        assertEquals(true, Main.problem3_contains6(new int[] {6}, 0)); //returns true
        assertEquals(false, Main.problem3_contains6(new int[] {}, 0)); //returns false
    }
    @Test
    public void problems4Through5() throws IOException {
// names1.txt:
        NameSorter ns = new NameSorter("res/names1.txt");
        ns.sortNames();
        ;
        List<String> linesList = Arrays.asList("Johnson, Jim", "Jones, Aaron",
                "Jones, Chris", "Ling, Mai",
                "Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina");
        assertEquals(linesList, java.nio.file.Files.readAllLines(new File("res/names1.txt").toPath()));
// names1.txt:
                ns = new NameSorter("res/names2.txt");
        ns.sortNames();
        ;
        linesList = Arrays.asList("ARNOLD, ALAN", "glass, george", "Johnson, Jim", "Jones, Aaron", "Jones, Chris",
                "Ling, Mai", "Ling, Mai", "Swift, Geoffrey", "Xiong, Fong",
                "Zarnecki, Sabrina");
        assertEquals(linesList, java.nio.file.Files.readAllLines(new File("res/names2.txt").toPath()));
    }
    @Test
    public void problem6() {
        String sentence1 = "Mary had a little lamb. Its fleece was white as snow.";
        String sentence2 = "Mary had afjdkslfaj874928374 888 little lamb. , s Its fleece was white as snow -.";
        assertEquals("Lamb little a had mary. Snow as white was fleece its.",
                Main.problem6_reverse(sentence1));
        assertEquals("Lamb little 888 afjdkslfaj874928374 had mary. - snow as white was fleece its s ,.",
        Main.problem6_reverse(sentence2));
    }
    @Test
    public void problem7() {
        ToDoList todo = new ToDoList();
        todo.addTask(2, "read book");
        todo.addTask(3, "wash dishes");
        todo.addTask(5, "eat lunch");
        assertEquals("read book", todo.nextTask().getDescription());
        todo.addTask(1, "walk dog");
        assertEquals("walk dog", todo.nextTask().getDescription());
        assertEquals("wash dishes", todo.nextTask().getDescription());
        assertEquals("eat lunch", todo.nextTask().getDescription());
    }
    @Test
    public void problems8And9() {
// Test Block class:
        Block myBlock = new Block(5, 10);
        assertEquals(10, myBlock.getPrice());
        assertEquals(5, myBlock.getQuantity());
        myBlock.sell(4);
        assertEquals(1, myBlock.getQuantity());
// Test StockSimulator class
        StockSimulator mySimulator = new StockSimulator();
        Block myBlock1 = new Block(100, 12);
        Block myBlock2 = new Block(100, 10);
        mySimulator.buy(100, 12);
        mySimulator.buy(100, 10);
        assertEquals(myBlock1.getPrice(),
                mySimulator.getBlocks().get(0).getPrice());
        assertEquals(myBlock1.getQuantity(),
                mySimulator.getBlocks().get(0).getQuantity());
        assertEquals(myBlock2.getPrice(),
                mySimulator.getBlocks().get(1).getPrice());
        assertEquals(myBlock2.getQuantity(),
                mySimulator.getBlocks().get(1).getQuantity());
        assertEquals(550, mySimulator.sell(150, 15));
        assertEquals(250, mySimulator.sell(50, 15));
// Test exceptions:
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {mySimulator.sell(100, 5);
        });
        String expectedMessage = "Unable to complete sale";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        exception = assertThrows(IllegalArgumentException.class, () -> {
            mySimulator.sell(20, 1);
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        exception = assertThrows(IllegalArgumentException.class, () -> {
            mySimulator.buy(-9, 5);
        });
        expectedMessage = "Unable to complete purchase";
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        exception = assertThrows(IllegalArgumentException.class, () -> {
            mySimulator.buy(9, -5);
        });
        expectedMessage = "Unable to complete purchase";
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void problem10() {
// test1.txt:
        WordCounter wc1 = new WordCounter("res/test1.txt");
        assertEquals(37, wc1.getNumUniqueWords());
        assertEquals(50, wc1.getNumWords());
        ArrayList<String> result = new ArrayList<String>(Arrays.asList("a",
                "across", "actually", "alice", "and", "at",
                "before", "either", "feet", "flashed", "for", "had", "her",
                "hurried", "it", "its", "looked", "mind",
                "never", "of", "on", "or", "out", "rabbit", "seen", "she",
                "started", "take", "that", "the", "then",
                "to", "took", "waistcoatpocket", "watch", "when", "with"));
        assertEquals(result, wc1.getUniqueWords());
// test2.txt:
        WordCounter wc2 = new WordCounter("res/test2.txt");
        assertEquals(23, wc2.getNumUniqueWords());
        assertEquals(26, wc2.getNumWords());
        result = new ArrayList<String>(Arrays.asList("a", "as", "but",
                "disappointment", "down", "empty", "from",
                "great", "her", "it", "jar", "labelled", "marmalade", "of",
                "one", "orange", "passed", "she", "shelves",
                "the", "to", "took", "was"));
        assertEquals(result, wc2.getUniqueWords());
// text3.txt:
        WordCounter wc3 = new WordCounter("res/test3.txt");
        assertEquals(28, wc3.getNumUniqueWords());
        assertEquals(33, wc3.getNumWords());
        result = new ArrayList<String>(Arrays.asList("12", "again", "alice",
                "began", "cat", "dinah", "dinahll", "do",
                "down", "else", "i", "me", "miss", "much", "nothing",
                "old", "should", "so", "soon", "talking", "the",
                "there", "think", "to", "tonight", "very", "was",
                "years"));
        assertEquals(result, wc3.getUniqueWords());
    }
}
