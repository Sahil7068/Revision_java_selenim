package testNNg;

import org.testng.annotations.Test;


public class demo {

    @Test
    public void demo(){
        System.out.println("The new");
    }

    @Test
    public void demonew2(){
        System.out.println("The neww");
    }

    @Test
    public void onew2(){
        System.out.println("The neww");
    }

    @Test(groups={"smoke"})
    public void kane(){
        System.out.println("kane");
    }
}
