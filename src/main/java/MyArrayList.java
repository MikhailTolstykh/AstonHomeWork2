import java.util.Collection;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    Object[] array = new Object[10];
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public MyArrayList(Collection<? extends T> c) {
        this.array = c.toArray();
        this.size = c.size();
    }


    @Override
    public void add(T element) {
        if (size >= array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];

    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        if (checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }


    @Override
    public void addAll(MyArrayList<? extends T> other) {
        for (int i = 0; i < other.size; i++) {
            ensureCapasity(size + other.size);
            add(other.get(i));
        }
    }

    public MyArrayList() {
    }

    private void ensureCapasity(int minCapasity) {
        if (minCapasity > array.length) {
            Object[] newArray = new Object[minCapasity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

    }


    public static <T extends Comparable<T>> void bubbleSort(MyArrayList<T> collection) {
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < collection.size - 1; i++) {
                if (collection.get(i).compareTo(collection.get(i + 1)) > 0) {
                    T temp = collection.get(i);
                    collection.set(i, collection.get(i + 1));
                    collection.set(i + 1, temp);
                    flag = true;
                }
            }
        }
    }

    boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            return true;
        } else return false;
    }
}