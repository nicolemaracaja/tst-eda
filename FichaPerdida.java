import java.util.Arrays;

public class FichaPerdida {
    
    public static void main (String[] args){

        int[] fichas = {5, 2, 8, 1, 7, 3, 4}; //ficha da pessoa é a 5
        posicionaOrdenado(fichas);

        System.out.println(Arrays.toString(fichas));

    }

    public static int posicionaOrdenado(int[] v){
        int pivot = v[0];
        int i = 0;

        for (int j = i + 1; j < v.length; j++){
            if (v[j] < pivot){
                i++;
                swap(v, i, j);
            }
        }
        swap(v, 0, i);
        return i;
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
