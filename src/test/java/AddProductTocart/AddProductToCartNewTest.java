package AddProductTocart;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import genericUtility.BaseClass;
@Listeners(genericUtility.ListenersImplementation.class)

public class AddProductToCartNewTest extends BaseClass {
	 @Test(groups ="SmokeSuite")
	 public void tc_01_AddProductTocartTest() throws IOException
	 {
			// Read data from excel File
			String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);// has to be added to cart-run time datat
		
			//click on product
			InventoryPage ip = new InventoryPage(driver);
			ip.clickOnAProduct(driver, PRODUCTNAME);
			
			//Add Product to cart
			InventoryItemPage iip = new InventoryItemPage(driver);
			iip.clickOnAddToCartBtn();
			
			//Click on cart container
			ip.clickOnCartContainer();
			
			//Validate in cart
			CartPage cp = new CartPage(driver);
			String productInCart = cp.getItemName();
			Assert.assertEquals(productInCart, PRODUCTNAME);
			System.out.println(productInCart);
			/*
			 * if(productInCart.equals(PRODUCTNAME)) { System.out.println("pass");
			 * System.out.println(productInCart); } else { System.out.println("fail"); }
			 */
			
		}

		@Test
		public void sampleTest()
		{
			//Assert.fail();
			System.out.println("Sample");
		}


}
