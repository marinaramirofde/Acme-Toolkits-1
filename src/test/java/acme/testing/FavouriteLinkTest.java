/*
 * FavouriteLinkTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class FavouriteLinkTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@Test
	@Order(10)
	public void favouriteLink() {
		super.navigateHome();
		super.clickOnMenu("Anonymous", "45972333W: Álvarez Campanón, Juan José");		
		super.checkCurrentUrl("http://www.lsi.us.es");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "30238243M: Cordero Díaz, Jesús Javier");		
		super.checkCurrentUrl("http://www.lsi.us.es");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "29552922S: Paz Rivera, Roberto");		
		super.checkCurrentUrl("https://github.com");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "49129488Q: Romalde Dorado, Miguel Angel");		
		super.checkCurrentUrl("https://github.com");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "29566855X: Sánchez Mendoza, Nicolás");		
		super.checkCurrentUrl("http://www.lsi.us.es");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "77925380T: Suárez David, Rubén");		
		super.checkCurrentUrl("https://github.com");
	}
	
	// Ancillary methods ------------------------------------------------------ 
	
}
