public class InsertionSort {
    
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        insertionSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
    
    public static void insertionSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int j = i;
            while (j > 0 && array[j] < array[j-1]){
                swap(array, j-1, j);
                j--;
            }
        }
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
