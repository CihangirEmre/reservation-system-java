package Vehicles;

public abstract class Vehicle {
    public String yakitTuru;
    public int koltukSayisi;

    public Vehicle(String yakitTuru, int koltukSayisi) {
        this.yakitTuru = yakitTuru;
        this.koltukSayisi = koltukSayisi;
    }

    abstract void CalculateFuelCost();
}
