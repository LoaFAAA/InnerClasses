package InnerClassesTest;

interface Selector1 {
    boolean end();
    Object current();
    void next();
}

public class Ex4 {
    private Object[] items;
    private int next = 0;
    // to test SequenceSelector sequence4() in main():
    public void test() { System.out.println("Sequence4.test()"); }
    public Ex4(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector1 {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
        // method to produce outer class reference:
        public Ex4 Ex4() { return Ex4.this; }
    }
    public Selector1 selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        Ex4 sequence = new Ex4(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector1 selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        // cast and test:
        ((SequenceSelector)selector).Ex4().test();
    }
}