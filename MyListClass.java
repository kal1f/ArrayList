import java.util.Iterator;

public class MyListClass<T> implements MyList, Iterable {

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
    public boolean delete(Object element) {
        for(int index=0; index < capacity - 1; index++) {
            if(element.equals(elementData[index])) {
                int numMoved = size - index - 1;
                System.arraycopy(elementData, index + 1, elementData, index, numMoved);
                capacity--;
                elementData[index] = null;
                size--;
                return true;
            }
        }
        return false;
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
    public int indexOf(Object element) {
        for (int index = 0; index < capacity - 1; index++) {
            if (element.equals(elementData[index])) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elementData[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) elementData[currentIndex++];
            }
        };

        return it;
    }

}

