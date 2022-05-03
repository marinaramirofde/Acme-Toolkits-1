package acme.testing.patron.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageUpdateTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff,
		final String budget, final String initial, final String creation, final String end, final String link,
		final String inventorCompany, final String inventorStatement, final String inventorLink) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("initial", initial);
		super.fillInputBoxIn("end", end);
		super.fillInputBoxIn("link", link);
		super.checkInputBoxHasValue("inventorCompany", inventorCompany);
		super.checkInputBoxHasValue("inventorStatement", inventorStatement);
		super.checkInputBoxHasValue("inventorLink", inventorLink);
		super.clickOnSubmit("Update");
		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT+ a) update an patronage with a role other than "Patron";
	}

}
