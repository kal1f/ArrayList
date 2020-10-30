public interface MyList<T> extends Iterable<T> {
    /**
     * Adds element to the end of collection
     */
    void add(T element);
    /**
     * Adds element by specific index
     */
    void add(int index, T element);
    /**
     * Adds all elements of MyList
     */
    void addAll(MyList<? extends T> c);
    /**
     * Enlarges array size
     */
    void enlarge();
    /**
     * Reduces size of array to fit current element number
     */
    void trimToSize();
    /**
     * Delete element by specific index
     */
    boolean delete(int index);
    /**
     * Delete element
     */
    boolean delete(T element);
    /**
     * Get element by specific index
     */
    T get(int index);
    /**
     * Search for the element and return
     * it's index if found, -1 otherwise.
     */
    int indexOf(T element);
    /**
     * True, if MyList contain such element, False otherwise
     */
    boolean contains(T element);
}