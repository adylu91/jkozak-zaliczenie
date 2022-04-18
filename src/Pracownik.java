public class Pracownik {
    private String imie;
    private String nazwisko;
    private char plec;
    private int nr_dzialu;
    private float placa;
    private int wiek;
    private int dzieci;
    private boolean stan_cywilny;

    public Pracownik(String imie, String nazwisko, char plec, int nr_dzialu, float placa, int wiek, int dzieci, boolean stan_cywilny) {
        this.imie = pierwszaLiteraDuzaResztaMala(imie);
        this.nazwisko = pierwszaLiteraDuzaResztaMala(nazwisko);
        this.plec = plec;
        this.nr_dzialu = nr_dzialu;
        this.placa = placa;
        this.wiek = wiek;
        this.dzieci = dzieci;
        this.stan_cywilny = stan_cywilny; //jeśli true żonaty/mężatka
    }

    public static String pierwszaLiteraDuzaResztaMala(String zmienna){
        String str = zmienna.toLowerCase();
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }

    /*
DO ZROBIENIA:
• sprawdzenie czy pensja jest powyżej podanej wartości // funkcja (zwraca true – powyżej, false – poniżej lub
równa) z parametrem, który oznacza pensję do porównania (float);
• obliczanie podwyżki // procedura z parametrem, który określa procent podniesienia pensji – dodatkowo, za każde
dziecko pracownika zwiększa mu się pensję o 2 procent, natomiast pracownicy będący w formalnym związku
dodatkowo dostają 3 procent podwyżki) ;
• i inne metody pozwalające na dostęp do odpowiednich pól (zwracanie wartości każdego pola, zmiana wartości
dla pól: numer działu, płaca, wiek, stan cywilny i liczba dzieci.
     */
    public void wyswietlPelneDane(){
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Plec: " + plec);
        System.out.println("Numer dzialu: " + nr_dzialu);
        System.out.println("Placa: " + placa);
        System.out.println("Wiek: " + wiek);
        System.out.println("Ilosc dzieci: " + dzieci);
        System.out.println("Stan cywilny: " + imie);
        System.out.println();
    }

    public void wyswietlOkrojoneDane(){
        System.out.println("Imie: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Placa: " + placa);
        System.out.println();
    }

    public void wyswietlSpecjalne(){
        //imie i nazwisko z duzych liter
        System.out.println("Imie: " + imie.toUpperCase());
        System.out.println("Nazwisko: " + nazwisko.toUpperCase());
        System.out.println();
    }

}
