package src;
import java.util.Random;
public class Intochords {
    static Random random = new Random();
    static String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" , "A", "B" ,"H"};
    public static void main(String[] args) {
        String[][] notesBoard = new String[4][4];

        int noteIndex = random.nextInt(notes.length);

        for (int i = 0; i < notesBoard.length; i++) {
            for (int j = 0; j < notesBoard[i].length; j++) {
                if (i == j) {
                    if (notes[noteIndex].length() == 1) {
                        notesBoard[i][j] = notes[noteIndex] + " ";
                    } else {
                        notesBoard[i][j] = notes[noteIndex];
                    }
                } else {
                    notesBoard[i][j] = "__";
                }
                notesBoard[i][j] += " ";
            }
        }

        for (String[] column : notesBoard) {
            for (String row : column) {
                System.out.print(row);
            }
            System.out.println();
        }
    }
}