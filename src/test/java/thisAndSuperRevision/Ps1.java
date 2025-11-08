package thisAndSuperRevision;

public class Ps1 extends Ps2{

    int a;

    public Ps1(int a){
        super(a);
        this.a = a;
    }

    public int increment(){
        int b = a;
        b = b + 1;
        return b;
    }

    public int decrement(){
        int c = a;
        c = c - 1;
        return c;
    }
}
