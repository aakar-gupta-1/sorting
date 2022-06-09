public class myMergeSort {


    private static int arr[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(arr);
        mergesort(arr);
        print(arr);
    }

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }

    public static void mergesort(int[] arr){
        if(arr.length==1) return;

        int mid=arr.length/2+arr.length%2;
        int[] child1=new int[mid];
        int[] child2=new int[arr.length-mid];

        split(arr, child1, child2);

        mergesort(child1);
        mergesort(child2);

        merge(child1,child2,arr);
    }

    public static void split(int[] arr, int[] child1, int[] child2){
        int index=0;
        int index1=0;

        for(int i=0;i<arr.length;i++){
            if(index1<child1.length){
                child1[index1]=arr[index];
                index1++;
            }else {
                child2[index-index1]=arr[index];
            }
            index++;
        }
    }

    public static void merge(int[] arr1, int[] arr2, int[] parent){
        int index1=0,index2=0;
        int index=0;
        while(index1<arr1.length && index2<arr2.length){
            if(arr1[index1]<arr2[index2]) {
                parent[index]=arr1[index1];
                index1++;
            } else if(arr1[index1]>arr2[index2]) {
                parent[index]=arr2[index2];
                index2++;
            }
            index++;
        }

        for(int i=index1;i<arr1.length;i++){
            parent[index]=arr1[i];
            index++;
        }

        for(int i=index2;i<arr2.length;i++){
            parent[index]=arr2[i];
            index++;
        }
    }
    
}
