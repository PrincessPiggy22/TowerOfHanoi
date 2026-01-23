import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tower of Hanoi Lab
 *
 * The Tower of Hanoi is a classic problem that demonstrates recursion.
 *
 * Rules:
 * - You have 3 pegs (A, B, C) and n disks of different sizes
 * - All disks start on peg A, sorted by size (largest at bottom)
 * - Goal: Move all disks from peg A to peg C
 * - Only one disk can be moved at a time
 * - A larger disk can never be placed on top of a smaller disk
 *
 * Recursive solution:
 * To move n disks from source to destination using auxiliary peg:
 *   1. Move n-1 disks from source to auxiliary (using destination as helper)
 *   2. Move the largest disk from source to destination
 *   3. Move n-1 disks from auxiliary to destination (using source as helper)
 *
 * @author Madeline Puryear
 */
public class TowerOfHanoi {

    // Part 3: Move counter (you'll add this)
    private static int moveCount = 0;

    // the pegs
    public static ArrayList<Integer> pegA;
    public static ArrayList<Integer> pegB;
    public static ArrayList<Integer> pegC;

    /**
     * PART 1: Implement the classic Tower of Hanoi solver
     *
     * TODO: Implement this recursive method
     *
     * Base case: if n == 1, move disk from source to destination
     * Recursive case:
     *   1. Move n-1 disks from source to auxiliary (using destination)
     *   2. Move disk n from source to destination
     *   3. Move n-1 disks from auxiliary to destination (using source)
     *
     * @param n number of disks to move
     * @param source the source peg (e.g., 'A')
     * @param destination the destination peg (e.g., 'C')
     * @param auxiliary the auxiliary peg (e.g., 'B')
     */
    public static void moveDisks(int n, char source, char destination, char auxiliary) {
        // TODO: Implement base case

        if(n == 1){
            // move from source to dest
            //moveDisks(n, 'A', 'C', 'B');
            System.out.println("Moving disk " + n + " from " + source + " to " + destination);
            displayTowers();

        }
        else {
            // TODO: Implement recursive case (3 steps)
            // move n-1 disks to aux
            moveDisks(n - 1, source,auxiliary, destination);
            System.out.println("Moving disk " + n + " from " + source + " to " + destination);

            // move n-1 to dest
            moveDisks(n - 1, auxiliary,destination,source);

        }

       // updateTowers("peg" + source, "peg" + destination,n);

        moveCount++;
    }

    /**
     * PART 2: Add visualization
     *
     * Modify this method to display the state of the towers after each move.
     *
     * You can represent the towers however you like. Example:
     * A: [3, 2, 1]
     * B: []
     * C: []
     *
     * Or get creative with ASCII art!
     *
     * Hint: You'll need to track which disks are on which peg.
     * Consider using ArrayList<Integer> for each peg.
     */
    public static void displayTowers() {
        // TODO: Implement tower visualization
        System.out.println("\n");
        System.out.println("--- Tower State ---");

        // Display pegs A, B, C and their disks

        System.out.print("A: "); // Peg A
        for (int i = 0; i < pegA.size(); i++) {
            System.out.print(pegA.get(i));

            if(pegA.size() > 1 && i != pegA.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        System.out.print("B: "); // Peg B
        for (int i = 0; i < pegB.size(); i++) {
            System.out.print(pegB.get(i));

            if(pegB.size() > 1 && i != pegB.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        System.out.print("C: "); // Peg C
        for (int i = 0; i < pegC.size(); i++) {
            System.out.print(pegC.get(i));

            if(pegC.size() > 1 && i != pegC.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println("\n");

    }

    /**
     * Updates the status of the towers
     *
     */

    public static void updateTowers(char source, char dest){
        ArrayList<Integer> sourPeg;
        ArrayList<Integer> destPeg;
        
        if (source == 'A'){
            sourPeg = pegA;
        } else if (source == 'B'){
            sourPeg = pegB;
        } else{
            sourPeg = pegC;
        }
        
        if (dest == 'A'){
            destPeg = pegA;
        } else if (dest == 'B'){
            destPeg = pegB;
        } else{
            destPeg = pegC;
        }
        
        
        int disk = sourPeg.remove(sourPeg.size()-1);
        destPeg.add(disk);
    }


    /**
     * PART 3: Add move counting and validation
     *
     * Enhance your solution to:
     * 1. Count total moves
     * 2. Verify the solution uses the minimum number of moves (2^n - 1)
     * 3. Optional: Add validation to ensure no illegal moves
     */
    public static void printStatistics(int n) {
        // TODO: Print statistics
        System.out.println("\n=== Statistics ===");
        System.out.println("Number of disks: " + n);
        System.out.println("Total moves: " + moveCount);
        System.out.println("Minimum possible moves: " + ((int)Math.pow(2, n) - 1));

        // Verify correctness
        if (moveCount == (int)Math.pow(2, n) - 1) {
            System.out.println("SUCCESS! Optimal solution.");
        } else {
            System.out.println("WARNING: Not optimal.");
        }
    }



    public static void main(String[] args) {
        // Pegs
        pegA = new ArrayList<>(Arrays.asList(3, 2, 1));
        pegB = new ArrayList<>();
        pegC = new ArrayList<>();


        int n = 3; // Start with 3 disks

        System.out.println("Tower of Hanoi - " + n + " disks");
        System.out.println("Moving disks from A to C using B\n");

        // Reset move counter
        moveCount = 0;

        // Solve the puzzle
        moveDisks(n, 'A', 'C', 'B');
        displayTowers();

        // Display statistics
        printStatistics(n);

        // Test with different numbers of disks
        System.out.println("\n\n=== Try with 4 disks ===");
        moveCount = 0;
        moveDisks(4, 'A', 'C', 'B');
        printStatistics(4);
    }
}
