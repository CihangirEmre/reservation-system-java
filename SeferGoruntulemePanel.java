import Others.Transport;
import Others.Trip;
import Others.selectedInputs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class SeferGoruntulemePanel extends JFrame{
    private JList list1;
    private JPanel seferPanel;
    private JList list2;
    private JButton rezerveEtButton;

    DefaultListModel seferList = new DefaultListModel();
    DefaultListModel koltukList = new DefaultListModel();

    int yolcuSayiCheck = selectedInputs.kisiSayisi;

    List<int[]> koltukNo = new ArrayList<>();
    public SeferGoruntulemePanel() {

        add(seferPanel);
        setTitle("Seferler");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for (Trip trip : Trip.otobusListesi) {
            if (trip.zaman.charAt(1) == selectedInputs.tarih.charAt(1)) {
                boolean check1 = false;
                boolean check2 = false;
                boolean check3 = false;


                for(String sehir : trip.guzergah) {
                    if (sehir.equals(selectedInputs.kalkisNoktasi)) {
                        check1 = true;
                    } else if (sehir.equals(selectedInputs.varisNoktasi)) {
                        check2 = true;
                    }
                }

                int bos = 0;
                if (check1 && check2) {
                    for (Transport transport : Transport.koltukDurumutList) {
                        if (transport.aracAd.equals(trip.aracAd) && transport.firmaAd.equals(trip.firmaAd)) {
                            if (transport.toplamKoltuksayisi - transport.doluKoltuksayisi >= selectedInputs.kisiSayisi) {
                                check3 = true;
                                bos = transport.toplamKoltuksayisi - transport.doluKoltuksayisi;

                            int[] koltuklar = new int[bos];
                            Random random = new Random();
                            for (int i = 0; i < bos; i++) {
                                koltuklar[i] = random.nextInt(transport.toplamKoltuksayisi) + 1;
                            }
                            koltukNo.add(koltuklar);
                            }
                        }
                    }
                }



                if (check1 && check2 && check3) {
                    seferList.addElement(trip.aracAd + "   Firma: " + trip.firmaAd + "   Bos koltuk: " + bos);
                }
            }
        }

        for (Trip trip : Trip.trenListesi) {
            if (trip.zaman.charAt(1) == selectedInputs.tarih.charAt(1)) {
                boolean check1 = false;
                boolean check2 = false;
                boolean check3 = false;


                for(String sehir : trip.guzergah) {
                    if (sehir.equals(selectedInputs.kalkisNoktasi)) {
                        check1 = true;
                    } else if (sehir.equals(selectedInputs.varisNoktasi)) {
                        check2 = true;
                    }
                }

                int bos = 0;
                if (check1 && check2) {
                    for (Transport transport : Transport.koltukDurumutList) {
                        if (transport.aracAd.equals(trip.aracAd) && transport.firmaAd.equals(trip.firmaAd)) {
                            if (transport.toplamKoltuksayisi - transport.doluKoltuksayisi >= selectedInputs.kisiSayisi) {
                                check3 = true;
                                bos = transport.toplamKoltuksayisi - transport.doluKoltuksayisi;

                            int[] koltuklar = new int[bos];
                            Random random = new Random();
                            for (int i = 0; i < bos; i++) {
                                koltuklar[i] = random.nextInt(transport.toplamKoltuksayisi) + 1;
                            }
                            koltukNo.add(koltuklar);
                            }
                        }
                    }
                }

                if (check1 && check2 && check3) {
                    seferList.addElement(trip.aracAd + "   Firma: " + trip.firmaAd + "   Bos koltuk: " + bos);
                }
            }
        }
        for (Trip trip : Trip.ucakListesi) {
            if (trip.zaman.charAt(1) == selectedInputs.tarih.charAt(1)) {
                boolean check1 = false;
                boolean check2 = false;
                boolean check3 = false;


                for (String sehir : trip.guzergah) {
                    if (sehir.equals(selectedInputs.kalkisNoktasi)) {
                        check1 = true;
                    } else if (sehir.equals(selectedInputs.varisNoktasi)) {
                        check2 = true;
                    }
                }

                int bos = 0;
                if (check1 && check2) {
                    for (Transport transport : Transport.koltukDurumutList) {
                        if (transport.aracAd.equals(trip.aracAd) && transport.firmaAd.equals(trip.firmaAd)) {
                            if (transport.toplamKoltuksayisi - transport.doluKoltuksayisi >= selectedInputs.kisiSayisi) {
                                check3 = true;
                                bos = transport.toplamKoltuksayisi - transport.doluKoltuksayisi;

                            int[] koltuklar = new int[bos];
                            Random random = new Random();
                            for (int i = 0; i < bos; i++) {
                                koltuklar[i] = random.nextInt(transport.toplamKoltuksayisi) + 1;
                            }
                            koltukNo.add(koltuklar);
                            }
                        }
                    }
                }

                if (check1 && check2 && check3) {
                    seferList.addElement(trip.aracAd + "   Firma: " + trip.firmaAd + "   Bos koltuk: " + bos);
                }
            }
        }
        list1.setModel(seferList);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list1.getSelectedIndex();
                    list1.setSelectedIndex(selectedIndex);

                    int[] koltuk = koltukNo.get(selectedIndex);
                    koltukList.clear();
                    for (int k : koltuk) {
                        koltukList.addElement(k);
                    }
                    list2.setModel(koltukList);
                }
            }
        });

        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list2.getSelectedIndex();
                    list2.setSelectedIndex(selectedIndex);
                }
            }
        });
        rezerveEtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex1 = list2.getSelectedIndex();
                int seciliKoltuk = (int) koltukList.get(selectedIndex1);
                //seciliKoltuk daha kullanmadım. Reservation class ını doldurcam.

                if (yolcuSayiCheck > 1) {
                    JOptionPane.showMessageDialog(null, "Bir tane daha koltuk seçiniz");
                    yolcuSayiCheck--;
                } else {
                    JOptionPane.showMessageDialog(null, "Tüm yolcular için koltuklar başarıyla seçildi");
                }
            }
        });
    }
}
