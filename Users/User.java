package Users;

import Others.ILoginable;

public abstract class User implements ILoginable {
    private String kullaniciAdi;
    private String sifre;

    public User(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    @Override
    public boolean login(String gelenKullaniciAdi, String gelenSifre) {
        return gelenKullaniciAdi.equals(this.kullaniciAdi) && gelenSifre.equals(this.sifre);
    }
}
