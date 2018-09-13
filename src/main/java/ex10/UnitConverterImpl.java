package ex10;

public class UnitConverterImpl implements UnitConverter {


    @Override
    public double celsiusToFahrenheit(double c) {
        return c * 9/5 + 32;
    }

    @Override
    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }

    @Override
    public double milesToKilometers(double m) {
        return m / 0.62137;
    }

    @Override
    public double kilometersToMiles(double k) {
        return k * 0.62137;
    }

    @Override
    public double poundsToKilograms(double p) {
        return p / 2.2046;
    }

    @Override
    public double kilogramsToPounds(double k) {
        return k * 2.2046;
    }

}
