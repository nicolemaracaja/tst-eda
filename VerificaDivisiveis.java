public class VerificaDivisiveis {
    
    public static void main (String[] args){

        int[] arr1 = {5, 13, 3, 4, 8};
        int[] arr2 = {5, 13, 3, 4, 7};

        System.out.println(VerificaDivisiveis(arr1));
        System.out.println(VerificaDivisiveis(arr2));
    }

    public static boolean VerificaDivisiveis(int[] v){

        for (int i = 0; i < v.length; i++){
            for (int j = i + 1; j < v.length; j++){
                if (v[i] % v[j] == 0 || v[j] % v[i] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
