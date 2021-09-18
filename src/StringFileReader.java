import java.io.*;

public class StringFileReader implements ReadFileInterface<String> {

    private File file;
    private FileReader fr;
    private BufferedReader br;
    private String currentString;

    public StringFileReader(String path) {
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
    public String pop() {
        if(this.isEOF()) {
            return null;
        }
        return this.currentString;
    }


}
