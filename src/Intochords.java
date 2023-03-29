package src;

import java.util.Random;
import java.util.Scanner;

public class Intochords {
    static String[] noteslist = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};

    private static void printboard(String[][] board) {
        for (String[] column : board) {
            for (String row : column) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    private static void fill_the_board(String[][] board) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int randomNote = random.nextInt(noteslist.length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == j) {
                    if (noteslist[randomNote].length() == 1) {
                        board[i][j] = noteslist[randomNote] + " ";
                    } else {
                        board[i][j] = noteslist[randomNote];
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

        boolean first_check, seckond_check;
        System.out.println("Podaj dzwięk [1][2]: ");
        String first_answer = scan.nextLine();
        if (first_answer.equals(noteslist[(randomNote + 4) % 12])) {
            first_check = true;
        } else {
            first_check = false;
        }

        System.out.println("Podaj dzwięk [1][3]: ");

        String seckond_answer = scan.nextLine();
        if (seckond_answer.equals(noteslist[(randomNote + 7) % 12])) {
            seckond_check = true;
        } else {
            seckond_check = false;
        }

        if (first_check && seckond_check) {
            System.out.println("Powstał akord " + noteslist[randomNote] + "," + first_answer + "," + seckond_answer + "\n");
        } else System.out.println("Podane dzwięki nie tworza akordu!");
    }

    public static void main(String[] args) {
        String[][] notesBoard = new String[3][3];
        fill_the_board(notesBoard);
    }
}