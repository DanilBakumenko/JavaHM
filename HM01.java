/**
 * HM01
 * 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 * 2) Вывести все простые числа от 1 до 1000
 * 3) Реализовать простой калькулятор
 * 4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class HM01 {
    static void SumToN (){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int n: ");
        int n = iScanner.nextInt();
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
        iScanner.close();
    }
    static void ProdToN (){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("int n: ");
        int n = iScanner.nextInt();
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println(sum);
        iScanner.close();
    }
    static void simpleNums(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(7);
        for (int i = 9; i < 1001; i += 2) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (i % list.get(j) != 0) {
                    count ++;
                }
                if (count == list.size()) {
                    list.add(i);
                }
            }
            
            }
        list.add(0,2);
        System.out.println(list);
        }
    static void calculator(){
        while (true) {
            System.out.println("1. A + B\n2. A - B\n3. A * B\n4. A / B\n5. Exit\nEnter action number:");
            Scanner iScanner = new Scanner(System.in);
            int n = iScanner.nextInt();
            System.out.println("Enter A:");
            int a = iScanner.nextInt();
            System.out.println("Enter B:");
            int b = iScanner.nextInt();
            if (n == 1){
                System.out.printf("A + B = %d\n",a+b);
                System.out.printf("Press any key, to return");
                iScanner.next();
            }
            else if (n == 2){
                System.out.printf("A - B = %d\n",a-b);
                System.out.printf("Press any key, to return");
                iScanner.next();
            }
            else if (n == 3){
                System.out.printf("A * B = %d\n",a*b);
                System.out.printf("Press any key, to return");
                iScanner.next();
            }
            else if (n == 4){
                System.out.printf("A / B = %d\n",a/b);
                System.out.printf("Press any key, to return");
                iScanner.next();
            }
            else{
                iScanner.close();
                break;
            } 
            
        }
    }

    public static void main(String[] args) {
        calculator();
    }


}