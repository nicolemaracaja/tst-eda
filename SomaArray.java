class SomaArray {
    
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(somaArray(array, 0));
    }

    public static int somaArray(int[] array, int index){
        if (index == array.length){
            return 0;
        }
        return array[index] + somaArray(array, index + 1);
    }
}
