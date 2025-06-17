package phonebook.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readDataFromFile(String filePath){
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            List<String> dataFromFile = new ArrayList<>();
            while (scanner.hasNextLine()) {
                dataFromFile.add(scanner.nextLine());
            }
            return dataFromFile;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException("File not found");
        }
    }


}
