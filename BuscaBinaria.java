class BuscaBinaria {
  
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(buscaBinaria(array, 5, 0, array.length - 1)); // Exemplo de uso: 4
        System.out.println(buscaBinaria(array, 11, 0, array.length - 1)); // Exemplo de uso: -1
    }

    public static int buscaBinaria(int[] array, int n, int esquerda, int direita) {
        if (esquerda > direita) {
            return -1; //não encontrou o elemento
        }

        int meio = (esquerda + direita) / 2;

        if (array[meio] == n) {
            return meio; //encontrou o elemento
        } else if (array[meio] > n) {
            return buscaBinaria(array, n, esquerda, meio - 1);
        } else {
            return buscaBinaria(array, n, meio + 1, direita);
        }
    }
}
