class ContemElemento {
    
    public static void main (String[] args){
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(contem(array, 3, 0));
        System.out.println(contem(array, 6, 0));
    }

    public static boolean contem(int[] array, int n, int index){
        if (index == array.length){
            return false;
        }
        if (array[index] == n){
            return true;
        }
        return contem(array, n, index + 1);
    }
}
