package it.davidecaruso;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.davidecaruso.exercise.impl.Good;
import it.davidecaruso.exercise.impl.ImportedGood;
import it.davidecaruso.exercise.impl.ShoppingCart;
import it.davidecaruso.exercise.interfaces.IGood;
import it.davidecaruso.exercise.interfaces.IShoppingCart;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
	  private IGood exemptLocal;
	  private IGood exemptImported;
	  private IGood taxedLocal;
	  private IGood taxedImported;
	  

	  private void setUpProducts() {
		    exemptLocal = new Good("book", new BigDecimal(12.49), true);
		    exemptImported = new ImportedGood("box Of Chocolates", new BigDecimal(10.00), true);
		    taxedLocal = new Good("Music CD", new BigDecimal(14.99), false);
		    taxedImported = new ImportedGood("bottle Of Perfume", new BigDecimal(47.50), false);
	}	  
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        setUpProducts();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
        purchase_Exempt_Local_Product();
        purchase_Exempt_Imported_Product();
        purchase_Taxed_Local_Product();
        purchase_Taxed_Imported_Product();
        purchase_all();
    }
    
    
    public void purchase_Exempt_Local_Product() {
    	IShoppingCart cart = new ShoppingCart("Purchase_Exempt_Local_Product");
		cart.addItem(exemptLocal);
		cart.checkout();
		assertEquals(new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP), cart.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP), cart.getTotalTaxes().setScale(2, RoundingMode.HALF_UP));		
		assertEquals(new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP), cart.getTotalPriceWithTaxes().setScale(2, RoundingMode.HALF_UP));
    }
    
    public void purchase_Exempt_Imported_Product() {
    	
    	IShoppingCart cart = new ShoppingCart("Purchase_Exempt_Imported_Product");
		cart.addItem(exemptImported);
		cart.checkout();
		assertEquals(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP), cart.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP), cart.getTotalTaxes().setScale(2, RoundingMode.HALF_UP));		
		assertEquals(new BigDecimal(10.50).setScale(2, RoundingMode.HALF_UP), cart.getTotalPriceWithTaxes().setScale(2, RoundingMode.HALF_UP));
    }
    
    public void purchase_Taxed_Local_Product() {
    	IShoppingCart cart = new ShoppingCart("Purchase_Taxed_Local_Product");
		cart.addItem(taxedLocal);
		cart.checkout();
		assertEquals(new BigDecimal(14.99).setScale(2, RoundingMode.HALF_UP), cart.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(1.5).setScale(2, RoundingMode.HALF_UP), cart.getTotalTaxes().setScale(2, RoundingMode.HALF_UP));		
		assertEquals(new BigDecimal(16.49).setScale(2, RoundingMode.HALF_UP), cart.getTotalPriceWithTaxes().setScale(2, RoundingMode.HALF_UP));
    }
    
    public void purchase_Taxed_Imported_Product() {
    	IShoppingCart cart = new ShoppingCart("Purchase_Taxed_Imported_Product");
		cart.addItem(taxedImported);
		cart.checkout();
		assertEquals(new BigDecimal(47.50).setScale(2, RoundingMode.HALF_UP), cart.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(7.15).setScale(2, RoundingMode.HALF_UP), cart.getTotalTaxes().setScale(2, RoundingMode.HALF_UP));		
		assertEquals(new BigDecimal(54.65).setScale(2, RoundingMode.HALF_UP), cart.getTotalPriceWithTaxes().setScale(2, RoundingMode.HALF_UP));
    }    
    
    public void purchase_all() {
    	IShoppingCart cart = new ShoppingCart("Purchase_all");
    	cart.addItem(taxedImported);
    	cart.addItem(taxedLocal);
    	cart.addItem(exemptImported);
    	cart.addItem(exemptLocal);
    	cart.checkout();
		assertEquals(new BigDecimal(84.98).setScale(2, RoundingMode.HALF_UP), cart.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal(9.15).setScale(2, RoundingMode.HALF_UP), cart.getTotalTaxes().setScale(2, RoundingMode.HALF_UP));		
		assertEquals(new BigDecimal(94.13).setScale(2, RoundingMode.HALF_UP), cart.getTotalPriceWithTaxes().setScale(2, RoundingMode.HALF_UP));    	
    }
    
}
