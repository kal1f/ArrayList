public class Main {

    public static void main(String[] args) {
        MyListClass<Integer> acc1 = new MyListClass<Integer>();
        acc1.add(1);
        acc1.add(2);
        acc1.add(32);
        System.out.println(acc1.indexOf(1));
        System.out.println(acc1.contains(3));
        System.out.println(acc1.get(1));
        acc1.delete(0);
        System.out.println(acc1.get(0));
        acc1.trim();
        acc1.add(5);
        System.out.println(acc1.get(2));
        acc1.add(123);
        System.out.println(acc1.delete((Object)123));
        System.out.println(acc1.get(3));
        for(Object obj : acc1) {
            System.out.println(obj);
        }
        acc1.add("21");
        for(Object obj: acc1) {
            System.out.println(obj);
        }
        acc1.forEach(System.out :: println);

    }
}
