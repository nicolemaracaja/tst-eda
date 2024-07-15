import java.util.*;

class MoveImpostor {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        sc.close();
        
        int[] array = Arrays.stream(entrada).mapToInt(Integer::parseInt).toArray();

        encontraImpostor(array);

        System.out.println(Arrays.toString(array));
    }

    public static void encontraImpostor(int[] array) {
        if (array == null || array.length <= 1) {
            return; 
        }

        int impostorIndex = -1;
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                impostorIndex = i;
                break;
            }
        }

        //se n tiver impostor, já está ordenado
        if (impostorIndex == -1) return;

        //move o impostor para a posição correta
        int impostor = array[impostorIndex];
        int j = impostorIndex;
        while (j > 0 && array[j - 1] > impostor) {
            array[j] = array[j - 1];
            j--;
        }
        array[j] = impostor;
    }
}
