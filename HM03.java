import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * HM03
 *  Задание 1
    1.Пусть дан произвольный список целых чисел.
    1) Нужно удалить из него чётные числа
    2) Найти минимальное значение
    3) Найти максимальное значение
    4) Найти среднее значение

    Задание 2
    Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.
 */
public class HM03 {
    public static void main(String[] args) {
        Integer[] array = createRandomIntArray(15, 100);
        // printArray(array);
        // min(array);
        // max(array);
        // mean(array);
        List<String> planets = getRandomPlanetsList(100);
        printList(planets);
        removePlanets(planets);
        printList(planets);
    }
    static void printArray(Integer[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    static void printArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    static Integer[] deletEvenNums(Integer[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) list.add(arr[i]);
        }
        return list.toArray(new Integer[list.size()]);
    }
    static Integer[] createRandomIntArray (int size, int maxValue){
        ArrayList<Integer> list = new ArrayList<>(); 
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            list.add(rand.nextInt(maxValue));
        return list.toArray(new Integer[list.size()]);
    }
    static void max(Integer[] arr){
        Integer max = 0;
        for (Integer item : arr) {
            if(max < item) max = item;
        }
        System.out.println(max);
    }
    static void min(Integer[] arr){
        Integer min = Integer.MAX_VALUE;
        for (Integer item : arr) {
            if(min > item) min = item;
        }
        System.out.println(min);
    }
    static void mean(Integer[] arr){
        Integer min = Integer.MAX_VALUE;
        Integer max = 0;
        for (Integer item : arr) {
            if(min > item) min = item;
            else if (max < item) max = item;
        }
        Integer mean = (max + min) / 2;
        Integer median = 0;
        Integer temp = max - min;
        for (Integer item : arr) {
            if (Math.abs(item - mean) < temp){
                median = item;
                temp = Math.abs(item - mean);
            }
        }
        System.out.printf("median = %d \nmean = %d",median,mean);
    }
    static List<String> getRandomPlanetsList(int n){
        List<String> planets = List.of("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune");
        List<String> randPlanets = new ArrayList<>(n);
        
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            randPlanets.add(planets.get(rand.nextInt(planets.size())));
        }
        return randPlanets;
        
    }
    static List<String> removePlanets(List<String> list){
        List<String> planets = List.of("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune");
        int[] counts = new int[planets.size()];
        for (int i = list.size()-1; i >= 0; i--) {
            counts[planets.indexOf(list.get(i))]++;
            if (counts[planets.indexOf(list.get(i))] > 1){
                list.remove(i);
            }
        }
        return list;
    }
    static void printList(List<String> list){
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}