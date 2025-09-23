import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToFile {
    public static void main(String[] args) throws Exception {

        FileWriter writer = new FileWriter("C:/Users/HP/OneDrive/Desktop/Demo.txt");
        writer.write("Hello Vishant!\nWelcome to file handling.");

        //BufferedWriter can also be used to write a file
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("Written using Buffered Writer");

        bw.close();
        writer.close();
        System.out.println("Successfully written to file.");
    }
}
