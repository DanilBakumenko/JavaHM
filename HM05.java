import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class HM05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        phoneBook.put("Boris",new ArrayList<>());
        phoneBook.get("Boris").add("+123");
        phoneBook.get("Boris").add("+124");
        phoneBook.get("Boris").add("+126");
        phoneBook.put("Andy",new ArrayList<>());
        phoneBook.get("Andy").add("+123");
        phoneBook.get("Andy").add("+124");
        phoneBook.get("Andy").add("+125");
        phoneBook.get("Andy").add("+126");
        phoneBook.put("Danil",new ArrayList<>());
        phoneBook.get("Danil").add("+123");
        phoneBook.get("Danil").add("+124");
        phoneBook.get("Danil").add("+125");
        phoneBook.get("Danil").add("+126");
        phoneBook.get("Danil").add("+126");
        while(true){
            System.out.print("\033[H\033[J");
            menu();
            System.out.println("Chose a digit:");
            Integer m = sc.nextInt();
            if (m == 1) {
                System.out.print("\033[H\033[J");
                System.out.println("Enter name of contakt");
                String n = sc.next();
                System.out.println("Enter phone of contakt");
                String phone = sc.next();
                addNumber(phoneBook, n, phone);
                sc.next();
            }
            else if (m == 2){
                System.out.print("\033[H\033[J");
                System.out.println("Enter name of contakt");
                String name = sc.next();
                System.out.println("Enter phone of contakt");
                String phone = sc.next();
                deletNumber(phoneBook, name, phone);
                sc.next();
            }
            else if (m == 3){
                System.out.print("\033[H\033[J");
                sortedPrint(phoneBook);
                sc.next();
            }
            else if (m == 4)break;
            else {
                System.out.println("You enter wrong number");
                sc.next();
            }
        }
        
        sc.close();
    }
    
    static void deletNumber(Map<String, ArrayList<String>> phoneBook,String name, String phone){
        if(phoneBook.containsKey(name)){
            if (phoneBook.get(name).contains(phone)) {
                phoneBook.get(name).remove(phone);
            }
            else System.out.printf("Number is not correct %s\n",phone);
        }else System.out.printf("Name is not correct %s\n",name);
    }
    
    static void addNumber(Map<String, ArrayList<String>> phoneBook,String name, String phone){

        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(phone);
        } else {
            phoneBook.put(name, new ArrayList<>());
            phoneBook.get(name).add(phone);
        }

    }

    static void menu(){
        System.out.print(
            "1. Add number\n2. Delet number\n3. Show book\n4. Exit\n"
        );
    }

    static void printContacts(Map<String, ArrayList<String>> phoneBook){
        for (Map.Entry<String, ArrayList<String>> keyValue: phoneBook.entrySet()) {
            System.out.printf("%s : ",keyValue.getKey());
            for (String phone : keyValue.getValue()) {
                System.out.print(phone + " ");
            }
            System.out.println();
        }
    }

    static void sortedPrint(Map<String, ArrayList<String>> phoneBook){
        Integer count = 0;
        Integer[] arr = new Integer[phoneBook.size()];
        for (Map.Entry<String, ArrayList<String>> item: phoneBook.entrySet()) {
            arr[count] = item.getValue().size();
            count++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j+1]) {
                    Integer temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (Map.Entry<String, ArrayList<String>> item: phoneBook.entrySet()) {
                if(item.getValue().size()== arr[i]) System.out.println(item);
            }
        }
    }
}
