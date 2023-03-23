package src;
import java.util.Random;
// zasady gry
// w przekatna macierzy 3x3 wpisujemy jeden dzwiek z 12
// zadaniem gracza jest dopisanie pozostałych dzwieków do macierzy tak aby powstały kolejne akordy
// Zasada budowania akordów:
// pierwszy dziwek [1][1] to pryma akordu czyli pierwszy dziwek
// nastepne pole ([1][2]) to tercja wielka akordu
// -> tercja wielka to odległośc miedzy pryma o 4 półtony czyli 4 dzwieki
// np: jezeli nasza prymą jest c to tercje wielka liczymy tak:
// C -> C# -> D -> D# -> E czyli 4 dzwięk od C
// Pole [1][3] to kwina czysta akordu czyli odległość od prymy o 7 półtonów albo od tercji wielkiej 3 półtony
// C -> C# -> D -> D# -> E -> F -> F# -> G    lub od tercji wielkiej akordu E -> F -> F# -> G
// tak nam powstaje akord C dur który ma dzwieki CEG i to program ma akceptować
// ------------------------------------------------------------------------------------------------------------------

// Kiedy zbudowalismy pierwszy wiersz teraz przychodzi czas na kolejny wiersz
// zasady sa te same lecz teraz mamy podana tercje wielka która jest dzwiek C
// zatem aby obliczyć pierwszy dziwek cofamy sie 4 półtony
// C -> H -> B -> A -> G#  ----> dzwiek G# to nasza pryma
// teraz trzeba zbudować od tercji lub od prymy kwinte
// Łatwiej zbudować od tercji wiec tak też zrobie
// C -> C# -> D -> D#
// i w ten sposób mamy akord G# dur składajacy sie z dzwieków G# C D#
// ------------------------------------------------------------------------------------------------------------------
// 3 wiersz macierzy oznacza, że mamy podana kwinte akordu
// Zatem liczymy wstecz od C 3 półtony aby uzyskać tercje wielka akordu
// C -> H -> B -> A ----> mamy tercje wielka (A)
// nastepnie od obliczamy 4 półtony w dół do prymy
// A -> G# -> G -> F# -> F ---> i mamy pryme akordu (F)
// powstaje nam akord F dur
// ------------------------------------------------------------------------------------------------------------------

// tak powinna wyglądać dobrze zrobiona tabelka w grze
// [C]  [E]  [G]
// [G#] [C]  [D#]
// [F]  [A]  [C]

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