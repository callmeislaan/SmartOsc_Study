package bai2;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;

public class Bai2 {

    public static void getAllFile(String path, String extension) {
        FilenameFilter fileFilter = (dir, name) -> name.endsWith(extension);
        String[] files = new File(path).list(fileFilter);
        for (String file :
                Objects.requireNonNull(files)) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        String path ="src/bai1";
        String extension = "java";
        getAllFile(path, extension);
    }
}
