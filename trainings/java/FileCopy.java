import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.*;

public class FileCopy {
    public static void main(String[] args) {
        System.out.println("Вид команды: copy [Папка для поиска] [Папка для копирования] [Расширение]");
        System.out.println("Пример: copy C:\\ C:\\Works\\ .jpg");
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String command = scanner.nextLine();
        String[] cmdFill = command.split(" ");
        List<File> fileList = new ArrayList<>();
        if (cmdFill.length == 4 && cmdFill[0].equals("copy") && cmdFill[3].startsWith(".")) {
            fileList = getFiles((new File(cmdFill[1].toLowerCase())), fileList, cmdFill[3].toLowerCase());
            copyFiles(cmdFill[2], fileList);
        } else {
            System.out.println("Неверная команда!");
        }
    }

    private static List getFiles(File rootDir, List<File> listOfFiles, String parameter) {
        if (rootDir.isDirectory()) {
            File[] files = rootDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory())
                        getFiles(file, listOfFiles, parameter);
                    else if (file.getName().endsWith(parameter))
                        listOfFiles.add(file);
                }
            }
        }
        return listOfFiles;
    }

    private static void copyFiles(String copyDir, List<File> foundFiles) {
        if (new File(copyDir).isDirectory()) {
            for (File file : foundFiles) {
                try {
                    Files.copy(file.toPath(), (new File(copyDir + file.getName())).toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Неверные параметры!");
                    return;
                }
            }
        }
    }
}
