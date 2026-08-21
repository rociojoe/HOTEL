public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private String fechaEntrada;
    private int noches;
    private boolean activa;

    public Reserva(Cliente cliente, Habitacion habitacion, String fechaEntrada, int noches) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.noches = noches;
        this.activa = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public int getNoches() {
        return noches;
    }

    public boolean isActiva() {
        return activa;
    }

    public void cancelar() {
        this.activa = false;
    }

    public double calcularCosto() {
        return habitacion.calcularCostoTotal(noches);
    }

    public String toString() {
        return "Reserva - Cliente: " + cliente.getNombre() + " " + cliente.getApellido()
                + " | Habitacion N: " + habitacion.getNumero()
                + " | Fecha entrada: " + fechaEntrada
                + " | Noches: " + noches
                + " | Costo: " + calcularCosto()
                + " | Activa: " + activa;
    }
}