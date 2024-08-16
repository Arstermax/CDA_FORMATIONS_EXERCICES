package termometre.Class;

public class Thermometre {
    private double kelvin;

    public Thermometre(double kelvin) {
        this.kelvin = kelvin;
    }//SET

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    // GET
    public double getFarenheit() {
        return (this.kelvin - 273.15) * 9 / 5 + 32;
    }

    public double getKelvin() {
        return this.kelvin;
    }

    public double getCelsius() {
        return this.kelvin - 273.15;
    }
}
