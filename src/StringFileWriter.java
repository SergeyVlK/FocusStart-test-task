import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringFileWriter implements WriteFileInterface<String> {

    File file;
    FileWriter fw;
    public StringFileWriter(String path) {
        this.file = new File(path);
        this.fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void write(String value) {
        try {
            fw.write(value + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            fw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
