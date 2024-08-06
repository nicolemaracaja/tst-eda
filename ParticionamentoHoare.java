import java.util.Arrays;

public class ParticionamentoHoare {
    
    public static void main (String[] args){

        int[] arr = new int[]{7, 8, 1, 2, 90, 4, 65, 32};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] v, int ini, int fim){
        if (ini < fim){

            int indexPivot = partition(v, ini, fim);
            quickSort(v, ini, indexPivot);
            quickSort(v, indexPivot + 1, fim);
        }
    }

    public static int partition(int[] v, int ini, int fim){
        int pivot = v[ini];
        int i = ini + 1;
        int j = fim;

        while (i <= j){
            while(i <= j && v[i] <= pivot){
                i++;
            }
            while(i <= j && v[j] > pivot){
                j--;
            }
            if(i < j){
                swap(v, i, j);
            }
        }
        swap(v, ini, j);
        return j;
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
