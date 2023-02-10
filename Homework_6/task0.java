import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2) Создать коллекцию ноутбуков.
// 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
//      ноутбуки, отвечающие фильтру.
//      Пример: ОЗУ - Значение, Объем ЖД - Значение, Операционная система - Значение, Цвет - Значение
// 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class task0 {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus", "TUF A15",
                "Intel", "Nvidia 1660", "16", "512", "Black", "1000", 644656);
        Notebook notebook2 = new Notebook("Asus", "TUF A16",
                "Intel", "Nvidia 3060", "16", "1024", "Black", "1500", 644656);
        Notebook notebook3 = new Notebook("Asus", "TUF A17",
                "Intel", "Nvidia 3090", "32", "1024", "Black", "2000", 644656);
        Notebook notebook4 = new Notebook("MSI", "GF66",
                "Intel", "Nvidia 3070", "32", "512", "Black", "1700", 644656);
        Notebook notebook5 = new Notebook("MSI", "GF78",
                "AMD", "Nvidia 3090", "16", "1024", "Black", "1650", 644656);

        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);


        
        Map<String, String> params = requestParams();
        List<Notebook> filteredNotebooks =filter(params,notebooks);
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public static Map<String, String> requestParams() {
        Map<String, String> params = new HashMap<>();
        Scanner scn = new Scanner(System.in);
        Integer filter = null;
        String[] filters = { "Производитель", "Процессор", "Графический процессор", "Оперативная память",
                "Объем накопителя", "Цена" };        
        System.out.println("Выберите фильтр:");
        for (int i = 0; i < filters.length; i++) {
            System.out.printf("%d - %s", i+1, filters[i]);
            System.out.println();
        }
        System.out.printf("--->");
        
        try {
            filter = scn.nextInt();
            if (!(filter > 0 && filter <= filters.length)) {
                throw new numberException("Invalid number");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if (filter == 1) {
            params.put(filters[filter-1], getParam(Notebook.manufacturers));
        }
        if (filter == 2) {
            params.put(filters[filter-1], getParam(Notebook.CPUs));
        }
        if (filter == 3) {
            params.put(filters[filter-1], getParam(Notebook.GPUs));
        }
        if (filter == 4) {
            params.put(filters[filter-1], getParam(Notebook.accessMemorys));
        }
        if (filter == 5) {
            params.put(filters[filter-1], getParam(Notebook.memorys)); 
        }
        if (filter == 6) {
            params.put(filters[filter-1], getParam(Notebook.prices)); 
        }
        
        return params;

    }
    
    public static String getParam(Set <String> set){
        String[] arr = set.toArray(new String[set.size()]);
        Scanner scn = new Scanner(System.in);
        Integer param;
        System.out.println("Выберите параметр:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d - %s\n", i+1, arr[i]);
        }
        System.out.printf("--->");
        try {
            param = scn.nextInt();

            if (param > 0 && param <= arr.length) {
                return arr[param-1];
            } else {
                throw new numberException("Invalid number");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public static List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks) {
        List<Notebook> filteredNotebooks = new ArrayList<>();
        if (params.containsKey("Производитель")) {
            for (Notebook notebook : notebooks) {               
                if (notebook.manufacturer == params.get("Производитель")) {
                    filteredNotebooks.add(notebook);
                }
            }
        }
        if (params.containsKey("Процессор")) {
            for (Notebook notebook : notebooks) {               
                if (notebook.CPU == params.get("Процессор")) {
                    filteredNotebooks.add(notebook);
                }
            }
        }
        if (params.containsKey("Графический процессор")) {
            for (Notebook notebook : notebooks) {               
                if (notebook.GPU == params.get("Графический процессор")) {
                    filteredNotebooks.add(notebook);
                }
            }
        }
        if (params.containsKey("Оперативная память")) {
            for (Notebook notebook : notebooks) {               
                if (notebook.accessMemory == params.get("Оперативная память")) {
                    filteredNotebooks.add(notebook);
                }
            }
        }
        if (params.containsKey("Объем накопителя")) {
            for (Notebook notebook : notebooks) {               
                if (notebook.memory == params.get("Объем накопителя")) {
                    filteredNotebooks.add(notebook);
                }
            }
        }
        if (params.containsKey("Цена")) {
            for (Notebook notebook : notebooks) {               
                if (notebook.price == params.get("Цена")) {
                    filteredNotebooks.add(notebook);
                }
            }
        }
        return filteredNotebooks;
    }
}