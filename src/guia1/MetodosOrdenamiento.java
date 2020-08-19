package guia1;

/**
 *
 * @author Dair Salas
 */
public class MetodosOrdenamiento {

    private int vectorDatos[];
    private int numElementos;

    public MetodosOrdenamiento() {
        vectorDatos = null;
        numElementos = 0;
    }

    public void crearVector() {
        vectorDatos = new int[numElementos];
    }

    public void setVectorDatos(int p, int dato) {
        vectorDatos[p] = dato;
    }

    public int[] getVector() {
        return vectorDatos;
    }

    public int getVectorDatos(int p) {
        return vectorDatos[p];
    }

    public void setNumElementos(int num) {
        numElementos = num;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void copiar(int v[]) {
        numElementos = v.length;
        crearVector();
        for (int i = 0; i < v.length; i++) {
            setVectorDatos(i, v[i]);
        }
    }

    public void cambiar(int p1, int p2) {
        int temp;
        temp = getVectorDatos(p1);
        setVectorDatos(p1, getVectorDatos(p2));
        setVectorDatos(p2, temp);
    }

    public void ordenarBurbuja() {

        int i, j;
        for (i = 0; i < getNumElementos(); i++) {
            for (j = 0; j < (getNumElementos() - i) - 1; j++) {
                if (getVectorDatos(j) > getVectorDatos(j + 1)) {
                    cambiar(j, j + 1);
                }
            }
        }
    }

    public void ordenarIntercambio() {

        int i, j;
        for (i = 0; i < getNumElementos(); i++) {
            for (j = i + 1; j < getNumElementos(); j++) {
                if (getVectorDatos(i) > getVectorDatos(j)) {
                    cambiar(i, j);
                }
            }
        }
    }

    public int posicionMenor(int inicio) {
        int i;
        int posMenor;
        int menorElemento;
        posMenor = inicio;

        menorElemento = getVectorDatos(inicio);
        for (i = inicio + 1; i < getNumElementos(); i++) {

            if (getVectorDatos(i) < menorElemento) {
                menorElemento = getVectorDatos(i);
                posMenor = i;
            }
        }
        return posMenor;
    }

    public void ordenarSeleccion() {
        for (int i = 0; i < getNumElementos(); i++) {
            cambiar(i, posicionMenor(i));
        }
    }

    public void shell() {
        int salto;
        boolean cambios;
        for (salto = getNumElementos() / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = salto; i < getNumElementos(); i++) {
                    if (getVectorDatos(i - salto) > getVectorDatos(i)) {
                        cambiar(i, i - salto);
                        cambios = true;
                    }
                }
            }
        }
    }

    public void quickSort(int izq, int der) {
        int pivote = getVectorDatos(izq);
        int i = izq;
        int j = der;

        while (i < j) {
            while (getVectorDatos(i) <= pivote && i < j) {
                i++;
            }
            while (getVectorDatos(j) > pivote) {
                j--;
            }
            if (i < j) {
                cambiar(i, j);
            }
        }

        setVectorDatos(izq, getVectorDatos(j));
        setVectorDatos(j, pivote);
        if (izq < j - 1) {
            quickSort(izq, j - 1);
        }
        if (j + 1 < der) {
            quickSort(j + 1, der);
        }
    }

}
