public interface MyList {
    void add(Object element);
    void enlarge();
    void trim();
    boolean delete(int index);
    Object get(int index);
    int index(Object element);
    boolean contains(Object element);
}
