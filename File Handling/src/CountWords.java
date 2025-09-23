import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text");
        String str = sc.nextLine();

        File file = new File("test.txt");
        file.createNewFile();

        FileWriter fw = new FileWriter(file);
        fw.write(str);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        int c;
        int countWord = 0;


    }
}
