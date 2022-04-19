import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lista {
    Pracownik[] pracownicy;

    public Lista() {
        pracownicy = new Pracownik[100];
    }

    public void dodajPracownika(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj plec (M/K):");
        char plec = scanner.nextLine().charAt(0);
        System.out.println("Podaj numer dzialu:");
        int nr_dzialu = scanner.nextInt();
        System.out.println("Podaj place:");
        float placa = scanner.nextFloat();
        System.out.println("Podaj wiek:");
        int wiek = scanner.nextInt();
        System.out.println("Podaj ilosc dzieci:");
        int dzieci = scanner.nextInt();
        System.out.println("Podaj stan cywilny - true(zonaty/mezatak), false(panna/kawaler):");
        boolean stan_cywilny = scanner.nextBoolean();
        scanner.nextLine();

        Pracownik pracownik = new Pracownik(imie, nazwisko, plec, nr_dzialu, placa, wiek, dzieci, stan_cywilny);
        //sprawdź czy tablica nie jest pełna
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i] == null){
                break;
            }else if(i == pracownicy.length-1 && pracownicy[i] != null){
                System.out.println("Blad! dodano zbyt wielu pracownikow.");
                return;
            }
        }

        //jeśli nie jest pełna, przejdź do dodania pracownika
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i] == null){
                pracownicy[i] = pracownik;
                System.out.println(Kolory.greenText + "Dodano pracownika" + Kolory.resetText);
                break;
            }
        }
    }
    public void wyswietlPracownikowDaneOkrojone(){
        System.out.println(Kolory.greenText + "Lista pracownikow (dane okrojone):" + Kolory.resetText);
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i]!=null) {
                System.out.println("ID: " + i);
                pracownicy[i].wyswietlOkrojoneDane();
            }
        }
    }

    public void wyswietlPracownikowDanePelne(){
        System.out.println(Kolory.greenText + "Lista pracownikow (dane pelne):" + Kolory.resetText);
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i]!=null) {
                System.out.println("ID: " + i);
                pracownicy[i].wyswietlPelneDane();
            }
        }
    }
    public void eksportDoPlikuTekstowego() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String nazwaPliku = "";
        String str = "";

        System.out.println("Podaj nazwe pliku bez rozszerzenia: ");
        nazwaPliku = scanner.nextLine();

        PrintWriter printWriter = new PrintWriter(nazwaPliku + ".txt");
        for(Pracownik p: pracownicy){
            if (p != null) {
                str += p.getNazwisko() + " ";
                str += p.getImie() + " ";
                str += p.getPlec() + " ";
                str += p.getNr_dzialu() + " ";
                str += p.getPlaca();
                str += p.getWiek();
                str += p.getDzieci();
                str += "\n";
            } else {
                break;
            }
        }
        str = str.trim();
        printWriter.println(str);
        printWriter.close();
    }
    public void usunPracownika(){
        Scanner scanner = new Scanner(System.in);
        int idPracownika = 0;
        wyswietlPracownikowDanePelne();
        System.out.println("Podaj ID pracownika do usuniecia: ");
        idPracownika = scanner.nextInt();
        scanner.nextLine();
        pracownicy[idPracownika] = null;
        System.out.println("Pracownik o ID: " + idPracownika + " zostal usuniety");
    }

}