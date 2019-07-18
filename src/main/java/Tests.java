import io.jenetics.util.NanoClock;


public class Tests {

    private static NanoClock nanoClock = NanoClock.systemUTC();

    public static void test1() {
        System.out.println("##### TEST 1 STARTED #####");
        // Create random matrix
        boolean[][] matrix = MatrixLibrary.createRandomAdjacencyMatrix(10, 0.835);

        // Print matrix
        MatrixLibrary.printMatrix(matrix);

        // Search for rectangle
        if (FindTriangle.fastSearch(matrix)) {
            System.out.println("FOUND");
        } else {
            System.out.println("NOT FOUND");
        }
        System.out.println("##### TEST 1 FINISHED #####");
    }

    public static void test2() {
        System.out.println("##### TEST 2 STARTED #####");
        String result = "*** ALL RESULTS MATCH ***";
        final int iterations = 1000;
        for (int i = 0; i < iterations; i++) {
            // Create random matrix
            boolean[][] matrix = MatrixLibrary.createRandomAdjacencyMatrix(50, 0.975);

            // Search for rectangle
            if (FindTriangle.fastSearch(matrix) != FindTriangle.naiveSearch(matrix)) {
                //MatrixLibrary.printMatrix(matrix);
                //System.out.println(FindTriangle.fastSearch(matrix) + ", " +
                //FindTriangle.naiveSearch(matrix) + ", " + i);
                result = "*** RESULTS DO NOT MATCH ***";
            }
            // System.out.println(FindTriangle.fastSearch(matrix));
        }
        System.out.println(result);
        System.out.println("##### TEST 2 FINISHED #####");
    }

    public static void test3() {
        System.out.println("##### TEST 3 STARTED #####");

        // Create random matrix
        System.out.println("TASK 1");
        long startTime1 = nanoClock.nanos();
        boolean[][] matrix = MatrixLibrary.createRandomAdjacencyMatrix(63, 0.9919);
        long endTime1 = (nanoClock.nanos() - startTime1)/ 1000;
        System.out.println("* EXECUTION TIME(MICROSECONDS): " + endTime1);

        // Naive search
        System.out.println("TASK 2");
        long startTime2 = nanoClock.nanos();
        boolean naiveResult = FindTriangle.naiveSearch(matrix);
        long endTime2 = (nanoClock.nanos() - startTime2)/ 1000;
        System.out.println("* NAIVE SEARCH RESULT: " + naiveResult);
        System.out.println("* EXECUTION TIME(MICROSECONDS): " + endTime2);


        // Fast search
        System.out.println("TASK 3");
        long startTime3 = nanoClock.nanos();
        boolean fastResult = FindTriangle.fastSearch(matrix);
        long endTime3 = (nanoClock.nanos() - startTime3)/ 1000;
        System.out.println("* FAST SEARCH RESULT: " + fastResult);
        System.out.println("* EXECUTION TIME(MICROSECONDS): " + endTime3);


        System.out.println("##### TEST 3 FINISHED #####");
    }

}
