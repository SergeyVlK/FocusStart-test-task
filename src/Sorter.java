
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
        Integer[] arrayOfHeadFiles = new Integer[rfi.length];
        for(int i = 0; i < arrayOfHeadFiles.length; i++) {
            arrayOfHeadFiles[i] = (Integer) rfi[i].pop();
        }
        Integer index = indexOfMin(arrayOfHeadFiles);

        while(index != null) {
            wfi.write(arrayOfHeadFiles[index]);
            arrayOfHeadFiles[index] = (Integer) rfi[index].pop();
            index = indexOfMin(arrayOfHeadFiles);
        }
        wfi.close();
    }

    private void sortDesk() {

    }

    private Integer indexOfMin(Integer[] mass) {

       Integer index = 0;
       for(int i = 1; i < mass.length; i++) {
           if(mass[i] == null) {
               continue;
           }
           else if(mass[index] == null)  {
               index = i;
           }
           else if(mass[index] > mass[i]) {
               index = i;
           }
       }
       if(mass[index] != null) {
           return index;
       }
       else {
           return null;
       }
    }
}
