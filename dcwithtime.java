public class dcwithtime {
    public static void main(String[] args) {
        int[] list = new int[1000];
        for(int i = 0; i!=1000; i++){
            list[i] = 1000-i;
        }
        

        
        int[] list2 = list;
        long startTime = System.nanoTime();
        list = ordnormal(list);
        for(int i = 0; i!=list.length; i++){
            System.out.print(list[i]);
            System.out.print(" ");

        }
        System.out.println();
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        double executionTimeInMilliseconds = executionTime / 1_000_000.0;

        System.out.println("Execution time: " + executionTimeInMilliseconds + " ms");
        long startTime2 = System.nanoTime();
        mergeSort(list2);
        for(int i = 0; i!=list2.length; i++){
            System.out.print(list2[i]);
            System.out.print(" ");

        }
        System.out.println();
        long endTime2 = System.nanoTime();
        long executionTime2 = endTime2 - startTime2;
        double executionTimeInMillisecond2s = executionTime2 / 1_000_000.0;

        System.out.println("Execution time: " + executionTimeInMillisecond2s + " ms");
    }
    //// complexidade linear
    static int[] ordnormal(int[] list){
        for(int i = 0; i!= list.length; i++){
            for(int k = i; k!=list.length; k++){
                if(list[i]>list[k]){
                    int a = list[i];
                    list[i] = list[k];
                    list[k] = a;
                }
            }
        }
        return list;
    }
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Array is already sorted
        }
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return; // Base case: array contains only one element
        }
        int mid = (left + right) / 2;
        mergeSort(array, temp, left, mid); // Sort left half
        mergeSort(array, temp, mid + 1, right); // Sort right half
        merge(array, temp, left, mid, right); // Merge two sorted halves
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        // Copy elements to temporary array
        System.arraycopy(array, left, temp, left, right - left + 1);

        int i = left; // Pointer for left half
        int j = mid + 1; // Pointer for right half
        int k = left; // Pointer for merged array

        // Merge two sorted halves into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left half, if any
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }

}