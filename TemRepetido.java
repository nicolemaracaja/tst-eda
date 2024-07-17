import java.util.Arrays;

public class TemRepetido {
    
    public static void main (String[] args){

        int[] arr1 = {1, 13, 3, 4, 5, 1};
        int[] arr2 = {1, 13, 3, 4, 5, 2};

        System.out.println(temRepetido(arr1));
        System.out.println(temRepetido(arr2));
    }

    public static boolean temRepetido(int[] array){
        
        Arrays.sort(array); //metodo in-place

        for (int i = 1; i < array.length; i++){
            if (array[i] == array[i-1]){
                return true;
            }
        }    
        return false;
    }
}
