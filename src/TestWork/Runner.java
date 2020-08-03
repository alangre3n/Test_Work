package TestWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args){
        ArrayList<Integer> arrayMain = new ArrayList<>(); // Список Main хранит все введенные числа
        ArrayList<Integer> arrayX = new ArrayList<>(); // Список X
        ArrayList<Integer> arrayS = new ArrayList<>(); // Список S
        ArrayList<Integer> arrayM = new ArrayList<>(); // Список M

        boolean exit = false; // Кнопка выхода

        String command; // Команды
        int arrayMainLength = Utils.fillArray(arrayMain, args); // Количество элементов списка Main
        Counter result = Utils.initArrays(arrayMain, arrayX, arrayS, arrayM, arrayMainLength);
        int arrayXLength = result.getX(); // Длина списка X
        int arraySLength = result.getS(); // Длина списка S
        int arrayMLength = result.getM(); // Длина списка M

        Utils.print(arrayX, arrayS, arrayM, arrayXLength, arraySLength,  arrayMLength);

        while(!exit) {
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            switch (command) {
                case ("initArray"):
                    if(arrayXLength==0 && arraySLength==0 && arrayMLength==0){
                        result = Utils.initArrays(arrayMain, arrayX, arrayS, arrayM, arrayMainLength); //
                        arrayXLength = result.getX();
                        arraySLength = result.getS();
                        arrayMLength = result.getM();
                    }else {
                        if (arrayXLength == 0)
                            arrayXLength = Utils.initArray(arrayMain, arrayX, arrayMainLength, 3);
                        if (arraySLength == 0)
                            arraySLength = Utils.initArray(arrayMain, arrayS, arrayMainLength, 7);
                        if (arrayMLength == 0)
                            arrayMLength = Utils.initArray(arrayMain, arrayM, arrayMainLength, 21);
                    }
                    break;
                case ("print"):
                    Utils.print(arrayX, arrayS, arrayM, arrayXLength, arraySLength,  arrayMLength);
                    break;
                case ("print X"):
                    if(arrayXLength>0) {
                        System.out.println("Список X: ");
                        Utils.printType(arrayX, arrayXLength);
                    }else
                        System.out.println("Список X пуст");
                    break;
                case ("print S"):
                    if(arraySLength>0) {
                        System.out.println("Список S: ");
                        Utils.printType(arrayS, arraySLength);
                    }else
                        System.out.println("Список S пуст");
                    break;
                case ("print M"):
                    if(arrayMLength>0) {
                        System.out.println("Список M: ");
                        Utils.printType(arrayM, arrayMLength);
                    }else
                        System.out.println("Список M пуст");
                    break;
                case ("anyMore"):
                    System.out.println(Utils.anyMore(arrayMain, arrayMainLength, arrayXLength, arraySLength, arrayMLength));
                    break;
                case ("clear X"):
                    arrayX.clear();
                    arrayXLength=0;
                    break;
                case ("clear S"):
                    arrayS.clear();
                    arraySLength=0;
                    break;
                case ("clear M"):
                    arrayM.clear();
                    arrayMLength=0;
                    break;
                case ("merge"):
                    if(arrayXLength==0 && arraySLength==0 && arrayMLength==0) {
                        System.out.println("Все списки пусты");
                    }else{
                        Utils.merge(arrayX, arrayS, arrayM, arraySLength, arrayMLength);
                        Utils.printType(arrayX, arrayXLength + arraySLength + arrayMLength);
                        arrayX.clear();
                        arrayS.clear();
                        arrayM.clear();
                        arrayXLength = 0;
                        arraySLength = 0;
                        arrayMLength = 0;
                    }
                    break;
                case ("help"):
                    Utils.help();
                    break;
                case ("exit"):
                    exit=true;
                    break;
                default:
                    System.out.println("Команда введена неверно, для просмотра списка комманд введите - help");
                    break;
            }
        }
    }
}
