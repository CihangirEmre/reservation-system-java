import Others.Route;
import Users.Company;
import Others.selectedInputs;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class KullaniciForm extends JFrame{
    private JPanel KullaniciPanel;
    private JList list1;
    private JList list2;
    private JList list3;
    private JButton seferBulButton;
    private JList list4;
    DefaultListModel tarihList = new DefaultListModel();
    DefaultListModel kalkisList = new DefaultListModel();
    DefaultListModel varisList = new DefaultListModel();
    DefaultListModel kisiSayisiList = new DefaultListModel();


    private String[] sehir = {"Istanbul", "Kocaeli", "Bilecik", "Ankara", "Eskisehir", "Konya"};
    private String[] tarih = {"04.10.2023", "05.10.2023", "06.10.2023", "07.10.2023",
                            "08.10.2023", "09.10.2023", "10.10.2023"};
    private String[] kisiSayisi = {"1", "2", "3", "4", "5"};

    public KullaniciForm() {
        add(KullaniciPanel);
        setTitle("Kullanıcı Paneli");
        setSize(600, 630);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tarihList.addAll(Arrays.asList(tarih));
        list1.setModel(tarihList);

        kalkisList.addAll(Arrays.asList(sehir));
        list2.setModel(kalkisList);

        varisList.addAll(Arrays.asList(sehir));
        list3.setModel(varisList);

        kisiSayisiList.addAll(Arrays.asList(kisiSayisi));
        list4.setModel(kisiSayisiList);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list1.getSelectedIndex();
                    list1.setSelectedIndex(selectedIndex);
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

        list3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list3.getSelectedIndex();
                    list3.setSelectedIndex(selectedIndex);
                }
            }
        });

        list4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list4.getSelectedIndex();
                    list4.setSelectedIndex(selectedIndex);
                }
            }
        });

        seferBulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex1 = list1.getSelectedIndex();
                selectedInputs.tarih = tarih[selectedIndex1];

                int selectedIndex2 = list2.getSelectedIndex();
                selectedInputs.kalkisNoktasi = sehir[selectedIndex2];

                int selectedIndex3 = list3.getSelectedIndex();
                selectedInputs.varisNoktasi = sehir[selectedIndex3];

                int selectedIndex4 = list4.getSelectedIndex();
                selectedInputs.kisiSayisi = selectedIndex4 + 1;

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        SeferGoruntulemePanel seferGoruntulemePanel = new SeferGoruntulemePanel();
                        seferGoruntulemePanel.setVisible(true);
                        seferGoruntulemePanel.setLocation(400, 170);
                    }
                });

            }
        });
    }
}
