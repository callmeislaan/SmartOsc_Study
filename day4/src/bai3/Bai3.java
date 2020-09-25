package bai3;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

import static java.lang.System.*;

public class Bai3 {

    public static void get(String path) {
        FileFilter fileFilter = pathname -> true;
        File[] files = new File(path).listFiles(fileFilter);
        Arrays.sort(Objects.requireNonNull(files), (File o1, File o2) -> {
            if (!o1.isDirectory() && o2.isDirectory()) return 1;
            else if ((o1.isDirectory() && o2.isDirectory()) || (!o1.isDirectory() && !o2.isDirectory()))
                return o1.getName().compareTo(o2.getName());
            return -1;
        });
        for (File file :
                Objects.requireNonNull(files)) {
            out.println(file.getName());
        }
    }

    public static void main(String[] args) {
        String path = "src";
        get(path);
    }
}
