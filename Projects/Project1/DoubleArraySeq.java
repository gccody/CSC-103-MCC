package Projects.Project1;

/**
 * Initalize either with or without an inital value for the size of the array.
 * @author Grant Cody
 */
public class DoubleArraySeq {
    private int index = 0;
    private int size = 0;
    private double[] arr;
    private final int DEFAULTSIZE = 10;

    public static void main(String[] args) {
        DoubleArraySeq arr = new DoubleArraySeq();
        System.out.println(arr.getElement(1));
    }

    public DoubleArraySeq() {
        this.arr = new double[this.DEFAULTSIZE];
    }

    public DoubleArraySeq(int initalSize) {
        this.arr = new double[initalSize];
    }

    public void start() {
        this.index = 0;
    }

    public void advance() {
        this.index++;
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.arr.length;
    }

    public void setCurrent(int index) {
        checkIndexValidity(index);
        this.index = index;
    }

    public double getCurrent(int index) {
        checkIndexValidity(index);
        return this.arr[index];
    }

    public double getElement(int index) {
        checkIndexValidity(index);
        return this.arr[index];
    }

    public void addBefore(double value) {
        for (int localIndex = this.size-1; localIndex > this.index; localIndex--) {
            double tempValue = this.arr[localIndex];
            this.arr[localIndex+1] = tempValue;
            System.out.println(localIndex);
        }
    }

    public void addAfter(double value) {

    }

    public void trimToSize() {

    }

    public double getCurrent() {
        return this.arr[this.index];
    }

    public boolean isCurrent() {
        return true;
    }

    private void checkIndexValidity(int index) throws IllegalStateException, IllegalArgumentException {
        if (arr == null) throw new IllegalStateException("Array not initalized");
        else if (index < 0 || index > arr.length - 1) throw new IllegalArgumentException("Index is " + (index < 0 ? "smaller then zero" : "Greater then then the array size"));
        else if (index+1 > this.size) throw new IllegalArgumentException("Index is larger then total values given");
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity < this.arr.length) return;
        double[] extendedArray = new double[minCapacity - this.arr.length];
        this.arr = addArrays(this.arr, extendedArray);
    }

    private double[] addArrays(double[]... arrays) {
        int size = 0;
        for (double[] array: arrays) size += array.length;
        double[] newArray = new double[size];
        int index = 0;
        for (double[] array: arrays) {
            for (double value: array) {
                newArray[index] = value;
                index++;
            }
        }
        return newArray;
    }

    public String toString() {
        String str = "";
        for (this.start(); this.isCurrent(); this.advance()) {
            str += String.format(" %s", this.getCurrent());
        }
        return str.trim();
    }
}
