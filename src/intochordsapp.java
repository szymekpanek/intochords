package src;
import java.util.ArrayList;

public class intochordsapp {
    static ArrayList<String> noteslist = new ArrayList<>();
    static String[] notesarray = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" , "A", "B" ,"H"};
    public static void main(String[] args) {
        for (int i = 0; i < noteslist.size(); i++) {
            System.out.println(noteslist.get(i));
        }
    }
}