package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanov@gmail.com")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthDate("08", "December", "1995")
                .setSubjects("Maths")
                .setHobbies("Music")
                .uploadPicture("img.png")
                .setCurrentAddress("Some address")
                .setStateAndCity("NCR", "Noida")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivanov@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "08 December,1995")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "img.png")
                .checkResult("Address", "Some address")
                .checkResult("State and City", "NCR Noida");
    }
}
