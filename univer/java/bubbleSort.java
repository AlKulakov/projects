public class bubbleSort {
    public static void main(String[] args){
        int arr[] = {123, 1232, 23, 654, 23, 923, 45, 1, 86};
        int tmp, count = 0;
        boolean sorting = false;
        while(!sorting) {
            sorting = true;
            for(int i = 1; i < arr.length; i++){
                if(arr[i] < arr[i-1]){
                    tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    sorting = false;
                    count++;
                }
            }
        }
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
            System.out.println("Итерации:" + count);

    }
}
