import java.io.File;
import java.util.*;

class FileFinder {
    public static void main(String[] args) {
        ArrayList<File> list = new ArrayList<>();
        List<File> fileList = searchFiles(new File("C:\\works\\"), list);
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }

    private static List searchFiles(File rootFile, List<File> listOfFiles) {
        if (rootFile.isDirectory()) {
            System.out.println(rootFile.getPath());
            File[] dirs = rootFile.listFiles();
            if (dirs != null) {
                for (File file : dirs) {
                    if (file.isDirectory()) {
                        searchFiles(file, listOfFiles);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".java")) {
                            listOfFiles.add(file);
                        }
                    }
                }
            }
        }
        return listOfFiles;
    }
}