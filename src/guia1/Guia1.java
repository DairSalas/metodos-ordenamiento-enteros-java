package guia1;

/**
 *
 * @author Dair Salas
 */
public class Guia1 {

    public static void mostrarVector(MetodosOrdenamiento ordenar) {
        String datosVector = "";
        for (int i = 0; i < ordenar.getNumElementos(); i++) {
            datosVector = datosVector + String.valueOf("Posicion " + i + ": " + ordenar.getVectorDatos(i) + "\n");
        }
        Alerts.print("============ ELEMENTOS DEL VECTOR============" + "\n" + datosVector);
    }

    public static int menu() {
        int opcion = Alerts.inputInt("====== Seleccione el Método de Ordenamiento == == == \n"
                + "1. Ordenamiento Burbuja \n"
                + "2. Ordenamiento por Intercambio \n"
                + "3. Ordenamiento por Seleccion \n"
                + "4. Ordenamiento shell \n"
                + "5. Ordenamiento quick sort\n"
                + "6. Salir");
        return opcion;
    }

    public static void main(String[] args) {
        MetodosOrdenamiento original = new MetodosOrdenamiento();

        int numeroElementos = Alerts.inputInt("Digite el Número de Elementos del Vector:");

        original.setNumElementos(numeroElementos);
        original.crearVector();

        for (int i = 0; i < original.getNumElementos(); i++) {
            int dato = Alerts.inputInt("Digitar Elemento de la Posición" + i + ": ");
            original.setVectorDatos(i, dato);
        }
        Alerts.print("Vector Lleno.... ");
        mostrarVector(original);

        int opcion;

        do {
            opcion = menu();
            MetodosOrdenamiento copia;
            switch (opcion) {
                case 1:
                    copia = new MetodosOrdenamiento();
                    copia.copiar(original.getVector());
                    copia.ordenarBurbuja();
                    Alerts.print("desordenado");
                    mostrarVector(original);
                    Alerts.print("Ordenado");
                    mostrarVector(copia);
                    break;
                case 2:
                    copia = new MetodosOrdenamiento();
                    copia.copiar(original.getVector());
                    copia.ordenarIntercambio();
                    Alerts.print("desordenado");
                    mostrarVector(original);
                    Alerts.print("Ordenado");
                    mostrarVector(copia);
                    break;
                case 3:
                    copia = new MetodosOrdenamiento();
                    copia.copiar(original.getVector());
                    copia.ordenarSeleccion();
                    Alerts.print("desordenado");
                    mostrarVector(original);
                    Alerts.print("Ordenado");
                    mostrarVector(copia);
                    break;
                case 4:
                    copia = new MetodosOrdenamiento();
                    copia.copiar(original.getVector());
                    copia.shell();
                    Alerts.print("desordenado");
                    mostrarVector(original);
                    Alerts.print("Ordenado");
                    mostrarVector(copia);
                    break;
                case 5:
                    copia = new MetodosOrdenamiento();
                    copia.copiar(original.getVector());
                    copia.quickSort(0, numeroElementos - 1);
                    Alerts.print("desordenado");
                    mostrarVector(original);
                    Alerts.print("Ordenado");
                    mostrarVector(copia);
                    break;
                case 6:
                    Alerts.print("Gracias");
                    break;

                default:
                    Alerts.print("¡No selecciono una opción válida entre 1 y 5!");
                    break;
            }

        } while (opcion != 6);
    }
}
