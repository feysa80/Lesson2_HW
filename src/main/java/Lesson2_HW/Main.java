package Lesson2_HW;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

//Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение)
public class Main {
    public static void main(String[] args) {
        String task1 = "Задача 1: Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение)";
        String task2 = "Задача 2: Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.";
        System.out.print("Выберите номер задачи: ");
        int task = taskNumber();
        switch (task){
            case (1):
                boolean result = Task1();
                System.out.println(result);
                break;
            case (2):
                String str = WordRepeat("TEST", 100);
                WriteToFile(str);
                break;
        }

    }
    public static boolean Task1(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String data = scan.nextLine();
        boolean result = true;
        int indexBegin = 0;
        int indexEnd = data.length() - 1;
        while (indexEnd > indexBegin && result == true){
            result = (data.charAt(indexBegin) == data.charAt(indexEnd)) ? true: false;
            indexBegin ++;
            indexEnd --;
        }
        return result;
    }
    public static String WordRepeat(String word, int count){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++){
            result.append(word);
            result.append(" ");
        }
        return result.toString();

    }
    public static void WriteToFile(String str)  {
        try(PrintWriter pw = new PrintWriter("src/main/resources/lib/task2.txt")) {
            pw.print(str);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static int taskNumber() {
        Scanner scan = new Scanner(System.in);
        int result = 0;
        try {
           int task = scan.nextInt();
            if (task <= 0 || task > 2) {
                System.out.println("Вы неправильно ввели номер задачи, введите число от 1 до 3");
                task = taskNumber();
            }
            result = task;

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода");
        }
        return result;
    }
}
