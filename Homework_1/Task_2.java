// Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
// Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.

public class Task_2 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i%j == 0) {
                    count++;
                }
            }
            if (count == 2) {
             System.out.println(i);   
            }
        }
    }


}
