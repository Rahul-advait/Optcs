package PageClasses;

import Base.BasePage;
import Utilities.Constants;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePage {
    protected WebDriver driver;
    private String URL = "register";
    private String NAME = "id=>name";
    private String EMAIL = "id=>email";
    private String PASSWORD = "id=>password";
    private String CONFIRM_PASS = "id=>password_confirmation";
    private String COMPANY_NAME = "id=>company_name";
    private String WORK_EMAIL = "id=>work_email";
    private String TOTAL_EMP = "id=>total_emp";
    private String DOMAIN_SECTOR = "id=>domain_sector";
    private String USERNAME = "id=>username";
    private String CREATE_ACCOUNT = "cssSelector=>form .login_btn";

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        return isOpen(URL);
    }

    private void registerAccount(String name, String email, String password, String confirmPas, String companyName,
                                String workEmail, String totalEmp, String domainSector, String username) {
        sendData(NAME, name, "Name", true);
        sendData(EMAIL, email, "Email Address", true);
        sendData(PASSWORD, password, "Password", true);
        sendData(CONFIRM_PASS, confirmPas, "Confirm Password", true);
        sendData(COMPANY_NAME, companyName, "Company Name", true);
        sendData(WORK_EMAIL, workEmail, "Work Email", true);
        sendData(TOTAL_EMP, totalEmp, "Total Employees", true);
        sendData(DOMAIN_SECTOR, domainSector, "Domain Sector", true);
        sendData(USERNAME, username, "Username", true);
        javascriptScrollToView(CREATE_ACCOUNT, "CREATE_ACCOUNT btn");
        javascriptClick(CREATE_ACCOUNT, "Create Account btn");
    }

    public void registerAccount() {
        registerAccountEmptyField("");
    }

    public void registerAccountEmptyField(String emptyField) {
        String name = Constants.getDefaultName();
        String email = Constants.getDefaultEmail();
        String password = Constants.getDefaultPassword();
        String confirmPassword = password;
        String companyName = Constants.getCompanyName();
        String workEmail = Constants.getDefaultWorkEmail();
        String totalEmployees = Constants.getTotalEmp();
        String domainSector = Constants.getCompanyDomain();
        String username = Constants.getDefaultUsername();

        switch (emptyField.toLowerCase()) {
            case "name" -> name = "";
            case "email" -> email = "";
            case "password" -> password = "";
            case "confirm password" -> confirmPassword = "";
            case "company name" -> companyName = "";
            case "work email" -> workEmail = "";
            case "total emp" -> totalEmployees = "";
            case "company domain" -> domainSector = "";
            case "username" -> username = "";
            case "" -> log.info("No Field should be empty");
            default -> {
                log.error("Invalid field passed to method");
            }

        }
        registerAccount(name, email, password, confirmPassword, companyName,
                workEmail, totalEmployees, domainSector, username);
    }


    public boolean isRegisterSuccessPage() {
        return isOpen("register-success");
    }
}

