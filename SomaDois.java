import java.util.Arrays;

class SomaDois {
    
    public static void main (String[] args){

        int[] vetor = {1, 13, 0, 4, 5};
        int target = 5;

        System.out.println(Arrays.toString(somaDois(vetor, target)));
    }

    public static int[] somaDois(int[] v, int target){

        int[] saida = new int[2];

        for (int i = 0; i < v.length - 1; i++){
            for (int j = i + 1; j < v.length; j++){
                if (v[i] + v[j] == target){
                    saida[0] = v[i];
                    saida[1] = v[j];
                    return saida;
                }
            }
        }
        return new int[0];
    }
}
