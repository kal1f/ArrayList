public interface MyList {
    void add(Object element);
    void enlarge();
    void trim();
    boolean delete(Object element);
    boolean delete(int index);
    Object get(int index);
    int indexOf(Object element);
    boolean contains(Object element);
}
