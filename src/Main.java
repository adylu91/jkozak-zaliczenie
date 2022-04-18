import java.util.Scanner;

public class Main {
    public static int menu(){
        Scanner scanner = new Scanner(System.in);
        int wybor = 0;

        System.out.println(Kolory.greenText + "**********************]| MENU |[**************************" + Kolory.resetText);
        System.out.println("    1. WYPISZ WSZYSTKICH PRACOWNIKOW (OKROJONE DANE)");
        System.out.println("    2. DODAJ PRACOWNIKA");
        System.out.println("    3. ZAKONCZ");
        System.out.println(Kolory.greenText + "**********************************************************" + Kolory.resetText);
        System.out.println("Wpisz liczbe z menu...");

        wybor = scanner.nextInt();
        return wybor;
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        int wybor = menu();

        while(wybor != 3){
            switch (wybor) {
                case 1 -> lista.wyswietlPracownikowDaneOkrojone();
                case 2 -> lista.dodajPracownika();
            }
            wybor = menu();
        }

        System.out.println(Kolory.redText + "*** ZAKONCZONO DZIALANIE PROGRAMU ***" + Kolory.resetText);
    }
}