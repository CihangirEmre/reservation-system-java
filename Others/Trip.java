package Others;

import Vehicles.Airplane;
import Vehicles.Bus;
import Vehicles.Train;
import Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trip {
    public List<String> guzergah = new ArrayList<>();
    public Vehicle aracTuru;
    public String zaman;
    public String firmaAd;
    public String aracAd;


    static public List<Trip> otobusListesi = new ArrayList<>();
    static public List<Trip> trenListesi = new ArrayList<>();
    static public List<Trip> ucakListesi = new ArrayList<>();


    static public final String[] sefer1 = {"Istanbul", "Kocaeli", "Bilecik", "Eskisehir", "Ankara", "Eskisehir",
            "Bilecik", "Kocaeli", "Istanbul"};
    static public final String[] sefer2 = {"Istanbul", "Kocaeli", "Bilecik", "Eskisehir", "Konya", "Eskisehir",
            "Bilecik", "Kocaeli", "Istanbul"};
    static public final String[] sefer3 = {"Istanbul", "Kocaeli", "Ankara", "Kocaeli", "Istanbul"};
    static public final String[] sefer4 = {"Istanbul", "Kocaeli", "Eskisehir", "Konya", "Eskisehir",
            "Kocaeli", "Istanbul"};
    static public final String[] sefer5 = {"Istanbul", "Konya", "Istanbul"};
    static public final String[] sefer6 = {"Istanbul", "Ankara", "Istanbul"};


    // 0: istanbul    1: kocaeli   2: ankara   3: eskişehir   4: konya
    static public final int[] istanbulKarayoluKalkis = {0, 50, 300, 150, 300};
    static public final int[] kocaeliKarayoluKalkis = {50, 0, 400, 100, 250};
    static public final int[] ankaraKarayoluKalkis = {300, 300, 0, 0, 0};
    static public final int[] eskisehirKarayoluKalkis = {150, 100, 0, 0, 150};
    static public final int[] konyaKarayoluKalkis = {300, 250, 0, 150, 0};

    // 0: istanbul    1: kocaeli   2: bilecik   3: ankara   4: eskişehir   5: konya
    static public final int[] istanbulDemiryoluKalkis = {0, 50, 150, 250, 200, 300};
    static public final int[] kocaeliDemiryoluKalkis = {50, 0, 50, 200, 100, 250};
    static public final int[] bilecikDemiryoluKalkis = {150, 50, 0, 150, 50, 200};
    static public final int[] ankaraDemiryoluKalkis = {250, 200, 150, 0, 100, 0};
    static public final int[] eskisehirDemiryoluKalkis = {200, 100, 50, 100, 0, 150};
    static public final int[] konyaDemiryoluKalkis = {300, 250, 200, 0, 150, 0};

    // 0: istanbul    1: ankara   2: konya
    static public final int[] istanbulHavayoluKalkis = {0, 1000, 1200};
    static public final int[] ankaraHavayoluKalkis = {1000, 0, 0};
    static public final int[] konyaHavayoluKalkis = {1200, 0, 0};

    public Trip(Vehicle aracTuru, String zaman, String[] sefer, String firmaAd, String aracAd) {
        this.aracTuru = aracTuru;
        this.zaman = zaman;
        guzergah.addAll(Arrays.asList(sefer));
        this.firmaAd = firmaAd;
        this.aracAd = aracAd;
    }

    public Trip() {
        this.aracTuru = new Bus("be", 10);
        this.zaman = "0";
        guzergah.add("bos");
    }

    static public Trip otobus1FirmaA = new Trip(new Bus("benzin", 40),
                "04.12.2023",
                Trip.sefer3, "A", "otobus1"
        );


    public static Trip otobus2FirmaA = new Trip(new Bus("benzin", 30),
                "05.12.2023",
                Trip.sefer3, "A", "otobus2"
        );

    public static Trip otobus1FirmaB = new Trip(new Bus("motorin", 30),
                "06.12.2023",
                Trip.sefer3, "B", "otobus1"
        );

    public static Trip otobus2FirmaB = new Trip(new Bus("motorin", 40),
                "06.12.2023",
                Trip.sefer4, "B", "otobus2"
        );

    public static Trip otobus1FirmaC = new Trip(new Bus("motorin", 40),
                "07.12.2023",
                Trip.sefer4, "C", "otobus1"
        );

    public static Trip ucak1FirmaC = new Trip(new Airplane(60),
                "08.12.2023",
                Trip.sefer5, "C", "ucak1"
        );

    public static Trip ucak2FirmaC = new Trip(new Airplane(60),
                "09.12.2023",
                Trip.sefer5, "C", "ucak2"
        );

    public static Trip tren1FirmaD = new Trip(new Train(50),
                "04.12.2023",
                Trip.sefer1, "D", "tren1"
        );

    public static Trip tren2FirmaD = new Trip(new Train(50),
                "09.12.2023",
                Trip.sefer2, "D", "tren2"
        );

    public static Trip tren3FirmaD = new Trip(new Train(50),
                "08.12.2023",
                Trip.sefer2, "D", "tren3"
        );


    public static Trip ucak1FirmaF = new Trip(new Airplane(60),
                "04.12.2023",
                Trip.sefer6, "F", "ucak1"
        );

    public static Trip ucak2FirmaF = new Trip(new Airplane(60),
                "10.12.2023",
                Trip.sefer6, "F", "ucak2"
        );

    static {
        otobusListesi.add(Trip.otobus1FirmaA);
        otobusListesi.add(Trip.otobus2FirmaA);
        otobusListesi.add(Trip.otobus1FirmaB);
        otobusListesi.add(Trip.otobus2FirmaB);
        otobusListesi.add(Trip.otobus1FirmaC);

        trenListesi.add(Trip.tren1FirmaD);
        trenListesi.add(Trip.tren2FirmaD);
        trenListesi.add(Trip.tren3FirmaD);

        ucakListesi.add(Trip.ucak1FirmaC);
        ucakListesi.add(Trip.ucak2FirmaC);
        ucakListesi.add(Trip.ucak1FirmaF);
        ucakListesi.add(Trip.ucak2FirmaF);
    }

    public static void cikarArac(String arac, String firma) {
        if (arac.contains("otobus")) {
            for (int i = 0; i < Trip.otobusListesi.size(); i++) {
                Trip getTrip = Trip.otobusListesi.get(i);
                if (getTrip.aracAd.equals(arac) && getTrip.firmaAd.equals(firma)) {
                    Trip.otobusListesi.remove(i);
                }
            }
        } else if (arac.contains("ucak")) {
            for (int i = 0; i < Trip.ucakListesi.size(); i++) {
                Trip getTrip = Trip.ucakListesi.get(i);
                if (getTrip.aracAd.equals(arac) && getTrip.firmaAd.equals(firma)) {
                    Trip.ucakListesi.remove(i);
                }
            }
        } else if (arac.contains("tren")) {
            for (int i = 0; i < Trip.trenListesi.size(); i++) {
                Trip getTrip = Trip.trenListesi.get(i);
                if (getTrip.aracAd.equals(arac) && getTrip.firmaAd.equals(firma)) {
                    Trip.trenListesi.remove(i);
                }
            }
        }
    }

    public static void ekleArac (int kacinciSefer, String firma, String aracAdi,
                                 int koltukSayisi, String yakitTuru, String tarih) {
        if (kacinciSefer == 3 || kacinciSefer == 4) {
            Bus yeniBus = new Bus(yakitTuru, koltukSayisi);

            if (kacinciSefer == 3) {
                Trip yeniTrip = new Trip(yeniBus, tarih, Trip.sefer3, firma, aracAdi);
                otobusListesi.add(yeniTrip);
            } else {
                Trip yeniTrip = new Trip(yeniBus, tarih, Trip.sefer4, firma, aracAdi);
                otobusListesi.add(yeniTrip);
            }
        }
        else if (kacinciSefer == 1 || kacinciSefer == 2) {
            Train yeniTrain = new Train(50);

            if (kacinciSefer == 1) {
                Trip yeniTrip = new Trip(yeniTrain, tarih, Trip.sefer1, firma, aracAdi);
                trenListesi.add(yeniTrip);
            } else {
                Trip yeniTrip = new Trip(yeniTrain, tarih, Trip.sefer2, firma, aracAdi);
                trenListesi.add(yeniTrip);
            }
        }
        else if (kacinciSefer == 5 || kacinciSefer == 6) {
            Airplane yeniAirplane = new Airplane(60);

            if (kacinciSefer == 5) {
                Trip yeniTrip = new Trip(yeniAirplane, tarih, Trip.sefer5, firma, aracAdi);
                ucakListesi.add(yeniTrip);
            } else {
                Trip yeniTrip = new Trip(yeniAirplane, tarih, Trip.sefer6, firma, aracAdi);
                ucakListesi.add(yeniTrip);
            }
        }
    }
}