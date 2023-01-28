import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

// Напишите программу, которая
// 1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла
// 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
// 3) сохраняет файл локально
// 4) читает сохраненный файл и выводит содержимое в логгер
// 5) удаляет сохраненный файл

public class task_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        URL webSiteURL = new URL(
                "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt");
        String fileName = "/oath.txt";
        String name = "Андрей";
        download(webSiteURL, fileName, name);
        read(fileName);
        removeFromLocale(fileName);
    }

    public static void download(URL webSiteURL,String fileName, String name) {
        InputStream input = null;
        String fileContent = null;
        try {
            input = webSiteURL.openStream();
            byte[] buffer = input.readAllBytes();
            fileContent = new String(buffer, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        fileContent = change(name, fileContent);
        saveOnLocal(fileName, fileContent);
    }

    public static void saveOnLocal(String fileName, String fileContent){
        String pathProject = System.getProperty(("user.dir"), null);
        String pathFile = pathProject.concat("/oath.txt");
        try (FileWriter writer = new FileWriter(new File(pathFile), StandardCharsets.UTF_8)){
            writer.write(fileContent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String change(String name, String fileContent){
        for (int i = 0; i < fileContent.length() - 1; i++) {
            if ((fileContent.charAt(i) == '%') & (fileContent.charAt(i+1) == 's')) {
                fileContent = fileContent.substring(0, i) + name;
            }
        }
        return fileContent;
    }

    public static void read(String fileName){
        String localFileName = fileName.substring(1);
        try (FileReader reader = new FileReader(localFileName, StandardCharsets.UTF_8)){
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){
                 
                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeFromLocale(String fileName) throws InterruptedException {
        String localFileName = fileName.substring(1);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("Файл удалится через %d секунд \n", 10 - i);
            TimeUnit.SECONDS.sleep(1);
        }
        File file = new File(localFileName);
        if(file.delete()){
        }

    }
}
