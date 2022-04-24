import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static int menu(){
        Scanner scanner = new Scanner(System.in);
        int wybor = 0;

        System.out.println(Kolory.greenText + "**********************]| MENU |[**************************" + Kolory.resetText);
        System.out.println(Kolory.yellowText + "    1. WYPISZ WSZYSTKICH PRACOWNIK�W (OKROJONE DANE)");
        System.out.println("    2. DODAJ PRACOWNIKA");
        System.out.println("    3. ZAPISZ PRACOWNIK�W DO PLIKU TEKSTOWEGO");
        System.out.println("    4. USU� PRACOWNIKA");
        System.out.println("    5. EDYCJA DANYCH PRACOWNIKA");
        System.out.println("    0. ZAKO�CZ");
        System.out.println(Kolory.greenText + "**********************************************************" + Kolory.resetText);
        System.out.println("Wpisz liczb� z menu...");

        wybor = scanner.nextInt();
        return wybor;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Lista lista = new Lista();

        int wybor = menu();

        while(wybor != 0){
            switch (wybor) {
                    case 1 -> lista.wyswietlPracownikowDaneOkrojone();
                    case 2 -> lista.dodajPracownika();
                    case 3 -> lista.eksportDoPlikuTekstowego();
                    case 4 -> lista.usunPracownika();
                    case 5 -> lista.edycjaDanych();
                }
            wybor = menu();
        }

        System.out.println(Kolory.redText + "*** ZAKO�CZONO DZIA�ANIE PROGRAMU ***" + Kolory.resetText);
    }
}