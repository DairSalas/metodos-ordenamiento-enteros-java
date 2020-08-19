/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia1;

/**
 *
 * @author pc
 */
public class MetodosOrdenamiento {
    //Se declaran los atributos de la clase, en este caso se declara el vector (vectorDatos).
    //y un atributo para asignar el número de elementos que tendrá el vector (numElementos).

    private int vectorDatos[];
    private int numElementos;
    //Posteriormente se implementa el método constructor de la clase para asignar los valores iniciales
    //de los atributos.

    public MetodosOrdenamiento() {
        vectorDatos = null;
        numElementos = 0;
    }
    //El siguiente método crea el vector en tiempo de ejecución, posteriormente se asignara su tamaño.

    public void crearVector() {
        vectorDatos = new int[numElementos];
    }
    //Implementación del método modificador para asignar los elementos en cada una de las
    //posiciones del vector.

    public void setVectorDatos(int p, int dato) {
        vectorDatos[p] = dato;
    }
    //Se implementa el método que permitirá obtener los elementos del vector.

    public int getVectorDatos(int p) {
        return vectorDatos[p];
    }
    //Implementación del método modificador para asignar el tamaño del vector.

    public void setNumElementos(int num) {
        numElementos = num;
    }
    //Método selector que permite obtener el tamaño o número de elementos que tiene el vector.

    public int getNumElementos() {
        return numElementos;
    }
    //Implementación del método que permite intercambiar los elementos de dos posiciones del vector.

    public void cambiar(int p1, int p2) {
        int temp;
        temp = getVectorDatos(p1);
        setVectorDatos(p1, getVectorDatos(p2));
        setVectorDatos(p2, temp);
    }
    //Implementación del método de ordenamiento Burbuja, este método compara elementos de la
    //posición j con la posición j+1, es decir compara dos posiciones seguidas o continuas del vector.

    public void ordenarBurbuja() {
        //Variables que controlan los ciclos que recorren el vector para comparar e intercambiar los
        //elementos.
        int i, j;
        for (i = 0; i <= getNumElementos() - 1; i++) {
            for (j = 0; j <= (getNumElementos() - i) - 2; j++) {
                //Ordeno de menor a mayor, si se quiere hacer de mayor a menor simplemente cambie el signo,
                //aquí se compara si el elemento de la izquierda (j) es mayor que el elemento contiguo de la
                //derecha (j+1). Si se cumple la condición los intercambia.
                if (getVectorDatos(j) > getVectorDatos(j + 1)) {
                    cambiar(j, j + 1);
                    //Para hacer el intercambio en los elementos se llama al método cambiar.
                }
            }
        }
    }
    //Implementación del método de ordenamiento por intercambio. Este método compara un elemento
    //de la posición i con todos los que le siguen, es decir con los de la posición i+1, i+2, i+3...

    public void ordenarIntercambio() {
        //Variables que controlan los ciclos que recorren el vector para comparar e intercambiar los
        //elementos (i y j).
        int i, j;
        for (i = 0; i <= getNumElementos() - 1; i++) {
            for (j = i + 1; j <= getNumElementos() - 1; j++) {
                //Ordeno de menor a mayor, si se quiere hacer de mayor a menor simplemente cambie el signo,
                //aquí compara si el elemento de la posición (i) a la izquierda es mayor que el elemento de la
                //posición (j) ubicado hacia la derecha.
                if (getVectorDatos(i) > getVectorDatos(j)) {
                    cambiar(i, j);
                }
            }
        }
    }
    //Implementación del método auxiliar para buscar la posición del elemento más pequeño del vector
    //y realizar el intercambio.

    public int posicionMenor(int inicio) {
        int i; //Variable que controla el ciclo que recorre el vector para obtener el elemento menor.
        int posMenor; //Variable para establecer la posición en el vector del elemento menor.
        int menorElemento; //Variable para representar el elemento menor del vector.
        posMenor = inicio;
        //A continuación se asume que el elemento más pequeño del vector está en la primera posición.
        menorElemento = getVectorDatos(inicio);
        for (i = inicio + 1; i <= getNumElementos() - 1; i++) {
            //Se compara si el elemento de la posición i es menor que el elemento menor.
            if (getVectorDatos(i) < menorElemento) {
                menorElemento = getVectorDatos(i);
                posMenor = i;
            }
        }
        //Se devuelve la posición en donde está el elemento menor del vector para realizar el intercambio
        //hacia la primera posición.
        return posMenor;
    }
    
    //Implementación del método que ordena el vector, llamando al método auxiliar posicionMenor para
    //realizar el intercambio.

    public void ordenarSeleccion() {
        for (int i = 0; i <= getNumElementos() - 1; i++) {
            cambiar(i, posicionMenor(i));
        }
    }
}
