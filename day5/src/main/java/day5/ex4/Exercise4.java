package day5.ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise4 {
    public static void cat(File file) throws IOException {
        String line = null;
        try (RandomAccessFile input = new RandomAccessFile(file, "r")){
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
