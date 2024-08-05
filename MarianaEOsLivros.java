import java.util.*;

class MarianaEOsLivros {
    
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] livros = sc.nextLine().split((","));
        
        StringComparator comparator = new DefaultStringComparator();
        
        insertionSort(livros, comparator);

        sc.close();
    }

    public static void insertionSort(String[] v, StringComparator comparator){
        int n = v.length; //tamanho do array

        System.out.println(formataArray(v)); //imprime o estado inicial

        for (int i = 0; i < n; i++){
            int j = i;
            while (j > 0 && comparator.compare(v[j], v[j-1]) < 0){
                swap(v, j, j-1);
                j--;
            }

            System.out.println(formataArray(v));
        }
    }

    public static void swap(String[] v, int i, int j){
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static String formataArray(String[] v){
        return String.join(", ", v);
    }
}
