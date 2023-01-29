import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

public class task_0 {
    public static void main(String[] args) {
        String a = "{[()]}";
        boolean result = validate(a, '(', ')') &
        validate(a, '{', '}') & 
        validate(a, '[', ']');
        System.out.println(result);
    }

    private static int sum(Deque<Integer> arr) {
        int sum = 0;
        for (int i = 0; i <= arr.size(); i++) {
            sum += arr.removeFirst();
        }
        return sum;
    }

    private static boolean validate(String str, char firstSymbol, char secondSymbol){
        Deque<Integer> openIndex = new ArrayDeque<>(Arrays.asList());
        Deque<Integer> closeIndex = new ArrayDeque<>(Arrays.asList());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == firstSymbol)
                openIndex.add(i);
            if (str.charAt(i) == secondSymbol)
                closeIndex.add(i);
        }
        if (openIndex.size() == 0 & closeIndex.size() == 0) {
            return true;
        }
        if (openIndex.size() == closeIndex.size()) {
            if (sum(openIndex) < sum(closeIndex)) {
                return true;
            }
        }
        return false;
    }
    
}