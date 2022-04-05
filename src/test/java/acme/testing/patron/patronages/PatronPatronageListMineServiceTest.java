package acme.testing.patron.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListMineServiceTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff,
		final String budget, final String initial, final String creation, final String end, final String link,
		final String inventorProfileFullName, final String inventorProfileEmail) {
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, budget);
		super.checkColumnHasValue(recordIndex, 3, creation);
		super.clickOnListingRecord(recordIndex);
		
        super.checkFormExists();
        super.checkInputBoxHasValue("status", status);
        super.checkInputBoxHasValue("code", code);
        super.checkInputBoxHasValue("legalStuff", legalStuff);
        super.checkInputBoxHasValue("budget", budget);
        super.checkInputBoxHasValue("initial", initial);
        super.checkInputBoxHasValue("creation", creation);
        super.checkInputBoxHasValue("end", end);
        super.checkInputBoxHasValue("link", link);
        super.checkInputBoxHasValue("inventorProfileFullName", inventorProfileFullName);
        super.checkInputBoxHasValue("inventorProfileEmail", inventorProfileEmail);
		
        super.signOut();
	}
}
