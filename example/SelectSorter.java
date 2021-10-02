package example;

public class SelectSorter implements Sorter{
    protected int[] buffer;
    protected String log;

    private String swap(int i, int j) {
        int temp;
        temp = buffer[i];
        buffer[i] = buffer[j];
        buffer[j] = temp;
        return (buffer[i] + "<->" + buffer[j] + "\n");
    }

    @Override
    public void load(int[] a) {
        this.buffer= a;
        this.log = "";
    }

    @Override
    public void sort() {
        for (int round = this.buffer.length - 1; round > 0; --round){
            int temp = 0;
            for (int i = 1; i <= round; ++i){
                if (this.buffer[temp] < this.buffer[i])
                    temp = i;
            }
            if (temp != round)
                this.log += swap(temp, round);
        }
    }

    @Override
    public String getPlan() {
        return this.log;
    }
}
