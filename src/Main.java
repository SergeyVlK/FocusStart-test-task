public class Main {
    public static void main(String[] args) {
        String[] inFiles = new String[2];
        inFiles[0] = new String("file1.txt");
        inFiles[1] = new String("file2.txt");

        new Sorter(true, false,"out.txt", inFiles ).sort();

        //ReadFileInterface k =new IntegerFileReader("file1.txt");
        //System.out.println(k.top());








    }
}
