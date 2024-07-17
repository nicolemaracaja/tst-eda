public class EhPrimo {
    
    public static void main (String[] args){

        System.out.println(ehPrimo(3));
        System.out.println(ehPrimo(15));
    }

    public static boolean ehPrimo(int num){
        
        for (int i = 1; i < num; i++){
            if (num % i == 0 && num != i && i != 1){
                return false;
            }
        }
        return true;
    }
}
