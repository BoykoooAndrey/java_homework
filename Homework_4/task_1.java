//Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
// и каждый из их узлов содержит одну цифру.
// Умножьте два числа и верните произведение в виде связанного списка.
// Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class task_1 {
    public static void main(String[] args) {
        task_1 hw = new task_1();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }
    
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Integer resultInt = fromDequeInInt(d1) * fromDequeInInt(d2);
        ArrayDeque<Integer> resultArr = new ArrayDeque<Integer>();
        String resultStr = Integer.toString(resultInt);
        Integer len = resultStr.length();
        if (resultInt < 0){
            for (int i = 1; i < len; i++) {
                Integer negative_num = Integer.parseInt(String.valueOf(resultStr.charAt(len - i)));
                if (i == len -1) {
                    resultArr.add(negative_num - (2*negative_num));
                }
                else{
                    resultArr.add(negative_num);
                }
            }
        }
        else{
            for (int i = 1; i <= len; i++) {
                resultArr.add(Integer.parseInt(String.valueOf(resultStr.charAt(len - i))));
            }
        }
        return resultArr;
    }
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Integer resultInt = fromDequeInInt(d1) + fromDequeInInt(d2);
        ArrayDeque<Integer> resultArr = new ArrayDeque<Integer>();
        String resultStr = Integer.toString(resultInt);
        Integer len = resultStr.length();
        if (resultInt < 0){
            for (int i = 1; i < len; i++) {
                Integer num = Integer.parseInt(String.valueOf(resultStr.charAt(len - i)));
                if (i == len -1) {
                    resultArr.add(num - (2*num));
                }
                else{
                    resultArr.add(num);
                }
            }
        }
        else{
            for (int i = 1; i <= len; i++) {
                resultArr.add(Integer.parseInt(String.valueOf(resultStr.charAt(len - i))));
            }
        }
        return resultArr;
    }
    public static Integer fromDequeInInt(Deque<Integer> arr){
        
        String tmp = "";
        Integer len = arr.size();
        for (int i = 0; i < len; i++) {
            Integer strNum = arr.removeLast();
            tmp += strNum.toString();
        }
        Integer result = Integer.parseInt(tmp);
        return result;
    }
}
