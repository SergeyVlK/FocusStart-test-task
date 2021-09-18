
public class Sorter {
    private ReadFileInterface[] rfi;
    private WriteFileInterface wfi;
    private boolean isAskMode;


    public Sorter(boolean isIntegerType, boolean isAskMode, String outFile, String[] inFiles ) {
        if(isIntegerType) {
            rfi = new IntegerFileReader[inFiles.length];
            for(int i = 0; i < inFiles.length; i++) {
                rfi[i] = new IntegerFileReader(inFiles[i]);
            }
        wfi = new IntegerFileWriter(outFile);
        }
        else {
            rfi = new StringFileReader[inFiles.length];
            for(int i = 0; i < inFiles.length; i++) {
                rfi[i] = new StringFileReader(inFiles[i]);
            }
            wfi = new StringFileWriter(outFile);
        }

        this.isAskMode = isAskMode;
    }

    public void sort() {
        if (this.isAskMode) {
            this.sortAsk();
        }
        else {
            this.sortDesk();
        }
    }

    private void sortAsk() {
        Integer index = indexOfMin(rfi);

        while(index != null) {
            wfi.write(rfi[index.intValue()].pop().toString());
            index = indexOfMin(rfi);
        }
        wfi.close();
    }

    private void sortDesk() {

    }

    private Integer indexOfMin(ReadFileInterface<Integer>[] rfi) {
       Integer result = rfi[0].top();

       Integer index = 0;
       for(int i = 1; i < rfi.length; i++) {
           if(rfi[i].top() == null) {
               continue;
           }
           else if(result == null) {
               result = rfi[i].top();
               index = i;
           }
           else if(result > rfi[i].top()) {
               result = rfi[i].top();
               index = i;
           }
       }
       if(result != null) {
           return index;
       }
       else {
           return null;
       }
    }
}
