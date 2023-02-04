// Пусть дан произвольный список целых чисел
// Нужно удалить из него четные числа
// Найти минимальное значение
// Найти максимальное значение
// Найти среднее значение

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class task_0 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println(list);
        System.out.printf("Минимальное число в массиве - %d, максимальное - %d, среднее арефмитическое - %d",
                getMin(list), getMax(list), getAverage(list));
        System.out.println();
        list = removeEvenValue(list);
        System.out.println(list);
        System.out.printf("Минимальное число в массиве - %d, максимальное - %d, среднее арефмитическое - %d",
                getMin(list), getMax(list), getAverage(list));

    }

    public static List<Integer> removeEvenValue(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                newList.add(integer);
            }
        }

        return newList;

    }

    public static Integer getMin(List<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static Integer getMax(List<Integer> list) {
        int max = (getMin(list));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static Integer getAverage(List<Integer> list) {
        Iterator<Integer> tmp = list.iterator();
        int sum = 0;
        while (tmp.hasNext()) {
            sum += tmp.next();

        }
        int average = sum / list.size();
        return average;
    }
}