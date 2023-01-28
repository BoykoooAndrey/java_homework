import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


//Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
//Требуется перехватить все возможные ошибки и вывести их в логгер.
//После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате


public class task_0 {
    public static void main(String[] args) throws SecurityException, IOException {

        byte num = 0;
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Введите число: ");
            num = scn.nextByte();
            scn.close();
            writeInFile(num);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            String info = e.getMessage() + " in scan!";
            log(info);
        }

        
    }
    
    public static void writeInFile(byte arg) throws SecurityException, IOException{
        String pathProject = System.getProperty(("user.dir"), null);
        String pathFile = pathProject.concat("/result.txt");
        try (FileWriter f1 = new FileWriter(pathFile, true);){
            f1.write(arg );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            String info = e.getMessage() + " in writeInFile!";
            log(info);
        }   
    }
    
    public static void log(String err) throws SecurityException, IOException{
        Logger logger = Logger.getLogger(task_0.class.getName());
        FileHandler fh = new FileHandler("log.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.info(err);
        fh.close();
    }
}
