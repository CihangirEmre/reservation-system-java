package Users;

import Others.IProfitable;

import java.util.List;
import java.util.ArrayList;

public class Company extends User implements IProfitable {
    static public List<String> adListesi = new ArrayList<>();
    static public List<String> sifreListesi = new ArrayList<>();
    public static String kullaniciAdi;


    static {
        adListesi.add("A");
        adListesi.add("B");
        adListesi.add("C");
        adListesi.add("D");
        adListesi.add("F");

        sifreListesi.add("1234");
        sifreListesi.add("1234");
        sifreListesi.add("1234");
        sifreListesi.add("1234");
        sifreListesi.add("1234");
    }

    public Company(String kullaniciAdi, String sifre) {
        super(kullaniciAdi, sifre);
        Company.kullaniciAdi = kullaniciAdi;
    }

    public static void ekleAdSifre(String kullaniciAdi, String sifre) {
        adListesi.add(kullaniciAdi);
        sifreListesi.add(sifre);
    }

    public static void cikarAdSifre(int index) {
        adListesi.remove(index);
        sifreListesi.remove(index);
    }

    @Override
    public boolean login(String gelenKullaniciAdi, String gelenSifre) {
        boolean adKontrol = false;
        boolean sifreKontrol = false;

        for (int i = 0; i < adListesi.size(); i++) {
            String ad = adListesi.get(i);
            String sifre = sifreListesi.get(i);

            if (gelenKullaniciAdi.equals(ad) && gelenSifre.equals(sifre)) {
                adKontrol = true;
                sifreKontrol = true;
                break;
            }
        }

        return adKontrol && sifreKontrol;
    }
}
