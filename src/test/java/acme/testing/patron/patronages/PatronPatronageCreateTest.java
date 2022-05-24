package acme.testing.patron.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronPatronageCreateTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status,final String code, final String legalStuff, 
		final String budget, final String initial, final String end, final String link, final String inventorId) {
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "My patronages");
		
		super.checkListingExists();
		super.clickOnButton("Create");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("initial", initial);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("link", link);
		
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"inventorId_proxy\"]/option[" + inventorId +"]")).click();
		
		super.clickOnSubmit("Create");

		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, budget);
		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("initial", initial);
		super.checkInputBoxHasValue("end", end);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String status,final String code, final String legalStuff, 
		final String budget, final String initial, final String end, final String link, final String inventorId) {

		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "My patronages");
		super.clickOnButton("Create");
		super.checkFormExists();

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("initial", initial);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("link", link);
		
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"inventorId_proxy\"]/option[" + inventorId +"]")).click();
		
		super.clickOnSubmit("Create");

		super.checkErrorsExist();
		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		
		super.checkNotLinkExists("Account");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();

		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();
		super.signOut();
	}

}