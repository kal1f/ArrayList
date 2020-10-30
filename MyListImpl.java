import java.util.Iterator;

public class MyListImpl<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elementData;

    public MyListImpl(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public MyListImpl(int capacity){
        elementData = new Object[capacity];
    }

    @Override
    public void add(T element) {
        if(size < elementData.length) {
            elementData[size] = element;
            size++;
        }
        else {
            enlarge();
            elementData[size] = element;
            size++;
        }
    }

    @Override
    public void add(int index, T element) {
        try {
            if (size == elementData.length) {
                enlarge();
                int numMoved = size - index;
                System.arraycopy(elementData, index, elementData, index + 1, numMoved);
                elementData[index] = element;
                size++;
            }
            else {
                while(index > elementData.length) {
                    enlarge();
                }
                elementData[index] = element;
                size++;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Index is less than 0");
        }
    }

    @Override
    public void addAll(MyList<? extends T> c) {
        c.forEach(this::add);
        /*System.arraycopy(c, 0, elementData, this.size, );*/
    }

    @Override
    public void enlarge() {
        Object[] oldData = elementData;
        int newCapacity = (elementData.length * 3) / 2 + 1;
        elementData = new Object[newCapacity];
        System.arraycopy(oldData, 0, elementData, 0, size);
    }

    @Override
    public void trimToSize() {
        Object[] oldData = elementData;
        elementData = new Object[size];
        System.arraycopy(oldData, 0, elementData, 0, size);
    }

    @Override
    public boolean delete(int index) {
        if(index >= 0 && index <= elementData.length - 1) {
            int numMoved = size - index - 1;
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
            size--;
            elementData[size] = null;
            return true;
        }
        else {
            return  false;
        }

    }

    @Override
    public boolean delete(Object element) {
        return delete(indexOf(element));
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index <= elementData.length - 1) {
            return (T) elementData[index];
        }
        else {
            return null;
        }
    }

    @Override
    public int indexOf(Object element) {
        if(element == null) {
            return -1;
        }
        for (int index = 0; index < elementData.length - 1; index++) {
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