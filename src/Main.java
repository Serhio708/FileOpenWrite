
/*
public class Main - робота при запуску з аргументами
для CLI викликається new Runner(fileName, code);
 */

import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
              int code;
                Menu menu = new Menu();
                menu.sayHello();
                Checker checker = new Checker();
              if (args.length == 0) {

                  Scanner scanner = new Scanner(System.in);
                  menu.printColorLine(SetColor.darkBlue,"--> Enter source file name   --> ");
                  String fileName = scanner.nextLine();
                  checker.fileExist(fileName);

                  menu.printColorLine(SetColor.darkBlue,"--> Enter cipher code (integer number) --> ");
                  String cipherCode = scanner.nextLine();
                  code = checker.getCode(cipherCode);

                  new Runner(fileName, code);
              } else {
                  boolean encryptMode = args[0].equalsIgnoreCase("ENCRYPT");
                  boolean decryptMode = args[0].equalsIgnoreCase("DECRYPT");
                  boolean bfMode = args[0].equalsIgnoreCase("BRUTE_FORCE");

                  if (!encryptMode && !decryptMode && !bfMode) {
                      menu.printColorLine(SetColor.Red, "--> Unknown mode! Check mode parameter");
                      menu.sayBye();
                      System.exit(0);
                  }

                  if (args.length < 3 && !bfMode) {
                      menu.printColorLine(SetColor.Red, "--> Not enough parameters!");
                      menu.sayBye();
                      System.exit(0);
                  }
                  checker.fileExist(args[1]);
                  String encryptedFileName = checker.makeFileName(args[1],"[ENCRYPTED]");
                  String decryptedFileName = checker.makeFileName(args[1],"[DECRYPTED]");

                      Path pathIn = Path.of(args[1]);
                      Path pathOut = Path.of(encryptedFileName);
                      Path pathDec = Path.of(decryptedFileName);

                  DoIt doIt = new DoIt();

                  if (encryptMode) {
                      code = checker.getCode(args[2]);
                      doIt.caseHandle(SetColor.Yellow, pathIn, pathOut, code);
                      menu.printColorLine(SetColor.darkBlue, "--> File was encrypted with key " + code + " Use scroll to see it!\n");
                  } else if (decryptMode) {
                      if (checker.encryptedFileExist(encryptedFileName, 0)) {
                          code = checker.getCode(args[2]);
                          doIt.caseHandle(SetColor.Green, pathOut, pathDec, code * (-1));
                          menu.printColorLine(SetColor.darkBlue, "--> File was decrypted with key " + code + " Use scroll to see it!\n");
                      }
                  } else {
                      if ( checker.encryptedFileExist(encryptedFileName, 0)) {
                          doIt.caseHandle(SetColor.Magenta, pathOut, pathDec, 0);

                          menu.printColorLine(SetColor.darkBlue, "--> Code was found by brute force! Code is --> " + Handle.codeByBruteForce * (-1) + "\n");
                          menu.printColorLine(SetColor.darkBlue, "--> File was decrypted by brute force! Scroll up to see it!\n");
                      }
                  }
                menu.sayBye();
          }
        }
    }
