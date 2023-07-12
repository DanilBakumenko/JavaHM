import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class HM04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer a = input.nextInt();
        Integer b = input.nextInt();
        Deque<Integer> d = IntegerToDeque(a);
        Deque<Integer> q = IntegerToDeque(b);
        // sum(d, q);
        prod(d, q);
        input.close();
    }

    public static Deque<Integer> IntegerToDeque(Integer num) {
        Deque<Integer> firstDeq = new LinkedList<>();
            while (num != 0) {
                firstDeq.add(num % 10);
                num = num / 10;
            }
        System.out.println(firstDeq);
        return firstDeq;
    }
    
    public static void sum(Deque<Integer> first, Deque<Integer> second) {
        LinkedList<Integer> res = new LinkedList<>();
        int sm = 0;
        Integer NumbDigitf = 1; 
        Integer NumbDigits = 1; 
        int sizef = first.size();
        int sizes = second.size();
        if (sizef > sizes){
            for (int i = 0; i < sizef-sizes; i++) second.addLast(0);}

        else if(sizef < sizes){
            for (int i = 0; i < sizes-sizef; i++) first.addLast(0);
            }

        for (Integer item1 : first) {
            for (Integer item2 : second) {
                sm += item1*NumbDigitf + item2*NumbDigits;
                break;
            }
            NumbDigitf *= 10; 
            NumbDigits *= 10; 
            second.removeFirst();
        }

        while(sm > 0) {
            res.add(sm % 10);
            sm = sm / 10;
        }
        System.out.println(res);
    }

    public static void prod(Deque<Integer> first, Deque<Integer> second) {
        LinkedList<Integer> res = new LinkedList<>();
        Integer NumbDigitf = 1;  
        Integer product = 0;

        for (Integer item1 : first) {
            Integer NumbDigits = 1;
            for (Integer item2 : second) {
                product += item1 * NumbDigitf * item2 * NumbDigits;
                NumbDigits *= 10;
            }
            NumbDigitf *= 10;
        }

        while(product > 0) {
            res.add(product % 10);
            product = product / 10;
        }
        System.out.println(res);
    }
}
