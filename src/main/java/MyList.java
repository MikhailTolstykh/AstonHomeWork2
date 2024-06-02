public interface MyList<T> {

    void set(int index, T element);

    void add(T element);

    T get(int index);

    boolean removeAt(int index);

    T remove(T element);

    void addAll(MyArrayList<? extends T> other);


}
