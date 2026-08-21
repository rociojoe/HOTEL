public class Suite extends Habitacion {
    private double servicioAdicional;

    public Suite(int numero, int piso, double precioPorNoche) {
        super(numero, piso, precioPorNoche);
        this.servicioAdicional = 150;
    }

    public double calcularCostoTotal(int noches) {
        return (precioPorNoche * noches) + servicioAdicional;
    }
}