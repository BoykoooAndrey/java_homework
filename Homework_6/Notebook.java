import java.util.HashSet;
import java.util.Set;

public class Notebook {
    String manufacturer;
    String model;
    String CPU;
    String GPU;
    String accessMemory;
    String memory;
    String color;
    String price;
    Integer IMEI;

    static Set <String> manufacturers = new HashSet<>();
    static Set <String> CPUs = new HashSet<>();
    static Set <String> GPUs = new HashSet<>();
    static Set <String> accessMemorys = new HashSet<>();
    static Set <String> memorys = new HashSet<>();
    static Set <String> prices = new HashSet<>();




    /**
     * Характеристики ноутбука
     * @param manufacturer производитель
     * @param model модель
     * @param CPU процессор
     * @param GPU графический процессор
     * @param accessMemory оперативная память
     * @param memory объем накопителя
     * @param color цвет
     * @param price цена
     * @param IMEI серийный номер
     */
    Notebook(String manufacturer, String model, String CPU, String GPU, String accessMemory, String memory,
            String color, String price, Integer IMEI) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.CPU = CPU;
        this.GPU = GPU;
        this.accessMemory = accessMemory;
        this.memory = memory;
        this.color = color;
        this.price = price;
        this.IMEI = IMEI;
        manufacturers.add(manufacturer);
        CPUs.add(CPU);
        GPUs.add(GPU);
        accessMemorys.add(accessMemory);
        memorys.add(memory);
        prices.add(price);

        

    }

    @Override
    public String toString() {
        return String.format(
                "Ноутбук %s %s \nПроцессор: %s;\nCPU: %s;\nGPU;\nОперативная память: %s гБ;\nПОбъем накопителя: %s;\nЦвет: %s;\nЦена: %s$; ",
                manufacturer, model, CPU, GPU, accessMemory, memory, color, price);
    }


}
