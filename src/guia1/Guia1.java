/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Guia1 {

    //Se crea un método estático que permita mostrar los elementos del vector, dentro del método
    //estático main.
    public static void mostrarVector(MetodosOrdenamiento ordenar) {
        String datosVector = ""; //Se declara una variable de tipo cadena para almacenar los datos.
        //En el siguiente ciclo se recorre el vector y se van almacenando los elementos en la variable
        //anterior (datosVector).
        for (int i = 0; i <= ordenar.getNumElementos() - 1; i++) {
            datosVector = datosVector + String.valueOf("Posicion " + i + ": " + ordenar.getVectorDatos(i) + "\n");
        }
        //Después de tener almacenados todos los datos del vector, en la variable de tipo cadena
        //(datosVector), se procede a visualizar los elementos con la ayuda de JOptionPane y el método
        //showMessageDialog.
        JOptionPane.showMessageDialog(null, "============ ELEMENTOS DEL VECTOR============" + "\n" + datosVector);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Se crea un objeto de la clase MetodosOrdenamiento llamado ordenar para acceder a los
        //métodos púbicos implementados en la clase.
        MetodosOrdenamiento ordenar = new MetodosOrdenamiento();
        //Las variables para capturar el número de elementos, controlar el ciclo for y capturar los datos del
        //vector, son: numeroElementos, i y dato, respectivamente.
        //Se captura en un showInputDialog el número entero correspondiente a la cantidad de elementos
        //del vector. Como el dato que se captura está en un tipo de dato String, se debe pasar a un tipo de
        //dato entero con la ayuda de Integer.parseInt.
        int numeroElementos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Número de Elementos del Vector:"));
        //Se pasa el dato capturado al respectivo método modificador.
        ordenar.setNumElementos(numeroElementos);
        //Se llama al método que crea el vector en tiempo de ejecución.
        ordenar.crearVector();

        for (int i = 0; i <= ordenar.getNumElementos() - 1; i++) {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Digitar Elemento de la Posición" + i + ": "));
            ordenar.setVectorDatos(i, dato);
        }
        JOptionPane.showMessageDialog(null, "Vector Lleno.... ");
        mostrarVector(ordenar); //Se llama al método para visualizar los elementos del vector.

        //Se implementa un menú de opciones para escoger con que método se quiere ordenar el vector.
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("====== Seleccione el Método de Ordenamiento == == == \n" + "1. Ordenamiento Burbuja \n" + "2. Ordenamiento por Intercambio \n" + "3. Ordenamiento por Seleccion \n4. Ordenamiento shell \n5. Ordenamiento quick sort"));
        switch (opcion) {
            case 1:
                ordenar.ordenarBurbuja();
                mostrarVector(ordenar);
                break;
            case 2:
                ordenar.ordenarIntercambio();
                mostrarVector(ordenar);
                break;
            case 3:
                ordenar.ordenarSeleccion();
                mostrarVector(ordenar);
                break;
            case 4:
                ordenar.shell();
                mostrarVector(ordenar);
                break;
            case 5:
                ordenar.quickSort(0, numeroElementos-1);
                mostrarVector(ordenar);
                break;

            default:
                JOptionPane.showMessageDialog(null, "¡No selecciono una opción válida entre 1 y 3!");
                break;
        }
    }
}
