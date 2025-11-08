package thisAndSuperRevision;

import org.testng.annotations.Test;

public class Ps{



    @Test
    public void run(){
        Ps1 p = new Ps1(3);

        System.out.println("The current value is " + 3);

        System.out.println("The increment is " + p.increment());
        System.out.println("The decrement is " + p.decrement());
        System.out.println("The multiplication is " + p.multiply());


    }
}
