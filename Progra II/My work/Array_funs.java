/**
 * Array_funs
 */
public class Array_funs {

    static boolean son_iguales(int[] arr1, int[] arr2){
        boolean value = true;
        for (int i = 0; i < arr2.length; i++) {
            if(arr1[i] != arr2[i])
            value = false;
        }
        return value;
    }

    static String tostring(int[] arr){
        String res = "<" + arr[0];
        for (int i = 1; i < arr.length; i++) {
            res += ", " + arr[i];
        }
        return res + ">";
    }

    static int longitud(int[] arr){
        int longitud = 0;
        boolean end = false;

        while (!end && longitud < arr.length) {
            if (arr[longitud] == -1) {
                end = true;
            }
            longitud++;
        }

        return longitud - 1;
    }

    public static void main(String[] args) {
        int test[] = {1, 2, 3, 4, -1, -1, -1};
        System.out.println(longitud(test));
    }
}