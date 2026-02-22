import Users.Company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPanel extends JFrame {
    private JPanel AdminPanel;
    private JList list1;
    private JTextField sifreTextField;
    private JTextField firmaAdiTextField;
    private JButton ekleButton;
    private JButton seciliFirmayiSilButton;
    DefaultListModel listModel1 = new DefaultListModel();
    public AdminPanel() {
        add(AdminPanel);
        setTitle("Admin Paneli");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for (String ad : Company.adListesi) {
            listModel1.addElement(ad);
        }
        list1.setModel(listModel1);

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yeniFirmaAd = firmaAdiTextField.getText();
                String yeniFirmaSifre = sifreTextField.getText();

                Company.ekleAdSifre(yeniFirmaAd, yeniFirmaSifre);

                listModel1.addElement(yeniFirmaAd);

                JOptionPane.showMessageDialog(null, "Firma Eklendi");
            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedIndex = list1.getSelectedIndex();
                    list1.setSelectedIndex(selectedIndex);
                }
            }
        });
        seciliFirmayiSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel1.remove(selectedIndex);

                    Company.cikarAdSifre(selectedIndex);
                }
            }
        });
    }
}
