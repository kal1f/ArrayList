public class MyListClass<T> implements MyList {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int capacity;
    private Object[] elementData;

    public MyListClass(){
        elementData = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }
    public MyListClass(int capacity){
        elementData = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public void add(Object element) {
        if(size < capacity) {
            elementData[size] = (T) element;
            size++;
        }
        else {
            enlarge();
            elementData[size] = (T) element;
            size++;
        }
    }

    @Override
    public void enlarge() {
        Object[] oldData = elementData;
        int newCapacity = (capacity * 3) / 2 + 1;
        capacity = newCapacity;
        elementData = (T[]) new Object[capacity];
        System.arraycopy(oldData, 0, elementData, 0, size);
    }

    @Override
    public void trim() {
        System.arraycopy(elementData, 0, elementData, 0, size);
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index <= capacity - 1) {
            int numMoved = size - index - 1;
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
            capacity--;
            elementData[size] = null;
            size--;
            return true;
        }
        else {
            return  false;
        }

    }

    @Override
    public Object get(int index) {
        if(index >= 0 && index <= capacity-1) {
            return elementData[index];
        }
        else {
            return null;
        }
    }

    @Override
    public int index(Object element) {
        for (int index = 0; index < capacity - 1; index++) {
            if (element.equals(elementData[index])) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object element) {
        return index(element) != -1;
    }
}

