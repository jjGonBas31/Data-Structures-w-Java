package Bag;

public class ArrayBag<T> implements BagInterface<T>{

    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag(int capacity){
        numberOfEntries = 0;
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
    }

    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }

    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        boolean result = false;
        if (!isFull()){
            result = true;
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } return result;
    }

    @Override
    public T remove() {
        T result = null;
        if (!isEmpty()){
            numberOfEntries--;
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries] = null;
        } return result;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        if (contains(anEntry)){
            if(bag[numberOfEntries - 1] == anEntry){
                remove();
            } else {
                J: for (int i = 0; i < numberOfEntries; i++){
                    if (anEntry.equals(bag[i])){
                        bag[i] = bag[numberOfEntries - 1];
                        remove();
                        break J;
                    }
                }
            } result = true;
        } return result;
    }

    @Override
    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++){
            if (bag[i] == anEntry) {
                counter++;
            }
        } return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean result = false;
        for (int i = 0; i < numberOfEntries; i++){
            if (anEntry.equals(bag[i])) {
                result = true;
                break;
            }
        } return result;
    }

    @Override
    public T[] toArray() {
        T[] resultArray = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++){
            resultArray[i] = bag[i];
        } return resultArray;
    }


}


