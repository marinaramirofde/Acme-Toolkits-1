package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListAllTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	
	public void positiveTest(final int recordIndex, final String patronageId, final String automaticSequenceNumber, final String creation, final String memorandum, final String link) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List all patronage reports");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, patronageId);
		super.checkColumnHasValue(recordIndex, 1, automaticSequenceNumber);
		super.checkColumnHasValue(recordIndex, 2, creation);
		super.checkColumnHasValue(recordIndex, 3, memorandum);
		super.checkColumnHasValue(recordIndex, 4, link);
		
		super.signOut();
	}
}
