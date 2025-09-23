import java.io.BufferedReader;
import java.io.FileReader;

public class ReadToFile {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("C:/Users/HP/OneDrive/Desktop/Demo.txt");
//        System.out.println(fr.read()); // returns number of characters and if file is empty return -1

        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());

        br.close();
        fr.close();
    }
}
