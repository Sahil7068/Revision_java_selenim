package testNNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo1 {

    @Parameters({"URL"})
    @Test(groups = {"smoke"})
    public void understand(String url){
        System.out.println("understand");
        System.out.println(url);
    }

    @Test(groups = {"smoke"})
    public void nii(){
        System.out.println("nii");
    }
}
