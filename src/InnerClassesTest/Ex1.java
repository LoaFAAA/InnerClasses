package InnerClassesTest;
class Outer {
    private String i = "i am private";
    class Inner {
       public String toString() {return i;}
    }
    public Inner toInner(){
        System.out.println("hi");
        return new Inner();
    }
}
public class Ex1 {
    public static void main(String[] args) {
        Outer c = new Outer();
        Outer.Inner d = c.toInner();
        System.out.println(d.toString());
    }
}
