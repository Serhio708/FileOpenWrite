/*
public class DoIt обробка пункта меню при виборі
взаємодія об'єктів fileopen та handle
 */
import java.io.IOException;
import java.nio.file.Path;
public class DoIt {
    public void caseHandle(String color, Path pathIn, Path pathOut, int code) throws IOException {

        FileOpen fileopen = new FileOpen(pathIn);
        Handle handle = new Handle(pathOut, code, fileopen.getLines());
        Menu menu = new Menu();
        for (String line : handle.getHandledLines()) {
            menu.printColorLine(color, line+"\n");
        }
    }


}
