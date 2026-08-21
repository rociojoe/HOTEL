public abstract class Habitacion {
    protected int numero;
    protected int piso;
    protected double precioPorNoche;

    public Habitacion(int numero, int piso, double precioPorNoche) {
        this.numero = numero;
        this.piso = piso;
        this.precioPorNoche = precioPorNoche;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public abstract double calcularCostoTotal(int noches);
}