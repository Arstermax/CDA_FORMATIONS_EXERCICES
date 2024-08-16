package termometre;

import Dessin.Dessin;
import termometre.Class.Thermometre;

public class Main {
    public static void main(String[] args) {
        System.out.println("thermomètre");
        Dessin dessin = new Dessin();
        Thermometre thermometer = new Thermometre(0);
        System.out.println(thermometer.getKelvin()+ "°K = "+ thermometer.getCelsius() + "°C = " + thermometer.getFarenheit()+ "°F = ");
        thermometer.setKelvin(300);
        System.out.println(thermometer.getKelvin()+ "°K = "+ thermometer.getCelsius() + "°C = " + thermometer.getFarenheit()+ "°F = ");

        System.out.println(dessin.dessinThermometer(thermometer.getKelvin(),2,10));
    }
}

