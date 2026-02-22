package Others;

import Users.User;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public User user;
    public String aracAd;
    public String firmaAd;
    public int koltukBilgisi;

    static public List<Reservation> rezervasyonList = new ArrayList<>();

    public Reservation(User user, String aracAd, String firmaAd, int koltukBilgisi) {
        this.user = user;
        this.aracAd = aracAd;
        this.firmaAd = firmaAd;
        this.koltukBilgisi = koltukBilgisi;
    }

    static void rezervasyonEkle(User user, String aracAd, String firmaAd, int koltukBilgisi) {
        rezervasyonList.add(new Reservation(user, aracAd, firmaAd, koltukBilgisi));
    }
}
