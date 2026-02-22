package Others;

import java.util.ArrayList;
import java.util.List;

public class Route {
    static String kalkisNoktasi;
    static String varisNoktasi;
    static int mesafe;
    static String seferTarih;


    static public List<String> kalkisListesi = new ArrayList<>();
    static public List<String> varisListesi = new ArrayList<>();
    static public List<Integer> mesafeListesi = new ArrayList<>();
    static public List<String> tarihListesi = new ArrayList<>();


    static public void seferRotasi (String kalkis, String varis, int mesafe, String tarih) {
        kalkisListesi.add(kalkis);
        varisListesi.add(varis);
        mesafeListesi.add(mesafe);
        tarihListesi.add(tarih);
    }
}
