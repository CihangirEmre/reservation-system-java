import Others.Transport;
import Others.Trip;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Transport.koltukDurumuEkle();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form1 f1 = new form1();
                f1.setVisible(true);
                f1.setLocation(400, 160);
            }
        });
    }
}
