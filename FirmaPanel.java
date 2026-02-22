import Others.Transport;
import Others.Trip;
import Users.Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

public class FirmaPanel extends JFrame {
    private JPanel FirmaPanel;
    private JList list1;
    private JButton seciliSeferiSilButton;
    private JList list2;
    private JTextField textField1;
    private JButton seferEkleButton;
    private JTextField textField2;
    private JTextField textField3;
    DefaultListModel listModel1 = new DefaultListModel();
    DefaultListModel listModel2 = new DefaultListModel();


    private String title = Company.kullaniciAdi + " Firması";


    public FirmaPanel() {
        add(FirmaPanel);
        setTitle(title);
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for (Trip trip : Trip.otobusListesi) {
            if (trip.firmaAd.equals(Company.kullaniciAdi)) {
                listModel1.addElement(trip.aracAd);
            }
        }
        for (Trip trip : Trip.trenListesi) {
            if (trip.firmaAd.equals(Company.kullaniciAdi)) {
                listModel1.addElement(trip.aracAd);
            }
        }
        for (Trip trip : Trip.ucakListesi) {
            if (trip.firmaAd.equals(Company.kullaniciAdi)) {
                listModel1.addElement(trip.aracAd);
            }
        }
        list1.setModel(listModel1);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list1.getSelectedIndex();
                    list1.setSelectedIndex(selectedIndex);
                }
            }
        });

        seciliSeferiSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex != -1) {
                    String cikarilicakArac = (String) listModel1.getElementAt(selectedIndex);

                    listModel1.remove(selectedIndex);

                    Trip.cikarArac(cikarilicakArac, Company.kullaniciAdi);
                }
            }
        });

        listModel2.addElement("Sefer 1: " + Arrays.asList(Trip.sefer1));
        listModel2.addElement("Sefer 2: " + Arrays.asList(Trip.sefer2));
        listModel2.addElement("Sefer 3: " + Arrays.asList(Trip.sefer3));
        listModel2.addElement("Sefer 4: " + Arrays.asList(Trip.sefer4));
        listModel2.addElement("Sefer 5: " + Arrays.asList(Trip.sefer5));
        listModel2.addElement("Sefer 6: " + Arrays.asList(Trip.sefer6));
        list2.setModel(listModel2);

        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list2.getSelectedIndex();
                    list2.setSelectedIndex(selectedIndex);
                }
            }
        });

        seferEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aracAd = textField1.getText();
                String yakit_koltuk = textField2.getText();
                String tarih = textField3.getText();
                int koltukSayisi = 0;
                String yakitTuru = "";

                if (!yakit_koltuk.isEmpty()) {
                    String[] bolunmus = yakit_koltuk.split(" ");
                    yakitTuru = bolunmus[0];
                    koltukSayisi = Integer.parseInt(bolunmus[1]);
                }

                int selectedIndex = list2.getSelectedIndex();
                if (selectedIndex != -1) {
                    Trip.ekleArac(selectedIndex + 1, Company.kullaniciAdi, aracAd,
                                koltukSayisi, yakitTuru, tarih);

                    if (selectedIndex == 2 || selectedIndex == 3) {
                        for (Trip trip : Trip.otobusListesi) {
                            if (trip.firmaAd.equals(Company.kullaniciAdi) && trip.aracAd.equals(aracAd)) {
                                listModel1.addElement(trip.aracAd);

                                int min = 15;
                                int max = 25;

                                Random random = new Random();
                                int rastgeleSayi = random.nextInt(max - min + 1) + min;

                                Transport.koltukDurumutList.add(new Transport(trip.aracTuru.koltukSayisi,
                                        trip.aracTuru.koltukSayisi - rastgeleSayi, trip.aracAd, trip.firmaAd));
                            }
                        }
                    }
                    else if (selectedIndex == 0 || selectedIndex == 1) {
                        for (Trip trip : Trip.trenListesi) {
                            if (trip.firmaAd.equals(Company.kullaniciAdi) && trip.aracAd.equals(aracAd)) {
                                listModel1.addElement(trip.aracAd);

                                int min = 10;
                                int max = 20;

                                Random random = new Random();
                                int rastgeleSayi = random.nextInt(max - min + 1) + min;

                                Transport.koltukDurumutList.add(new Transport(trip.aracTuru.koltukSayisi,
                                        trip.aracTuru.koltukSayisi - rastgeleSayi, trip.aracAd, trip.firmaAd));
                            }
                        }
                    }
                    else if (selectedIndex == 4 || selectedIndex == 5) {
                        for (Trip trip : Trip.ucakListesi) {
                            if (trip.firmaAd.equals(Company.kullaniciAdi) && trip.aracAd.equals(aracAd)) {
                                listModel1.addElement(trip.aracAd);

                                int min = 15;
                                int max = 25;

                                Random random = new Random();
                                int rastgeleSayi = random.nextInt(max - min + 1) + min;

                                Transport.koltukDurumutList.add(new Transport(trip.aracTuru.koltukSayisi,
                                        trip.aracTuru.koltukSayisi - rastgeleSayi, trip.aracAd, trip.firmaAd));
                            }
                        }
                    }
                }
            }
        });
    }
}
