package TestWork;

import java.util.ArrayList;
import java.util.Collections;


public class Utils {

    // Ввод через аргументы командной строки
    public static int fillArray(ArrayList<Integer> arrayMain, String[] commandLineArg){
        int i;
        int length = commandLineArg.length;
        for (i=0;i<length;i++){
            arrayMain.add(Integer.parseInt(commandLineArg[i]));
        }
        Collections.sort(arrayMain);
        return i;
    }

    // Функция инициализации заполнения списков
    public static Counter initArrays(ArrayList<Integer> arrayMain, ArrayList<Integer> arrayX, ArrayList<Integer> arrayS, ArrayList<Integer> arrayM, int arrayMainLength){
        int arrayXLength=0;
        int arraySLength=0;
        int arrayMLength=0;
        for(int i=0;i<arrayMainLength;i++){
            if(arrayMain.get(i) % 3 ==0) {
                arrayX.add(arrayMain.get(i));
                arrayXLength++;
            }
            if(arrayMain.get(i) % 7 ==0) {
                arrayS.add(arrayMain.get(i));
                arraySLength++;
            }if(arrayMain.get(i) % 21 ==0) {
                arrayM.add(arrayMain.get(i));
                arrayMLength++;
            }
        }
        return new Counter(arrayXLength,arraySLength,arrayMLength);
    }

    // Функция инициализации заполнения одного списка
    public static int initArray(ArrayList<Integer> arrayMain, ArrayList<Integer> array, int arrayMainLength, int mod){
        int arrayLength=0;
        for(int i=0;i<arrayMainLength;i++){
            if(arrayMain.get(i) % mod ==0) {
                array.add(arrayMain.get(i));
                arrayLength++;
            }
        }
        return arrayLength;
    }

    // Функция выводит все списки на экран
    public static void print(ArrayList<Integer> arrayX, ArrayList<Integer> arrayS, ArrayList<Integer> arrayM,
                             int arrayXLength, int arraySLength, int arrayMLength){
        if(arrayXLength>0) {
            System.out.println("Список X: ");
            Utils.printType(arrayX, arrayXLength);
        }else
            System.out.println("Список X пуст");
        if(arraySLength>0) {
            System.out.println("Список S: ");
            Utils.printType(arrayS, arraySLength);
        }else
            System.out.println("Список S пуст");
        if(arrayMLength>0) {
            System.out.println("Список M: ");
            Utils.printType(arrayM, arrayMLength);
        }else
            System.out.println("Список M пуст");
    }

    // Фнукция выводит список на экран
    public static void printType(ArrayList<Integer> array, int arrayLength){
        for(int i=0;i<arrayLength;i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    // Функция выводит на экран были ли значения не вошедшие ни в один список
    public static String anyMore(ArrayList<Integer> array, int arrayLength, int arrayXLength, int arraySLength, int arrayMLength) {
        if (arrayXLength == 0 && arraySLength == 0 && arrayMLength == 0) {
            return "true";
        } else {
            if (arrayXLength > 0 && arraySLength > 0) {
                for (int i = 0; i < arrayLength; i++) {
                    if (array.get(i) % 7 != 0 && array.get(i) % 3 != 0)
                        return "true";
                }
                return "false";
            }
            if (arrayXLength == 0 && arraySLength > 0) {
                for (int i = 0; i < arrayLength; i++) {
                    if (array.get(i) % 7 != 0)
                        return "true";
                }
                return "false";
            }
            if(arrayXLength>0 && arraySLength==0){
                for (int i = 0; i < arrayLength; i++) {
                    if (array.get(i) % 3 != 0)
                        return "true";
                }
                return "false";
            }
            if(arrayMLength>0 && arrayXLength==0 && arraySLength==0){
                for (int i = 0; i < arrayLength; i++) {
                    if (array.get(i) % 21 != 0)
                        return "true";
                }
                return "false";
            }
        }
        return null;
    }

    // функция собирает все значения списков в один и выводит на экран, затем очищает все списки
    public static void merge(ArrayList<Integer> arrayX, ArrayList<Integer> arrayS, ArrayList<Integer> arrayM, int arraySLength, int arrayMLength){
        if(arraySLength>0) {
            for (int i = 0; i < arraySLength; i++) {
                arrayX.add(arrayS.get(i));
            }
        }
        if(arrayMLength>0) {
            for (int i = 0; i < arrayMLength; i++) {
                arrayX.add(arrayM.get(i));
            }
        }
        Collections.sort(arrayX);
    }

    // Функция выводит описание комманд
    public static void help(){
        System.out.println("initArray - инициализирует списки набором значений array");
        System.out.println("print - выводит на экран все списки");
        System.out.println("print type - выводит на экран все списки, type принимает значения X,S,M");
        System.out.println("anyMore - выводит на экран были ли значения не вошедшие ни в один список");
        System.out.println("clear type - очищает список , type принимает значения X,S,M");
        System.out.println("merge - выводит на экран значения из всех списков и очищает их");
        System.out.println("help - выводит справку по командам");
        System.out.println("exit - выход");
    }
}
