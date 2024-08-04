public class SelectionSort {
    
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indexMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indexMenor]) {
                    indexMenor = j;
                }
            }
            swap(array, i, indexMenor);
        }
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        selectionSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
