package src;

import java.util.Random;
import java.util.Scanner;

public class Intochords {

    static String[] notesarray = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};

    private static void printboard(String[][] board) {
        for (String[] column : board) {
            for (String row : column) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    private static void Board(String[][] board) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int randomNote = random.nextInt(notesarray.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == j) {
                    if (notesarray[randomNote].length() == 1) {
                        board[i][j] = notesarray[randomNote] + " ";
                    } else {
                        board[i][j] = notesarray[randomNote];
                    }
                } else {
                    board[i][j] = "__";
                }
                board[i][j] += " ";
            }
        }
        System.out.println("Lista dźwięków:" + "\n" + "C, C#, D, D#, E, F, F#, G, G#, A, B, H" + "\n");
        printboard(board);
        System.out.println("\n");
        // first row answers

        boolean first_check, second_check;
        System.out.println("Podaj dzwięk [1][2]: ");
        String first_answer = scan.nextLine();
        if (first_answer.equals(notesarray[(randomNote + 4) % 12])) {
            first_check = true;
        } else {
            first_check = false;
        }

        System.out.println("Podaj dzwięk [1][3]: ");

        String second_answer = scan.nextLine();
        if (second_answer.equals(notesarray[(randomNote + 7) % 12])) {
            second_check = true;
        } else {
            second_check = false;
        }

        if (first_check && second_check) {
            System.out.println("Gratulacje akord " + notesarray[randomNote] + "," + first_answer + "," + second_answer + "\nczyli " + notesarray[randomNote] +" dur \n");
        } else System.out.println("Podane dzwięki nie tworza akordu!");
    }

    public static void main(String[] args) {
        String[][] notesBoard = new String[3][3];
        Board(notesBoard);
    }
}