public class Main {

    public static void main(String[] args) {
        MyListImpl<Number> acc1 = new MyListImpl<Number>();
        acc1.add(1);
        acc1.add(2);
        acc1.add(32);
        acc1.add(12);
        for(int i = 0; i < 12; i++){
            acc1.add(i);
        }
        System.out.println(acc1.indexOf(1));
        System.out.println(acc1.contains(3));
        System.out.println(acc1.get(1));
        acc1.delete(0);
        System.out.println(acc1.get(0));
        acc1.trimToSize();
        acc1.add(5);
        System.out.println(acc1.get(2));
        acc1.add(123);
        System.out.println(acc1.delete((Object)123));
        System.out.println(acc1.get(3));
        for(Object obj : acc1) {
            System.out.println(obj);
        }
        acc1.add(3213.123);
        for(Object obj: acc1) {
            System.out.println(obj);
        }
        acc1.forEach(System.out :: println);
        MyListImpl<Integer> acc2 = new MyListImpl<Integer>();
        for(int i = 5;i > 0;i--) {
            acc2.add(i);
        }
        acc1.addAll(acc2);
        for(int i=0; i<5;i++) {
            acc2.add(i);
        }
        acc2.add(1, 1000);
        acc2.add(-1, 2000);
        acc2.add(40,3000);
        System.out.println(acc2.indexOf(3000));
        System.out.println(acc2.indexOf(null));
    }
}
