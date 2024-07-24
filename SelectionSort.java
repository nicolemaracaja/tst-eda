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
            int temp = array[indexMenor];
            array[indexMenor] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        selectionSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
