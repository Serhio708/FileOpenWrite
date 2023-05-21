/*
public class Runner - CLI для взаємодії з користувачем
 */

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Runner {
    String fileName;
    int code;

    public Runner(String fileName, int code) throws IOException {
        this.fileName = fileName;
        this.code = code;
        runApplication();
    }

    public void runApplication() throws IOException {
        Menu menu = new Menu();
        DoIt doIt = new DoIt();
        Checker checker = new Checker();
        String encryptedFileName = checker.makeFileName(fileName,"[ENCRYPTED]");
        String decryptedFileName = checker.makeFileName(fileName,"[DECRYPTED]");
        Path pathIn = Path.of(fileName);
        Path pathOut = Path.of(encryptedFileName);
        Path pathDec = Path.of(decryptedFileName);

        boolean goOn = true;
        int choice;

        while (goOn) {
            Scanner scanner = new Scanner(System.in);
            menu.show();

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                menu.printColorLine(SetColor.Red, "Enter number from 1 to 4\n");
                continue;
            }
            switch (choice) {
                case 1 -> {
                    doIt.caseHandle(SetColor.Yellow, pathIn, pathOut, code);
                    menu.printColorLine(SetColor.darkBlue, "--> File was encrypted! Scroll up to see it!\n");
                }
                case 2 -> {
                    if (checker.encryptedFileExist(pathOut.toString(), 1)) {
                        doIt.caseHandle(SetColor.Green, pathOut, pathDec, code * (-1));
                        menu.printColorLine(SetColor.darkBlue, "--> File was decrypted! Scroll up to see it!\n");
                    }
                }
                case 3 -> {
                    if (checker.encryptedFileExist(pathOut.toString(),1)) {
                        doIt.caseHandle(SetColor.Magenta, pathOut, pathDec, 0);
                        menu.printColorLine(SetColor.darkBlue, "--> Code was found by brute force! Code is --> " + Handle.codeByBruteForce * (-1) + "\n");
                        menu.printColorLine(SetColor.darkBlue, "--> File was decrypted with brute force! Scroll up to see it!\n");
                    }
                }
                case 4 -> {
                    menu.printColorLine(SetColor.darkBlue, " Thank you for your time!\n");
                    menu.sayBye();
                    goOn = false;
                }
                default -> menu.printColorLine(SetColor.Red, "Enter number from 1 to 4\n");
            }
        }
    }
}
