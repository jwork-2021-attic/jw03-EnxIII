package example;

public class QuickSorter implements Sorter{
    protected int[] buffer;
    protected String log;

    @Override
    public void sort(){
        if (buffer == null)
            return;
        this.log = "";
        this.quicksort(0, this.buffer.length);
    }

    protected String swap(int a, int b){
        int temp = this.buffer[a];
        this.buffer[a] = this.buffer[b];
        this.buffer[b] = temp;
        return (this.buffer[a] + "<->" + this.buffer[b] + '\n');
    }

    private void quicksort(int left, int right){
        if (right - left <= 1)
            return;
        int pivot = left, lboudary = left;
        for (int k = left + 1; k < right; ++k){
            if (this.buffer[pivot] > this.buffer[k]){
                if (++lboudary != k)
                    this.log += swap(lboudary, k);
            }
        }
        if (pivot != lboudary)
            this.log += swap(pivot, lboudary);
        quicksort(left, lboudary);
        quicksort(lboudary + 1, right);
    }

    @Override
    public void load(int[] elements){
        this.buffer = elements;
    }

    @Override
    public String getPlan(){
        return this.log;
    }
}