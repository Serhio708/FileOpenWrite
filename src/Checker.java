/*
public class Checker - деякі перевірки для стійкої роботи програми

public boolean encryptedFileExist - чи є зашифрований файл?
                        mode 0 - з виходом, для роботи з аргументами
                        mode 1 - з попередженням, для роботи з CLI
public void fileExist(String FileName) чи є первинний файл?
                        mode 0 - з виходом, для роботи з аргументами
                        mode 1 - з попередженням, для роботи з CLI
public String makeFileName(String SourcePathName,String Suffix) формує ім'я файлу

public int getCode(String line) - чи є code числом?
 */

import java.io.File;
public class Checker {
    public boolean encryptedFileExist(String encryptedFileName, int mode) {
        File fileEncrypted = new File(encryptedFileName);
        Menu menu = new Menu();

        if (fileEncrypted.exists() && !fileEncrypted.isDirectory()) {
            menu.printColorLine("--> Encrypted file exists!\n");
        } else {
            menu.printColorLine("--> Please ENCRYPT source file before using DECRYPT or BRUTE_FORCE mode\n");
            if (mode == 0) {
                menu.sayBye();
                System.exit(0);
            } else {
                menu.printColorLine("--> Use mode 1 first\n");
                return false;
            }
        }
        return true;
    }
    public void fileExist(String FileName){
        Menu menu = new Menu();
        File file = new File(FileName);

        if (file.exists() && !file.isDirectory()) {
            menu.printColorLine("--> Source file exists!\n");
        }
        else {
            menu.printColorLine("File doesn't exist or program doesn't have access to the file\n");
            menu.sayBye();
            System.exit(0);
        }
    }
    public String makeFileName(String SourcePathName,String Suffix)
    {
        int slashIndex = SourcePathName.lastIndexOf("\\");
        String inFileName = SourcePathName.substring(slashIndex);
        String inDirectoryName = SourcePathName.substring(0, slashIndex);

        int dotIndex = inFileName.lastIndexOf(".");
        String beforeDot = inFileName.substring(0, dotIndex);
        String afterDot = inFileName.substring(dotIndex);
        if (beforeDot.contains("[ENCRYPTED]")) {
            beforeDot = beforeDot.substring(0, beforeDot.indexOf('['));
        }

        return  inDirectoryName + beforeDot + Suffix + afterDot;
    }
    public int getCode(String line){
        Menu menu = new Menu();
        int code=0;
        try {
            code = Integer.parseInt(line.trim());
        } catch (NumberFormatException nfe) {
            menu.printColorLine("NumberFormatException: " + nfe.getMessage());
            menu.printColorLine("\n--> Enter integer number for code!");
            menu.sayBye();
            System.exit(0);
        }
        if (code < 0) {
            code *= (-1);
        }
        return code;
    }
}
