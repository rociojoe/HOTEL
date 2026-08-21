import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;
    private Scanner sc;

    public Hotel() {
        habitaciones = new ArrayList<Habitacion>();
        reservas = new ArrayList<Reserva>();
        sc = new Scanner(System.in);
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public void listarReservasActivas() {
        System.out.println("----- Reservas Activas -----");
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.isActiva()) {
                System.out.println(r.toString());
            }
        }
    }

    public double calcularIngresoTotal() {
        double total = 0;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.isActiva()) {
                total = total + r.calcularCosto();
            }
        }
        return total;
    }

    public void listarHabitaciones() {
        System.out.println("----- Habitaciones -----");
        for (int i = 0; i < habitaciones.size(); i++) {
            Habitacion h = habitaciones.get(i);
            System.out.println((i + 1) + ". Numero: " + h.getNumero() + " | Piso: " + h.getPiso() + " | Precio noche: " + h.getPrecioPorNoche());
        }
    }

    public void crearReserva() {
        System.out.println("Ingrese nombre del cliente:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido del cliente:");
        String apellido = sc.nextLine();
        System.out.println("Ingrese cedula del cliente:");
        String cedula = sc.nextLine();
        System.out.println("Ingrese telefono del cliente:");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, cedula, telefono);

        listarHabitaciones();
        System.out.println("Elija el numero de habitacion (de la lista, 1 al " + habitaciones.size() + "):");
        int opcion = Integer.parseInt(sc.nextLine());
        Habitacion habitacionElegida = habitaciones.get(opcion - 1);

        System.out.println("Ingrese fecha de entrada (ejemplo 20/08/2026):");
        String fecha = sc.nextLine();

        System.out.println("Ingrese numero de noches:");
        int noches = Integer.parseInt(sc.nextLine());

        Reserva nuevaReserva = new Reserva(cliente, habitacionElegida, fecha, noches);
        reservas.add(nuevaReserva);

        System.out.println("Reserva creada con exito. Costo total: " + nuevaReserva.calcularCosto());
    }

    public void menu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("");
            System.out.println("===== MENU HOTEL =====");
            System.out.println("1. Crear reserva");
            System.out.println("2. Listar reservas activas");
            System.out.println("3. Ver ingreso total del hotel");
            System.out.println("4. Listar habitaciones");
            System.out.println("0. Salir");
            System.out.println("Elija una opcion:");
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                crearReserva();
            } else if (opcion == 2) {
                listarReservasActivas();
            } else if (opcion == 3) {
                System.out.println("Ingreso total: " + calcularIngresoTotal());
            } else if (opcion == 4) {
                listarHabitaciones();
            } else if (opcion == 0) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida");
            }
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.agregarHabitacion(new HabitacionSimple(101, 1, 200));
        hotel.agregarHabitacion(new HabitacionDoble(102, 1, 300));
        hotel.agregarHabitacion(new Suite(201, 2, 500));

        hotel.menu();
    }
}