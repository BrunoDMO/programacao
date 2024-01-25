package Desafio5.ex4;

public class ConversorTemperaturaPadrao implements ConversorTemperatura {
    private double celsius;
    private double fahrenheit;

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public void celsiusParaFahrenheit() {
        System.out.println(this.celsius+" Celsius é "+((this.celsius*1.8)+32)+" Fahrenheit");
    }

    @Override
    public void fahrenheitParaCelsius() {
        System.out.println(this.celsius+" Fahrenheit é "+((this.fahrenheit - 32)*5/9)+" Celsius");
    }
}
