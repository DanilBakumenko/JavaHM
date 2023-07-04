import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * HM02
 *  1) Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
    1 Расширение файла: txt
    2 Расширение файла: pdf
    3 Расширение файла:
    4 Расширение файла: jpg

    2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class HM02 {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String pathFile = projectPath.concat("\\Logs.txt");
        // String[] fileNames = createFileNamesList(projectPath);
        // printTypeFiles(fileNames);
        int[] arr = {1, 3, 5, 1, 6, 3, 12, 15, 3, 10};
        sortArrayWithSortingLogs(pathFile, arr);
    }
    static void sortArrayWithSortingLogs(String logPath, int[] arr) throws IOException{
        File logs = new File(logPath);
        FileWriter writer = new FileWriter(logs);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            for (int elem : arr) {
                writer.append(String.valueOf(elem))
                    .append(" ");
            }
            writer.write("\n");
        }
        writer.close();
        System.out.println("File written successfully!");
    }
    static void printTypeFiles(String[] fNames){
        for (String name : fNames) {
            boolean flag = false;
            for (int i = 0; i < name.length(); i++) {
                if(flag == true) System.out.print(name.charAt(i));
                else if(i == name.length()-1 && flag != true) System.out.print("folder ");
                else if (name.charAt(i) == '.') flag = true;
            }
            System.out.println();
        }
    }
    static String[] createFileNamesList(String folderPath){
        File folder = new File(folderPath);
        return folder.list();                
    }
}
