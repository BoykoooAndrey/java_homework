
//Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
//Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 300].

public class Task_0 {
    public static void main(String[] args) {
        int sizeArr = 10;
        int[] arr = new int[sizeArr];
        int minVal = 301;
        int maxVal = 0;
        float summ = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNum();
            System.out.println(arr[i]);
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
            if (minVal > arr[i]) {
                minVal = arr[i];
            }
            summ += arr[i];
        }
        float average = summ / sizeArr;
        System.out.printf("Минимальное значение: %d", minVal);
        System.out.println();
        System.out.printf("Максимальное значение: %d", maxVal);
        System.out.println();
        System.out.printf("Среднее арифметическое: %f",average);
    }

    public static int getRandomNum() {
        return (int) (Math.random() * 300);
    }
}
