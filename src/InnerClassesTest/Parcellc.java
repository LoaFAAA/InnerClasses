package InnerClassesTest;
public class Parcellc{
    class Contents {
        private int i = 10;
        public int value() { return i;}
    }
    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLadel() { return label; }
    }
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }
    public void ship (String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        //System.out.println(c.value());
        System.out.println(d.readLadel());
    }
    public static void main(String[] args) {
        Parcellc p = new Parcellc();
        p.ship("Tasmania");
        Parcellc q = new Parcellc();
        Parcellc.Contents c = q.contents();
        Parcellc.Destination d = q.to("borneo");
    }
}

