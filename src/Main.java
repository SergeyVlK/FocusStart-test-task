public class Main {
    public static void main(String[] args) {
        String[] inFiles = new String[3];
        inFiles[0] = new String("file1.txt");
        inFiles[1] = new String("file2.txt");
        inFiles[2] = new String("file3.txt");

        new Sorter(false, true,"out.txt", inFiles ).sortString();

        //ReadFileInterface k =new IntegerFileReader("file1.txt");
        //System.out.println(k.top());








    }
}
