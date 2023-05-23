/*
public class Handle - обробка списків за допомогою Caesar Cipher

public List<String> getHandledLines() - перетворюе список необроблених рядків
                                        на список рядків оброблених класом Caesar Cipher
                                        та виводить їх у файл

public int bruteForce( List<String> codedLines) - підбирає ключ кодування за ознаками
                                                   кома + пробіл, крапка + пробіл, кома + \n, крапка + \n
bruteForce викликається конструктором класу при передачі 0 в параметрі code

public static int codeByBruteForce зберігае значення кода знайденого BruteForce
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Handle {
    public static int codeByBruteForce;
    public int code;
    Path pathOut;

    List<String> list;
    public Handle(Path pathOut, int code, List<String> list)
    {
        this.pathOut = pathOut;
        this.code = code;
        this.list = list;

        if (code == 0) {
            this.code =  bruteForce()*(-1);
            codeByBruteForce = this.code;
        }
    }
    public List<String> getHandledLines() {
        CaesarCipher cipher = new CaesarCipher(code);
        List<String> handledLines;
        handledLines = new ArrayList<>();

        try (BufferedWriter bw = Files.newBufferedWriter(pathOut, StandardCharsets.UTF_8))
        {
            for (String notHandledLine: list) {
                String cipheredLine = cipher.cipher(notHandledLine);
                bw.write(cipheredLine + "\n");
                handledLines.add(cipheredLine);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  handledLines;
    }
     public int bruteForce(){

        for (int tryCode=1; tryCode< Letter.abcEnglish.length(); tryCode++ ) {
            CaesarCipher cipher = new CaesarCipher(tryCode * (-1));
            int counter = 0;
            for (String codedLine : list) {
                String decodedLine = cipher.cipher(codedLine);
                boolean inComma = decodedLine.contains(", ");
                boolean endComma = decodedLine.contains(",\n");
                boolean inPoint = decodedLine.contains(". ");
                boolean endPoint = decodedLine.contains(".\n");
                if (inComma || inPoint || endComma || endPoint) {
                    counter++;
                    System.out.println("Співпадіння -->" + counter);
                    if (counter >3) {
                        System.out.println("Brute_force знайдено 4 співпадіння ключа");
                        System.out.println("Дешифровка з ключем " + tryCode);
                        return tryCode;
                        }
                    }
                }


            }
        return 0;
    }
}
