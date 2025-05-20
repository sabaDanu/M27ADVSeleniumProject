package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssetionPratice {
	@Test(retryAnalyzer=genericUtility.RetryAnalyserImplementation.class)
	public void sample() {
		
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		Assert.assertEquals(0, 1);
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
	}
	@Test
public void softSample() {
		
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(0,1);
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
		sf.assertAll();
	}
}
