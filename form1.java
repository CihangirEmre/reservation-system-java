import Others.Trip;
import Users.Admin;
import Users.Company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JButton login1Button;
    private JButton biletAraButton;
    private JTextField textField2;
    private JButton login2Button;
    private JLabel user1;
    private JLabel pass1;
    private JLabel user2;
    private JLabel pass2;
    private JPasswordField passwordField2;
    private JPasswordField passwordField1;

    /*static Trip otobus1FirmaA = Trip.otobus1FirmaA();
    static Trip otobus2FirmaA = Trip.otobus2FirmaA();

    static Trip otobus1FirmaB = Trip.otobus1FirmaB();
    static Trip otobus2FirmaB = Trip.otobus2FirmaB();

    static Trip otobus1FirmaC = Trip.otobus1FirmaC();
    static Trip ucak1FirmaC = Trip.ucak1FirmaC();
    static Trip ucak2FirmaC = Trip.ucak2FirmaC();

    static Trip tren1FirmaD = Trip.tren1FirmaD();
    static Trip tren2FirmaD = Trip.tren2FirmaD();
    static Trip tren3FirmaD = Trip.tren3FirmaD();

    static Trip ucak1FirmaF = Trip.ucak1FirmaF();
    static Trip ucak2FirmaF = Trip.ucak2FirmaF();*/


    Admin admin = new Admin("burak", "1234");
    form1() {

        add(panel1);
        setTitle("BILLAB");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        login1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String KullaniciAdi1 = textField1.getText();
                String sifre1 = String.valueOf(passwordField1.getPassword());

                if (admin.login(KullaniciAdi1, sifre1) ) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            AdminPanel adminPanel = new AdminPanel();
                            adminPanel.setVisible(true);
                            adminPanel.setLocation(400, 200);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız");
                }
            }
        });

        login2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi2 = textField2.getText();
                String sifre2 = String.valueOf(passwordField2.getPassword());

                Company company = new Company(kullaniciAdi2, sifre2);

                if (company.login(kullaniciAdi2, sifre2)) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            FirmaPanel firmaPanel = new FirmaPanel();
                            firmaPanel.setVisible(true);
                            firmaPanel.setLocation(400, 110);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız");
                }
            }
        });

        biletAraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        KullaniciForm kullaniciForm = new KullaniciForm();
                        kullaniciForm.setVisible(true);
                        kullaniciForm.setLocation(400, 170);
                    }
                });
            }
        });
    }
}
