package treasurehunt2;

import java.util.Scanner;
import java.util.Random;

public class TreasureHunt2 {

    private static String[][] board = new String[10][10];
    private static int xCoord = 0; // x = row
    private static int yCoord = 0; // y = column
    private static int score;

    public static void SetBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "[  ]";
            }
        }
    }

    public static void PrintBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public static void SetTreasure() {
        Random rand = new Random();
        int NumTreasureItems = rand.nextInt((40 - 20) + 1) + 20;
        System.out.println("There are " + NumTreasureItems + " pieces of treasure on the board!");

        for (int i = 0; i < NumTreasureItems; i++) {
            board[rand.nextInt(10)][rand.nextInt(10)] = "[" + (rand.nextInt((99 - 10) + 1) + 10) + "]";
        }
    }
    

    public static void GetCoords() {

        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("- Please type in the X coordinate (row) you would like to guess. (Any number between 0 and 9):");
                xCoord = input.nextInt();
                System.out.println("- Please type in the Y coordinate (column) you would like to guess. (Any number between 0 and 9):");
                yCoord = input.nextInt();
                if (xCoord >= 0 && xCoord <= 9 && yCoord >= 0 && yCoord <= 9) {
                    break;
                } else {
                    System.out.println("Please type in numbers between 0 and 9. \n");
                }

            } catch (Exception e) {
                System.out.println("ERROR: INVALID ANSWER. " + e);
                System.out.println("Please type in only numbers between 0 and 9. \n");
            }
        }
    }

    public static void CheckTreasure() {

        if (board[xCoord][yCoord].substring(1, 3).equals("  ")) {
            System.out.println("Your coordinate does not hold any treasure! Try again! \n----------\n");
        } else {
            System.out.println("You have found treasure worth " + board[xCoord][yCoord].substring(1, 3) + " points!");
            score = score + Integer.parseInt(board[xCoord][yCoord].substring(1, 3));
            System.out.println("Your current score is " + score + "\n----------\n");
        }

    }

    public static void main(String[] args) {

        score = 0;
        int guesses = 0;

        SetBoard();
        System.out.println("Your starting board is: ");
        PrintBoard();
        System.out.println("You have 10 guesses!");
        SetTreasure();
        do {
            GetCoords();
            CheckTreasure();
            guesses++;
        } while (guesses < 5);

        System.out.println("Your final score is " + score);
        System.out.println("This is what the board looked like: ");
        PrintBoard();
    }

}
