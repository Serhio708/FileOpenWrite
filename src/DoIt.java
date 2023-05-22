/*
public class DoIt обробка пункта меню при виборі
взаємодія об'єктів FileOpen та handle
 */
import java.io.IOException;
import java.nio.file.Path;
public class DoIt {
    public void caseHandle(Path pathIn, Path pathOut, int code) throws IOException {

        FileOpen fileopen = new FileOpen(pathIn);
        Handle handle = new Handle(pathOut, code, fileopen.getLines());
        Menu menu = new Menu();
        for (String line : handle.getHandledLines()) {
            menu.printColorLine(line+"\n");
        }
    }


}
