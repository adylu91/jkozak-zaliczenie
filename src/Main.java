import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static int menu(){
        Scanner scanner = new Scanner(System.in);
        int wybor = 0;

        System.out.println(Kolory.greenText + "**********************]| MENU |[**************************" + Kolory.resetText);
        System.out.println("    1. WYPISZ WSZYSTKICH PRACOWNIKOW (OKROJONE DANE)");
        System.out.println("    2. DODAJ PRACOWNIKA");
        System.out.println("    3. ZAPISZ PRACOWNIKOW DO PLIKU TEKSTOWEGO");
        System.out.println("    4. USUN PRACOWNIKA");
        System.out.println("    0. ZAKONCZ");
        System.out.println(Kolory.greenText + "**********************************************************" + Kolory.resetText);
        System.out.println("Wpisz liczbe z menu...");

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
                }
            wybor = menu();
        }

        System.out.println(Kolory.redText + "*** ZAKONCZONO DZIALANIE PROGRAMU ***" + Kolory.resetText);
    }
}