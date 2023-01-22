// Реализуйте алгоритм сортировки пузырьком для сортировки массива

public class Task_1 {
    public static void main(String[] args) {
        int sizeArr = 10;
        int[] arr = new int[sizeArr];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNum();
            System.out.print(arr[i] + "; ");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "; ");
        }
    }

    public static int getRandomNum() {
        return (int) (Math.random() * 11);
    }
}
