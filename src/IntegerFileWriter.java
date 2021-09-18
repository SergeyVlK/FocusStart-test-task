import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IntegerFileWriter implements WriteFileInterface<Integer> {
    File file;
    FileWriter fw;
    public IntegerFileWriter(String path) {
        this.file = new File(path);
        this.fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void write(Integer value) {
        try {
            fw.write(value.toString() + "\n");
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

