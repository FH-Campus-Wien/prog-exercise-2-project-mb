package at.ac.fhcampuswien;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(2)
class AppTest {

    private PrintStream originalOut;
    private InputStream originalIn;
    private ByteArrayOutputStream bos;
    private PrintStream ps;

    @BeforeAll
    public static void init(){
        System.out.println("Testing Exercise2");
    }

    @AfterAll
    public static void finish(){
        System.out.println("Finished Testing Exercise2");
    }

    @BeforeEach
    public void setupStreams() throws IOException {
        originalOut = System.out;
        originalIn = System.in;

        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        System.setIn(pis);
        ps = new PrintStream(pos, true);
    }

    @AfterEach
    public void tearDownStreams() {
        // undo the binding in System
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void largestNumber1()
    {
        ps.println(2);
        ps.println(5);
        ps.println(-3);

        String output = "Number 1: " +
                "Number 2: " +
                "Number 3: " +
                "The largest number is 5.00" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.largestNumber();

        // assertion
        assertEquals(output, bos.toString().replace(",","."));
    }

    @Test
    public void largestNumber2()
    {
        ps.println("-1");

        String output = "Number 1: " +
                "No number entered." + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.largestNumber();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void stairs1()
    {
        ps.println("5");

        String output = "n: " +
                "1 " + System.lineSeparator() +
                "2 3 " + System.lineSeparator() +
                "4 5 6 " + System.lineSeparator() +
                "7 8 9 10 " + System.lineSeparator() +
                "11 12 13 14 15 " + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.stairs();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void stairs2()
    {
        ps.println("-5");

        String output = "n: " +
                "Invalid number!" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.stairs();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void pyramid()
    {
        String output = "     *" + System.lineSeparator() +
                "    ***" + System.lineSeparator() +
                "   *****" + System.lineSeparator() +
                "  *******" + System.lineSeparator() +
                " *********" + System.lineSeparator() +
                "***********" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.printPyramid();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void rhombus1()
    {
        ps.println(5);
        ps.println('h');
        String output = "h: " +
                "c: " +
                "  h" + System.lineSeparator() +
                " ghg" + System.lineSeparator() +
                "fghgf" + System.lineSeparator() +
                " ghg" + System.lineSeparator() +
                "  h" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.printRhombus();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void rhombus2()
    {
        ps.println(6);
        ps.println('h');
        String output = "h: " +
                "c: " +
                "Invalid number!" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.printRhombus();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void marks1()
    {
        ps.println(3);
        ps.println(3);
        ps.println(4);
        ps.println(0);

        String output = "Mark 1: " +
                "Mark 2: " +
                "Mark 3: " +
                "Mark 4: " +
                "Average: 3.33" + System.lineSeparator() +
                "Negative marks: 0" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.marks();

        // assertion
        assertEquals(output, bos.toString().replace(",","."));
    }

    @Test
    public void marks2()
    {
        ps.println(5);
        ps.println(3);
        ps.println(10);
        ps.println(1);
        ps.println(5);
        ps.println(0);

        String output = "Mark 1: " +
                "Mark 2: " +
                "Mark 3: Invalid mark!" + System.lineSeparator() +
                "Mark 3: " +
                "Mark 4: " +
                "Mark 5: " +
                "Average: 3.50" + System.lineSeparator() +
                "Negative marks: 2" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.marks();

        // assertion
        assertEquals(output, bos.toString().replace(",","."));
    }

    @Test
    public void marks3()
    {
        ps.println(0);

        String output = "Mark 1: " +
                "Average: 0.00" + System.lineSeparator() +
                "Negative marks: 0" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.marks();

        // assertion
        assertEquals(output, bos.toString().replace(",","."));
    }

    @Test
    public void happyNumber1()
    {
        ps.println(716);
        String output = "n: " +
                "Happy number!" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.happyNumbers();

        // assertion
        assertEquals(output, bos.toString());
    }

    @Test
    public void happyNumber2()
    {
        ps.println(702);
        String output = "n: " +
                "Sad number!" + System.lineSeparator();

        // action
        App exercise1 = new App();
        exercise1.happyNumbers();

        // assertion
        assertEquals(output, bos.toString());
    }
}
