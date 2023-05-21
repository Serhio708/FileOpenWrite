/*
public class FileOpen
public List<String> getLines()- відкриває вказаний файл та формує список з його рядків
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static java.nio.charset.StandardCharsets.UTF_8;
public class FileOpen {
    Path path;
    public FileOpen (Path path)
    {
        this.path = path;
    }
    public  List<String> getLines() throws IOException {

    return  Files.readAllLines(path, UTF_8);
    }
}
