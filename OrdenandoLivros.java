import java.util.Arrays;

public class OrdenandoLivros {
    
    public static void main (String[] args){

        String[] livrosAlice = {"Alice no País das Maravilhas", "Moby Dick", "O Morro dos Ventos Uivantes", "Orgulho e Preconceito"}; // Ordem crescente
        String[] livrosPedro = {"O Grande Gatsby", "O Apanhador no Campo de Centeio", "Guerra e Paz", "Admirável Mundo Novo", "1984"}; // Ordem decrescente

        String[] livrosUnidos = merge(livrosAlice, livrosPedro);
        System.out.println(Arrays.toString(livrosUnidos));
    }

    public static String[] merge(String[] a1, String[] a2){
        String[] saida = new String[a1.length + a2.length];

        int i = 0; //indice do array 1
        int j = a2.length - 1; //indice do array 2

        int k = 0;

        while (i < a1.length && j >= 0){
            if (a1[i].compareTo(a2[j]) <= 0){ //se a1[i] for menor que a2[j]
                saida[k++] = a1[i++];
            }else{                            //se a2[j] for menor que a1[i]
                saida[k++] = a2[j--];
            }
        }

        while (i < a1.length){
            saida[k++] = a1[i++];
        }
        while (j >= 0){
            saida[k++] = a2[j--];
        }

        return saida;
    }
}
