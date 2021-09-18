import java.io.*;

public class IntegerFileReader implements ReadFileInterface<Integer> {

    private File file;
    private FileReader fr;
    private BufferedReader br;
    private String currentString;

    public IntegerFileReader(String path) {
        this.file = new File(path);
        this.fr = null;
        try {
            this.fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.br = new BufferedReader(fr);

    }

    @Override
    public boolean isEOF() {
        this.currentString = null;
        try {
            currentString = br.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (currentString == null) {
            return true;
        }
        return false;
    }

    @Override
    public Integer pop() {
        if(this.isEOF()) {
            return null;
        }
        return Integer.valueOf(this.currentString);
    }


}
