public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] b = new int[] {0, 2, 2, 5};
        int[] a = new int[] {1, 3, 5};

        for (int x : mergeArrays(a, b)){
            System.out.print(x + " ");
        }
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] ans = new int[a1.length + a2.length];

        int i=0, j=0, k=0;

        while (i < a1.length && j < a2.length){
            ans[k++] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }

        if (i < a1.length){
            for (int index = k; index < ans.length; index++){
                ans[index] = a1[index - a2.length];
            }
        } else {
            for (int index = k; index < ans.length; index++){
                ans[index] = a2[index - a1.length];
            }
        }

        return ans;
    }
}
