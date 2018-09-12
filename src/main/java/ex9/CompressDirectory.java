package ex9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressDirectory {

    private final Logger logger = Logger.getLogger(CompressDirectory.class.getName());
    Scanner scanner = new Scanner(System.in);
    private String directoryPath;
    private String directoryOutputPath;

    public static void main(String[] args) throws IOException {

        CompressDirectory compressDirectory = new CompressDirectory();

        System.out.println(">>>Podaj scieżkę do folderu, który chcesz skompresować:");
        String directoryPath = compressDirectory.getDirectoryPath();
        
        System.out.println(">>>Podaj scieżkę do pliku wynikowego - " +
                "jeśli chcesz, aby plik został utworzony na tym samym poziomie co kompresowany folder, " +
                "wciśnij enter:");
        String directoryOutputPath = compressDirectory.getDirectoryOutputPath();

        File directory = new File(directoryPath);
        List<File> fileList = compressDirectory.getFilesFromDirectory(directory);

        System.out.println(">>>Trwa kompresowanie folderu " + directory + "...");
        compressDirectory.zipDirectory(fileList, directoryPath, directoryOutputPath);

        System.out.println(">>>Koniec :)");

    }

    private String getDirectoryPath() {

        while (directoryPath == null) {
            try {
                directoryPath = new String(scanner.next());
            } catch (Exception e) {
                System.out.println("Wystąpił błąd. Spróbuj jeszcze raz");
                logger.log(Level.INFO, e.getMessage());
            }
        }

        return directoryPath;

    }

    private String getDirectoryOutputPath() {

        try {
            directoryOutputPath = new String(scanner.next());

            if (directoryOutputPath.equals("")) {
                directoryOutputPath = directoryPath + ".zip";
            }

        } catch (Exception e) {
            System.out.println("Wystąpił błąd. Spróbuj jeszcze raz");
            logger.log(Level.INFO, e.getMessage());
        }

        return directoryOutputPath;

    }

    private List<File> getFilesFromDirectory(File directory) {

        List<File> fileList = new ArrayList<>();

        try {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (!file.isDirectory()) {
                    fileList.add(file);
                    System.out.println("   file:" + file.getCanonicalPath());
                }
            }
        } catch (IOException e) {
            logger.log(Level.INFO, e.getMessage());
        }

        return fileList;

    }

    private void zipDirectory(List<File> fileList, String directoryPath, String directoryOutputPath) {

        try {
            FileOutputStream fos = new FileOutputStream(directoryOutputPath);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (File file : fileList) {
                if (!file.isDirectory()) {
                    addToZip(directoryPath, file, zos);
                }
            }

            zos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, e.getMessage());
        } catch (IOException e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }

    public void addToZip(String directoryPath, File file, ZipOutputStream zos) throws FileNotFoundException,
            IOException {

        FileInputStream fis = new FileInputStream(file);

        String zipFilePath = file.getCanonicalPath().substring(directoryPath.length() + 1,
                file.getCanonicalPath().length());

        logger.log(Level.INFO, "Writing " + zipFilePath + " to zip file");

        ZipEntry zipEntry = new ZipEntry(zipFilePath);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }

}




