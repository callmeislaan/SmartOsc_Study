package bai1;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Objects;

public class Bai1 {

    public static void getAllSubdirectoriesLambda(String path) {
        FileFilter fileFilter = file1 -> file1.isDirectory();
        File[] files = new File(path).listFiles(fileFilter);
        for (File file :
                Objects.requireNonNull(files)) {
            System.out.println(file.getName());
        }
    }

    public static void getAllSubdirectories(String path) {
        File[] files = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File file:
                Objects.requireNonNull(files))
            System.out.println(file.getName());
    }

    public static void main(String[] args) {
        String path = "src";
        getAllSubdirectoriesLambda(path);
        getAllSubdirectories(path);
    }
}
