public class Palindromo {
    
    public static void main (String[] args){

        String[] arr1 = {"a", "n", "a"};
        String[] arr2 = {"c", "a", "s", "a"};

        System.out.println(ehPalindromo(arr1));
        System.out.println(ehPalindromo(arr2));
    }

    public static boolean ehPalindromo(String[] v){
        
        int esquerda = 0;
        int direita = v.length - 1;

        while (esquerda < direita){
            if (v[esquerda] != v[direita]){
                return false;
            }
            esquerda++;
            direita--;
        }       
        return true;
    }
}
