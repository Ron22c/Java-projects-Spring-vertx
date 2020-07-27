package setTest;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class SetTest {
    public static void main(String[] args) {
        Comparator<Data<Integer, String>> c = new Comparator<Data<Integer, String>>() {
            @Override
            public int compare(Data<Integer, String> o1, Data<Integer, String> o2) {
                if(o1.getKey() > o2.getKey()) {
                    return 1;
                }
                else if(o1.getKey().equals(o2.getKey())) return 0;
                else return -1;
            }
        };
        Set<Data<Integer, String>> list = new TreeSet<>(c);
        list.add(new Data<>(0, "value"));
        list.add(new Data<>(1, "one"));
        list.add(new Data<>(2, "two"));
        list.add(new Data<>(3, "three"));
        list.add(new Data<>(4, "four"));

        Stack s = new Stack();

        for(Data<Integer, String> d:list) {
            System.out.println(d);
        }

        Deque<Integer> q = new ArrayDeque<>();
        Queue<Integer> QQ = new LinkedBlockingQueue<>();

        System.out.println("*************************");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(23);
        pq.add(21);
        pq.add(24);
        pq.add(22);
        for(int i =pq.size(); i>=0;i--) {
            System.out.println(pq.size());
            System.out.println(pq.poll());
        }
    }
}

class Data<K,V> {
    private K key;
    private V value;

    public Data(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data<?, ?> data = (Data<?, ?>) o;
        return Objects.equals(getKey(), data.getKey()) &&
                Objects.equals(getValue(), data.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}

