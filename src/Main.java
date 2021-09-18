public class Main {
    public static void main(String[] args) {
        boolean isIntegerType = true;
        boolean isAskMode = true;
        int argsLen = args.length;
        int countParams = 0;
        for(int i = 0 ; i < 2 ; i++) {
            if("-i".equals(args[i])) {
                isIntegerType = true;
                countParams++;
            }
            if("-s".equals(args[i])) {
                isIntegerType = false;
                countParams++;
            }
            if("-a".equals(args[i])) {
                isAskMode = true;
                countParams++;
            }
            if("-d".equals(args[i])) {
                isAskMode = false;
                countParams++;
            }
        }

        String outFile = args[countParams];
        String[] inFiles = new String[argsLen - countParams - 1];
        for(int i = 0; i < argsLen - countParams - 1; i++) {
            inFiles[i] = args[i + countParams + 1];
        }

        Sorter sorter = new Sorter(isIntegerType, isAskMode,outFile, inFiles);
        if(isIntegerType) {
            sorter.sort();
        }
        else {
            sorter.sortString();
        }







    }
}
