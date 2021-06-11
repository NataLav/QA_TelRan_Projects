package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.event().isContainerPresent()) {
            app.user().login("nata1234@gmail.com", "Nata12345678");
        }
    }

    @Test
    public void eventCreationTest() {
        app.event().initEventCreation();
        app.event().tapOnPencilButton();
        app.event().fillInTitleForm("Dentist");
        app.event().fillInTypeForm("Termin");
        app.event().hideKeyboard();
        //app.event().fillInTimeRangeForm();
        app.event().fillInBreakForm(3);
        app.event().fillInWageForm();
        app.event().hideKeyboard();
        app.event().tapOnSaveButton();
    }


    @Test
    public void eventCreationTestWithSwipeLeftAndDateToChoose() {
        app.event().initEventCreation();
        app.event().tapOnPencilButton();
        app.event().selectDate("future","July", "21");
        app.event().fillInTitleForm("Therapeutic Massage for Babies");
        app.event().fillInTypeForm("Appointment");
        app.event().hideKeyboard();
        //app.event().fillInTimeRangeForm();
        app.event().fillInBreakForm(0);
        app.event().fillInWageForm();
        app.event().hideKeyboard();
        app.event().tapOnSaveButton();

        Assert.assertTrue(app.event().isEventPresent());
    }



}
