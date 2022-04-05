package acme.testing.authenticated.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedUserAccountListAllTest extends TestHarness{

    // Lifecycle management ---------------------------------------------------

    // Test cases -------------------------------------------------------------
 
    @ParameterizedTest
    @CsvFileSource(resources = "/authenticated/user-account/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void positiveTest(final int recordIndex, final String roleList, final String username, final String name, final String surname, final String email) {

        super.signIn("administrator", "administrator"); 
        super.clickOnMenu("Authenticated", "List user accounts");
        super.checkListingExists();

        super.checkColumnHasValue(recordIndex, 0, roleList);

        super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
        super.checkInputBoxHasValue("username", username);
        super.checkInputBoxHasValue("identity.name", name);
        super.checkInputBoxHasValue("identity.surname", surname);
        super.checkInputBoxHasValue("identity.email", email);

        super.signOut();
    }


}