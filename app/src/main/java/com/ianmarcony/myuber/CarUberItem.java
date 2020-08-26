package com.ianmarcony.myuber;

public class CarUberItem {
    private int imageCar;
    private String textDescription;
    private String cash;

    public CarUberItem(int imageCar, String textDescription, String cash) {
        this.imageCar = imageCar;
        this.textDescription = textDescription;
        this.cash = cash;
    }

    public int getImageCar() {
        return imageCar;
    }

    public void setImageCar(int imageCar) {
        this.imageCar = imageCar;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }
}
