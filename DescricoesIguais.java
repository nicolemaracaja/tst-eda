import java.util.*;

public class DescricoesIguais {
    
    public static void main (String[] args){

        String[] a = new String[]{"8", "gb", "notebook"};
        String[] b = new String[]{"notebook", "8", "gb"};

        System.out.println(verificaIgualdade(a, b));

        String[] c = new String[]{"notebook", "8"};

        System.out.println(verificaIgualdade(a, c));
    }

    public static boolean verificaIgualdade(String[] l1, String[] l2){

        if (l1.length != l2.length){
            return false;
        }

        mergeSort(l1, 0, l1.length-1);
        System.out.println(Arrays.toString(l1));
        mergeSort(l2, 0, l2.length-1);
        System.out.println(Arrays.toString(l2));

        for (int i = 0; i < l1.length; i++){
            if (!l1[i].equals(l2[i])){
                return false;
            }
        }

        return true;
    }

    public static void mergeSort(String[] arr, int ini, int fim){

        if (ini >= fim){
            return;
        }else{
            int meio = (ini+fim)/2;
            mergeSort(arr, ini, meio);
            mergeSort(arr, meio+1, fim);

            merge(arr, ini, meio, fim);
        }
    }

    public static void merge(String[] arr, int ini, int meio, int fim){

        String[] aux = new String[arr.length];
        for (int i = ini; i < arr.length; i++){
            aux[i] = arr[i];
        }

        int i = ini;
        int j = meio + 1;

        int k = ini;

        while (i <= meio && j <= fim){
            if ((arr[i].compareTo(arr[j]) <= 0)){
                aux[k++] = arr[i++];
            }else{
                aux[k++] = arr[j++];
            }
        }

        while (i <= meio){
            aux[k++] = arr[i++];
        }

        for (int l = 0; l < aux.length; l++) { //copia os elementos ordenados de volta para o array original
            arr[ini + l] = aux[l];
        }
    }
}
