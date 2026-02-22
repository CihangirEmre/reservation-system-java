package Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transport implements IReservable {
    public int toplamKoltuksayisi;
    public int doluKoltuksayisi;
    public String aracAd;
    public String firmaAd;

    static public List<Transport> koltukDurumutList = new ArrayList<>();

    public Transport(int koltukSayisi, int dolukoltuk, String aracAd, String firmaAd) {
        this.toplamKoltuksayisi = koltukSayisi;
        this.doluKoltuksayisi = dolukoltuk;
        this.aracAd = aracAd;
        this.firmaAd = firmaAd;
    }

    public static void koltukDurumuEkle() {
        for (Trip trip : Trip.otobusListesi) {
            int min = 4;
            int max = 10;

            Random random = new Random();
            int rastgeleSayi = random.nextInt(max - min + 1) + min;

            Transport.koltukDurumutList.add(new Transport(trip.aracTuru.koltukSayisi,
                    trip.aracTuru.koltukSayisi - rastgeleSayi, trip.aracAd, trip.firmaAd));
        }

        for (Trip trip : Trip.trenListesi) {
            int min = 10;
            int max = 20;

            Random random = new Random();
            int rastgeleSayi = random.nextInt(max - min + 1) + min;

            Transport.koltukDurumutList.add(new Transport(trip.aracTuru.koltukSayisi,
                    trip.aracTuru.koltukSayisi - rastgeleSayi, trip.aracAd, trip.firmaAd));
        }

        for (Trip trip : Trip.ucakListesi) {
            int min = 15;
            int max = 25;

            Random random = new Random();
            int rastgeleSayi = random.nextInt(max - min + 1) + min;

            Transport.koltukDurumutList.add(new Transport(trip.aracTuru.koltukSayisi,
                    trip.aracTuru.koltukSayisi - rastgeleSayi, trip.aracAd, trip.firmaAd));
        }
    }
}
