import java.util.*;

class MergeSortPassoAPasso {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] v = sc.nextLine().split(" ");

        int[] array = new int[v.length];
        
        for (int i = 0; i < v.length; i++) {
            array[i] = Integer.parseInt(v[i]);
        }
        mergeSort(array, 0, array.length - 1);

        sc.close();
    }

    public static void mergeSort(int[] array, int inicio, int fim) { //merge sort classico

        System.out.println(Arrays.toString(Arrays.copyOfRange(array, inicio, fim+1)));

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);

            merge(array, inicio, meio, fim);
        }
    }

    public static void merge(int[] array, int inicio, int meio, int fim) {

        int[] aux = new int[array.length];
        for (int i = inicio; i <= fim; i++){
            aux[i] = array[i];
        }

        int i = inicio;
        int j = meio + 1;

        int k = inicio;

        while (i <= meio && j <= fim) {
            if (aux[i] <= aux[j]) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
            }
        }

        while (i <= meio) {
            array[k++] = aux[i++];
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(array, inicio, fim+1)));
    }
}

