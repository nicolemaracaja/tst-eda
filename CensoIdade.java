public class CensoIdade {
    
    public static void main (String[] args){

        int[] idades = {5, 20, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
        int[] cumulativa = calculaCumulativa(idades);
        
        // Exemplo de consulta: quantas pessoas têm 20 anos ou menos
        int idadeConsulta = 20;
        
        if (idadeConsulta >= 0 && idadeConsulta <= 130) {
            System.out.println("Número de pessoas com idade menor ou igual a " + idadeConsulta + ": " + cumulativa[idadeConsulta]);
        } else {
            System.out.println("Idade fora do intervalo permitido.");
        }

    }

    public static int[] calculaCumulativa(int[] idades){

        int[] arr = new int[131];

        //frequencia
        for (int i = 0; i < idades.length; i++){
            arr[idades[i]]++;
        }

        for (int j = 1; j < arr.length; j++){
            arr[j] += arr[j-1];
        }

        return arr;
    }
}
