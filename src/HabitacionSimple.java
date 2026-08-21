public class HabitacionSimple extends Habitacion {

    public HabitacionSimple(int numero, int piso, double precioPorNoche) {
        super(numero, piso, precioPorNoche);
    }

    public double calcularCostoTotal(int noches) {
        return precioPorNoche * noches;
    }
}