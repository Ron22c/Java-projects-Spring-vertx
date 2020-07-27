package enumTest;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Topics t = Topics.COREJAVA;
        switch (t) {
            case COREJAVA:
                System.out.println(1);
                break;
            case MULTITHREADING:
                System.out.println(2);
                break;
            case COLLECTION:
                System.out.println(3);
                break;
            case SPRING:
                System.out.println(4);
                break;
            default:
                System.out.println(5);
        }

        String one = "hi";
        String two = "hi";

        String three = new String("hi");
        String four = new String("hi");
        Scanner s = new Scanner(System.in);
        Stack stack = new Stack();
        stack.push(12);
        stack.isEmpty();



        ArrayList<Name> list = new ArrayList();
        list.add(new Name("hello"));
        list.add(new Name("lo"));
        list.add(new Name("abd"));
        System.out.println(list);

//        Collections.sort(list);
        Collections.sort(list, new Comparator<Name>() {
            @Override
            public int compare(Name o1, Name o2) {
                if(o1.getName().length()==o2.getName().length()) {
                    return 0;
                } else if(o1.getName().length()<o2.getName().length()){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(list);

        Queue q = new LinkedList();
        q.poll();

        System.out.println(one.hashCode() + " "+two.hashCode() + " "+three.hashCode() + " "+four.hashCode() + " ");
        if(one==two) {
            System.out.println("its hi");
        } else {
            System.out.println("its not hi");
        }

        List<Data<Object>> dList = new ArrayList<>();
        dList.add(new Data<Object>("hello"));
        dList.add(new Data<Object>(1));
        dList.add(new Data<Object>('1'));
        dList.add(new Data<Object>(1.23));
        new Data<>("hi").write("hello",23);
        Iterator<Data<Object>> itt = dList.iterator();
        for(;itt.hasNext();) {
            System.out.println("element: "+itt.next().getData());
        }
    }
}

class Name implements Comparable<Name>
{
    private String name;
    public Name(String name) {
        this.name= name;
    }
    @Override
    public int compareTo(Name o) {
        if(this.name.length() == o.name.length()) {
            return 0;
        } else if(this.name.length()>o.name.length()){
            return -1;
        } else {
            return 1;
        }
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString(){
        return name;
    }
}

class Data<T> {
    private T data;

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }

    public T getData() {
        return data;
    }

    public Data(T data) {
        this.data = data;
    }

    public <E, N> void write(E element, N number) {
        System.out.println(data+" "+number);
    }
}

class methodGeneric {
    public <T> void printLS(List<T> list){
        for(T t:list) {
            System.out.println(t);
        }
    }

    public <E> void printarr(List<E> list){
        for(E t:list) {
            System.out.println(t);
        }
    }

    public <A> void printarr1(List<A> list){
        for(A t:list) {
            System.out.println(t);
        }
    }
}