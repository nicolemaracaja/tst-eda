import java.util.Scanner;

class MelhorPivot {
    
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        String[] v = sc.nextLine().split(" ");
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[v.length];
        
        for (int i = 0; i < v.length; i++) {
            array[i] = Integer.parseInt(v[i]);
        }

        int index1 = Integer.parseInt(entrada[0]);
        int index2 = Integer.parseInt(entrada[1]);

        if (calculaDesbalanceamento(array, index1) > calculaDesbalanceamento(array, index2)){
            System.out.println(index2);
        }else{
            System.out.println(index1);
        }

        sc.close();
    }

    public static int calculaDesbalanceamento(int[] v, int indexPivot){
        int pivot = v[indexPivot];
        int menores = 0;
        int maiores = 0;

        for (int i = 0; i < v.length; i++){
            if (i != indexPivot){
                if (v[i] > pivot){
                    maiores++;
                }else{
                    menores++;
                }
            }
        }

        return Math.abs(maiores - menores);
    }
}
