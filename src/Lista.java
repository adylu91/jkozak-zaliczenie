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
        System.out.println("Podaj imiê:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj p³eæ (M/K):");
        char plec = scanner.nextLine().charAt(0);
        System.out.println("Podaj numer dzia³u:");
        int nr_dzialu = scanner.nextInt();
        System.out.println("Podaj p³acê:");
        float placa = scanner.nextFloat();
        System.out.println("Podaj wiek:");
        int wiek = scanner.nextInt();
        System.out.println("Podaj iloœæ dzieci:");
        int dzieci = scanner.nextInt();
        System.out.println("Podaj stan cywilny - true(zonaty/mezatak), false(panna/kawaler):");
        boolean stan_cywilny = scanner.nextBoolean();
        scanner.nextLine();

        Pracownik pracownik = new Pracownik(imie, nazwisko, plec, nr_dzialu, placa, wiek, dzieci, stan_cywilny);
        //sprawdŸ czy tablica nie jest pe³na
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i] == null){
                break;
            }else if(i == pracownicy.length-1 && pracownicy[i] != null){
                System.out.println("B³¹d! Dodano zbyt wielu pracowników.");
                return;
            }
        }

        //jeœli nie jest pe³na, przejdŸ do dodania pracownika
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i] == null){
                pracownicy[i] = pracownik;
                System.out.println(Kolory.greenText + "Dodano pracownika, wciœnij enter aby kontynuowaæ..." + Kolory.resetText);
                scanner.nextLine();
                break;
            }
        }
    }
    public void wyswietlPracownikowDaneOkrojone(){
        System.out.println(Kolory.greenText + "Lista pracowników (dane okrojone):" + Kolory.resetText);
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i]!=null) {
                System.out.println("ID: " + i);
                pracownicy[i].wyswietlOkrojoneDane();
            }
        }
    }
    public void wyswietlPracownikowDaneSpecjalne(){
        System.out.println(Kolory.greenText + "Lista pracownikow (dane specjalne):" + Kolory.resetText);
        for(int i=0; i<pracownicy.length; i++){
            if(pracownicy[i]!=null) {
                System.out.println("ID: " + i);
                pracownicy[i].wyswietlSpecjalneDane();
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

    private int edycjaDanychMenu(int id){
        Scanner scanner = new Scanner(System.in);
        int wyborMenu = -1;

        System.out.println("Podaj numer edycji danych:");
        System.out.println("1.numer dzia³u");
        System.out.println("2.p³aca");
        System.out.println("3.wiek");
        System.out.println("4.liczba dzieci");
        System.out.println("5.stan cywilny");
        if(pracownicy[id].getPlec() == 'K') {
            System.out.println("6. nazwisko");
        }
        System.out.println("0.Zakoñcz edycjê");

        wyborMenu = scanner.nextInt();
        scanner.nextLine();
        return wyborMenu;
    }
    public void edycjaDanych(){
        Scanner scanner = new Scanner(System.in);
        int id = -1;
        int wyborMenu = -1;
        String infoZaktualizowane = "Dane zaktualizowane, wciœnij enter aby kontynuowaæ...";

        wyswietlPracownikowDanePelne();
        System.out.println("Wpisz ID pracownika do edycji:");
        id = scanner.nextInt();
        scanner.nextLine();
        pracownicy[id].wyswietlSpecjalneDane();

        while(wyborMenu != 0){
            switch (wyborMenu){
                case 1 -> {
                    System.out.println("Podaj nowy numer dzia³u");
                    pracownicy[id].setNr_dzialu(scanner.nextInt());
                    System.out.println(infoZaktualizowane);
                    scanner.nextLine();
                }
                case 2 -> {
                    System.out.println("Podaj nowa placê");
                    pracownicy[id].setPlaca(scanner.nextFloat());
                    System.out.println(infoZaktualizowane);
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("Podaj nowy wiek");
                    pracownicy[id].setWiek(scanner.nextInt());
                    System.out.println(infoZaktualizowane);
                    scanner.nextLine();
                }
                case 4 -> {
                    System.out.println("Podaj liczbê dzieci");
                    pracownicy[id].setDzieci(scanner.nextInt());
                    System.out.println(infoZaktualizowane);
                    scanner.nextLine();
                }
                case 5 -> {
                    System.out.println("Podaj stan cywilny");
                    pracownicy[id].setStan_cywilny(scanner.nextBoolean());
                    System.out.println(infoZaktualizowane);
                    scanner.nextLine();

                }
                case 6 -> {
                    if (pracownicy[id].getPlec() == 'K') {
                        System.out.println("Podaj nowe naziwsko");
                        pracownicy[id].setNazwisko(scanner.nextLine());
                        System.out.println(infoZaktualizowane);
                        scanner.nextLine();
                    }
                }
            }

            wyborMenu = edycjaDanychMenu(id);
        }

    }
}