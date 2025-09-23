import java.io.File;

public class FileHandling {
    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/HP/OneDrive/Desktop/Demo.txt");

        file.createNewFile();
        System.out.println(file.exists());
    }
}
 