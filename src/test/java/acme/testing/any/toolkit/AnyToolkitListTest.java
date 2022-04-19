package acme.testing.any.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyToolkitListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String title, final String description,
		final String assembleNotes, final String link,final String published, final String toolkitPrice) {
		super.clickOnMenu("Any", "List possible toolkits");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assembleNotes", assembleNotes);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("published", published);
		super.checkInputBoxHasValue("toolkitPrice", toolkitPrice);
	}
}