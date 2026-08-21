public class HabitacionDoble extends Habitacion {
    private double servicioAdicional;

    public HabitacionDoble(int numero, int piso, double precioPorNoche) {
        super(numero, piso, precioPorNoche);
        this.servicioAdicional = 50;
    }

    public double calcularCostoTotal(int noches) {
        return (precioPorNoche * noches) + servicioAdicional;
    }
}