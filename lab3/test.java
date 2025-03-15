//package labs.lab3.tests;
//import static org.junit.Assert.*;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.time.LocalDate;
//import org.junit.Test;
//import labs.lab3.*;
//public class Lab3Test {
//    private final double EPSILON = 1e-3;
//    @Test
//    public void problem1() {
//        assertEquals("r, u, m, ru, um, rum",
//                Main.problem1_getAllSubstrings("rum"));
//        assertEquals("r, u, ru", Main.problem1_getAllSubstrings("ru"));
//        assertEquals("r", Main.problem1_getAllSubstrings("r"));
//        assertEquals("R, o, b, e, r, t, Ro, ob, be, er, rt, Rob, obe, ber, ert,
//                Robe, ober, bert, Rober, obert, Robert",
//                Main.problem1_getAllSubstrings("Robert"));
//        assertEquals(
//                "R, o, b, e, r, t, , N, a, v, a, r, r, o, Ro, ob, be, er,
//                rt, t , N, Na, av, va, ar, rr, ro, Rob, obe, ber, ert, rt , t N, Na, Nav, ava,
//                var, arr, rro, Robe, ober, bert, ert , rt N, t Na, Nav, Nava, avar, varr, arro,
//                Rober, obert, bert , ert N, rt Na, t Nav, Nava, Navar, avarr, varro, Robert, obert
//                , bert N, ert Na, rt Nav, t Nava, Navar, Navarr, avarro, Robert , obert N, bert
//                Na, ert Nav, rt Nava, t Navar, Navarr, Navarro, Robert N, obert Na, bert Nav, ert
//                Nava, rt Navar, t Navarr, Navarro, Robert Na, obert Nav, bert Nava, ert Navar, rt
//                Navarr, t Navarro, Robert Nav, obert Nava, bert Navar, ert Navarr, rt Navarro,
//                Robert Nava, obert Navar, bert Navarr, ert Navarro, Robert Navar, obert Navarr,
//                bert Navarro, Robert Navarr, obert Navarro, Robert Navarro",
//                Main.problem1_getAllSubstrings("Robert Navarro"));
//        assertEquals("1, 2, 3, 4, 5, 12, 23, 34, 45, 123, 234, 345, 1234, 2345,
//                12345",
//                Main.problem1_getAllSubstrings("12345"));
//        assertEquals(
//                "1, , 2, , 3, , 4, 1 , 2, 2 , 3, 3 , 4, 1 2, 2 , 2
//                3, 3 , 3 4, 1 2 , 2 3, 2 3 , 3 4, 1 2 3, 2 3 , 2 3 4, 1 2 3 , 2 3 4, 1 2 3 4",
//                Main.problem1_getAllSubstrings("1 2 3 4"));
//        assertEquals("*, *, *, **, **, ***",
//                Main.problem1_getAllSubstrings("***"));
//        assertEquals("R, *, U, !, M, &, R*, *U, U!, !M, M&, R*U, *U!, U!M, !M&,
//                R*U!, *U!M, U!M&, R*U!M, *U!M&, R*U!M&",
//        Main.problem1_getAllSubstrings("R*U!M&"));
//        assertEquals("", Main.problem1_getAllSubstrings(""));
//    }
//    @Test
//    public void problem2() {
//        assertEquals("ab", Main.problem2_mirrorEnds("abXYZba"));
//        assertEquals("a", Main.problem2_mirrorEnds("abca"));
//        assertEquals("aba", Main.problem2_mirrorEnds("aba"));
//        assertEquals("", Main.problem2_mirrorEnds("abab"));
//        assertEquals("xxYxx", Main.problem2_mirrorEnds("xxYxx"));
//        assertEquals("Hi ", Main.problem2_mirrorEnds("Hi and iH"));
//        assertEquals("x", Main.problem2_mirrorEnds("x"));
//        assertEquals("", Main.problem2_mirrorEnds(""));
//        assertEquals("123", Main.problem2_mirrorEnds("123and then 321"));
//        assertEquals("xxx", Main.problem2_mirrorEnds("xxx"));
//        assertEquals("ba", Main.problem2_mirrorEnds("band andab"));
//    }
//    @Test
//    public void problem3() {
//        assertEquals(123, Main.problem3_sumNumbers("abc123xyz"));
//        assertEquals(44, Main.problem3_sumNumbers("aa11b33"));
//        assertEquals(18, Main.problem3_sumNumbers("7 11"));
//        assertEquals(0, Main.problem3_sumNumbers("Robert"));
//    }
//    @Test
//    public void problem4() {
//        StringAnalyzer sa = new StringAnalyzer("Robert Sean Navarro");
//        assertEquals("RSN", sa.getAllUppercase());
//        assertEquals("Rbr enNvro", sa.getEveryOtherChar());
//        assertEquals("R*b*rt S**n N*v*rr*", sa.replaceVowelsWithAsterisk());
//        assertEquals(7, sa.getNumVowels());
//        assertEquals("1 3 8 9 13 15 18", sa.getVowelPositions());
//        sa = new StringAnalyzer("ROBERT!!!!!");
//        assertEquals("ROBERT", sa.getAllUppercase());
//        assertEquals("RBR!!!", sa.getEveryOtherChar());
//        assertEquals("R*B*RT!!!!!", sa.replaceVowelsWithAsterisk());
//        assertEquals(2, sa.getNumVowels());
//        assertEquals("1 3", sa.getVowelPositions());
//        sa = new StringAnalyzer("x YzjWkw WWDS N n bb");
//        assertEquals("YWWWDSN", sa.getAllUppercase());
//        assertEquals("xYjk WSNnb", sa.getEveryOtherChar());
//        assertEquals("x YzjWkw WWDS N n bb", sa.replaceVowelsWithAsterisk());
//        assertEquals(0, sa.getNumVowels());
//        assertEquals("", sa.getVowelPositions());
//        sa = new StringAnalyzer("oiEEiUa");
//        assertEquals("EEU", sa.getAllUppercase());
//        assertEquals("oEia", sa.getEveryOtherChar());
//        assertEquals("*******", sa.replaceVowelsWithAsterisk());
//        assertEquals(7, sa.getNumVowels());
//        assertEquals("0 1 2 3 4 5 6", sa.getVowelPositions());
//        sa = new StringAnalyzer("oi EEiU a");
//        assertEquals("EEU", sa.getAllUppercase());
//        assertEquals("o EU ", sa.getEveryOtherChar());
//        assertEquals("** **** *", sa.replaceVowelsWithAsterisk());
//        assertEquals(7, sa.getNumVowels());
//        assertEquals("0 1 3 4 5 6 11", sa.getVowelPositions());
//    }
//    @Test
//    public void problem5() {
//        CreditCard cc1 = new CreditCard(4022888888881881L, LocalDate.of(2027,
//                2, 28));
//        assertEquals(4022888888881881L, cc1.getNumber());
//        assertEquals(LocalDate.of(2027, 2, 28), cc1.getExpirationDate());
//        assertEquals("4022 8888 8888 1881", cc1.getNumberWithSpaces());
//        assertTrue(cc1.isValid());
//        CreditCard cc2 = new CreditCard(4022888888881881L, LocalDate.of(2021,
//                2, 28));
//        assertEquals(4022888888881881L, cc2.getNumber()); //
//        assertEquals(LocalDate.of(2021, 2, 28), cc2.getExpirationDate());
//        assertEquals("4022 8888 8888 1881", cc2.getNumberWithSpaces());
//        assertFalse(cc2.isValid());
//        CreditCard cc3 = new CreditCard(5022888888881881L, LocalDate.of(2026,
//                2, 28));
//        assertEquals(5022888888881881L, cc3.getNumber());
//        assertEquals(LocalDate.of(2026, 2, 28), cc3.getExpirationDate());
//        assertEquals("5022 8888 8888 1881", cc3.getNumberWithSpaces());
//        assertFalse(cc3.isValid());
//        CreditCard cc4 = new CreditCard(3333333333333333L, LocalDate.of(2019,
//                4, 9));
//        assertEquals(3333333333333333L, cc4.getNumber());
//        assertEquals(LocalDate.of(2019, 4, 9), cc4.getExpirationDate());
//        assertEquals("3333 3333 3333 3333", cc4.getNumberWithSpaces());
//        assertFalse(cc4.isValid());
//        CreditCard cc5 = new CreditCard(3333333333333333L, LocalDate.of(2030,
//                4, 9));
//        assertEquals(3333333333333333L, cc5.getNumber());
//        assertEquals(LocalDate.of(2030, 4, 9), cc5.getExpirationDate());
//        assertEquals("3333 3333 3333 3333", cc5.getNumberWithSpaces());
//        assertTrue(cc5.isValid());
//        CreditCard cc6 = new CreditCard(3000333333333333L, LocalDate.of(2030,
//                4, 9));
//        assertEquals(3000333333333333L, cc6.getNumber());
//        assertEquals(LocalDate.of(2030, 4, 9), cc6.getExpirationDate());
//        assertEquals("3000 3333 3333 3333", cc6.getNumberWithSpaces());
//        assertTrue(cc6.isValid());
//        CreditCard cc7 = new CreditCard(3000333333330000L, LocalDate.of(2030,
//                4, 9));
//        assertEquals(3000333333330000L, cc7.getNumber());
//        assertEquals(LocalDate.of(2030, 4, 9), cc7.getExpirationDate());
//        assertEquals("3000 3333 3333 0000", cc7.getNumberWithSpaces());
//        assertTrue(cc7.isValid());
//    }
//    @Test
//    public void problem6() {
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 1, 1, 2, 1 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 2, 1, 1, 2,
//                1 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 10, 10 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 1 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 10, 0, 1, -1,
//                10 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 1 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 1, 2 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 1, 1, 1, 4 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 2, 1, 1, 1,
//                4 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 2, 3, 4, 1,
//                2 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 1, 2, 3, 1, 0, 2,
//                3 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 1, 2, 3, 1, 0, 1,
//                3 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 0, 0, 0, 0, 0 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 11, 1, 3, 3,
//                4 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { 0 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { 0, 0 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { -1, -11, -3, -18,
//                3 }));
//        assertFalse(Main.problem6_sumSplitBalance(new int[] { -1, -11, -3, -18,
//                -3 }));
//        assertTrue(Main.problem6_sumSplitBalance(new int[] { -1, -11, -3, -8, -
//                13, -10 }));
//    }
//    @Test
//    public void problem7() {
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 1, 0, 1, 0, 0,
//                1, 1 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 3, 3, 2 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 2, 2, 2 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 3, 2, 2 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 1, 1, 0, 1,
//                0 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 1 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 1, 2 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] { 2, 1 })));
//        assertTrue(evensFirst(Main.problem7_evenOdd(new int[] {})));
//    }
//    // returns true if all the evens come before all the odds in an array of ints
//    private boolean evensFirst(int[] nums) {
//// if an even comes after an odd, return false:
//        for (int i=1; i<nums.length; i++) {
//            if ((nums[i-1] % 2 == 1) && (nums[i] % 2 == 0)) {
//                return false;
//            }
//        }
//        return true;
//    }
//    @Test
//    public void problem8() {
//// test case 1:
//        ArrayBarChart chart1 = new ArrayBarChart(new int[] {8, 8, 3, 3, 1, 0, 2, 4,
//                12});
//        assertEquals(7, chart1.getNumAsterisks(0));
//        assertEquals(3, chart1.getNumAsterisks(2));
//        assertEquals(0, chart1.getNumAsterisks(5));
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(output));
//        chart1.printBarChart();
//        String result = output.toString();
//        assertEquals("0: *******" + System.lineSeparator() + "1: *******" +
//                System.lineSeparator() +
//                "2: ***" + System.lineSeparator() + "3: ***" +
//                System.lineSeparator() +
//                "4: *" + System.lineSeparator() + "5: " +
//                System.lineSeparator() +
//                "6: **" + System.lineSeparator() + "7: ***" +
//                System.lineSeparator() +
//                "8: **********", result);
//// test case 2:
//        ArrayBarChart chart2 = new ArrayBarChart(new int[] {88, 14, 20, 25, 43,
//                100});
//        assertEquals(9, chart2.getNumAsterisks(0));
//        assertEquals(2, chart2.getNumAsterisks(2));
//        assertEquals(10, chart2.getNumAsterisks(5));
//        output = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(output));
//        chart2.printBarChart();
//        result = output.toString();
//        assertEquals("0: *********" + System.lineSeparator() + "1: *" +
//                        System.lineSeparator() +
//                        "2: **" + System.lineSeparator() + "3: ***" +
//                        System.lineSeparator() +
//                        "4: ****" + System.lineSeparator() + "5: **********",
//                result);
//    }
//    @Test
//    public void problem9() {
//// Test case 1:
//        int [][] nums1 = {
//                { 16, 3, 2, 13 },
//                { 5, 10, 11, 8 },
//                { 9, 6, 7, 12 },
//                { 4, 15, 14, 1 }
//        };
//        Square s1 = new Square(nums1);
//        assertEquals(34, s1.rowSum(0));
//        assertEquals(34, s1.rowSum(3));
//        assertEquals(34, s1.columnSum(1));
//        assertEquals(34, s1.columnSum(2));
//        assertEquals(34, s1.diagonalSum(true));
//        assertTrue(s1.isMagic());
//// Test case 2:
//        int [][] nums2 = {
//                { 6, 3, 20 },
//                { 15, 0, 1 },
//                { 7, 2, 17 }
//        };
//        Square s2 = new Square(nums2);
//        assertEquals(16, s2.rowSum(1));
//        assertEquals(26, s2.rowSum(2));
//        assertEquals(28, s2.columnSum(0));
//        assertEquals(5, s2.columnSum(1));
//        assertEquals(27, s2.diagonalSum(false));
//        assertFalse(s2.isMagic());
//    }
//    @Test
//    public void problem10() {
//        Table table = new Table(4, 5); // 4 x 5 table
//// Fill it with a sequence of values:
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 5; j++) {
//                table.set(i, j, (3 + i) * (2 + j));
//            }
//        }
//        assertEquals(12.0, table.neighborAverage(1, 1), EPSILON);
//        assertEquals(25.0, table.neighborAverage(2, 3), EPSILON);
//// Upper-left corner:
//        assertEquals(9.66667, table.neighborAverage(0, 0), EPSILON);
//// Lower-right corner:
//        assertEquals(28.333333, table.neighborAverage(3, 4), EPSILON);
//// Right-hand side:
//        assertEquals(21.6, table.neighborAverage(1, 4), EPSILON);
//// Left-hand side:
//        assertEquals(10.4, table.neighborAverage(1, 0), EPSILON);
//// Bottom row:
//        assertEquals(21.6, table.neighborAverage(3, 2), EPSILON);
//// Top row:
//        assertEquals(14.4, table.neighborAverage(0, 2), EPSILON);
//        assertEquals(60.0, table.sum(0, true), EPSILON);
//        assertEquals(36.0, table.sum(0, false), EPSILON);
//        assertEquals(80.0, table.sum(1, true), EPSILON);
//        assertEquals(54.0, table.sum(1, false), EPSILON);
//        assertEquals(100.0, table.sum(2, true), EPSILON);
//        assertEquals(72.0, table.sum(2, false), EPSILON);
//        assertEquals(120.0, table.sum(3, true), EPSILON);
//        assertEquals(90.0, table.sum(3, false), EPSILON);
//        assertEquals(108.0, table.sum(4, false), EPSILON);
//        table = new Table(1, 1);
//        table.set(0, 0, -3);
//        assertEquals(0.0, table.neighborAverage(1, 1), EPSILON);
//        assertEquals(0.0, table.neighborAverage(8, 8), EPSILON);
//        assertEquals(-3.0, table.sum(0, true), EPSILON);
//        assertEquals(-3.0, table.sum(0, false), EPSILON);
//    }
//}