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

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public char getPlec() {
        return plec;
    }

    public int getNr_dzialu() {
        return nr_dzialu;
    }

    public float getPlaca() {
        return placa;
    }

    public int getWiek() {
        return wiek;
    }

    public int getDzieci() {
        return dzieci;
    }

    public boolean isStan_cywilny() {
        return stan_cywilny;
    }

    public void setNr_dzialu(int nr_dzialu) {
        this.nr_dzialu = nr_dzialu;
    }

    public void setPlaca(float placa) {
        this.placa = placa;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setDzieci(int dzieci) {
        this.dzieci = dzieci;
    }

    public void setStan_cywilny(boolean stan_cywilny) {
        this.stan_cywilny = stan_cywilny;
    }

    public static String pierwszaLiteraDuzaResztaMala(String zmienna){
        String str = zmienna.toLowerCase();
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }

    /*
DO ZROBIENIA:
• obliczanie podwyżki // procedura z parametrem, który określa procent podniesienia pensji – dodatkowo, za każde
dziecko pracownika zwiększa mu się pensję o 2 procent, natomiast pracownicy będący w formalnym związku
dodatkowo dostają 3 procent podwyżki) ;
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

    public boolean czyPensjaJestPowyzej(float wartosc){
        return wartosc > placa;
    }

    public void obliczaniePodwyżki(float procent){
        float procentNaDzieci = dzieci * 2;
        float procentNaStanCywilny = stan_cywilny ? 3 : 1;
        float podwyzka = placa*(procent+procentNaDzieci+procentNaStanCywilny)/100;
        System.out.println("OBLICZANIE PODWYZKI:");
        System.out.println("Procent podwyzki %: " + procent );
        System.out.println("dodatek do dzieci %: " + procentNaDzieci );
        System.out.println("dodatek do stanu cywilnego %: " + procentNaStanCywilny );
        System.out.println("razem %: " + (procent + procentNaDzieci + procentNaStanCywilny));
        System.out.println("Kwota podwyzki: " + podwyzka );
    }

}
