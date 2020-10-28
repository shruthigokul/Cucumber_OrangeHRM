package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import setUp.driverSetUp;

public class orangeHRMStepDefn extends driverSetUp{
		 WebDriver driver = driverSetUp.settingUp();
		 WebDriverWait wait;
 
		 @Given ("^user is on orangeHRM page with url \"(.*)\"$")
		 public void accessOrangeHRM(String url) {
			 driver.get(url);
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 }
		 
		 @When ("^user enters id \"(.*)\" and password \"(.*)\"$")
		 public void enterValidCredentials(String id, String pwd) {
			 driver.findElement(By.id("txtUsername")).sendKeys(id);
			 driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		 }
		 
		 @Then ("^user logs in$")
		 public void login() {
			 driver.findElement(By.id("btnLogin")).click();
		 }
		 
		 //SCENRIO 1, 4
	     @Given ("^User navigates to Recruitment page$")
	     public void navigateToRecruitment() {
	    	 driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
	    	 driver.findElement(By.xpath("//b[contains(text(),'Recruitment')]")).click();
	    	 //driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/recruitment/viewCandidates");
		 }
		 
	     @When ("^User clicks on the Vacancies menu item$")
	     public void clickVacancies() {
	    	 driver.findElement(By.linkText("Vacancies")).click();
		 }
		 
	     @And ("^User clicks Add job vacancy button$")
	     public void clickAddJobVacancy() {
	    	 driver.findElement(By.id("btnAdd")).click();
		 }
		 
	     @And ("^user fills out Add Job Vacancy form with title \"(.*)\",vacany \"(.*)\", manager \"(.*)\"$")
	     public void addJobVacancy(String title, String vacany, String manager) {
			 Select s = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
			 s.selectByVisibleText(title);
			 driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacany);
			 driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(manager);
		 }
		 
	     @And ("^User clicks save job vacancy button$")
	     public void saveJobVacancy() {
	    	 driver.findElement(By.id("btnSave")).click();
		 }
		 
	     @Then ("^User checks if Vacancy with title \"(.*)\",vacanyID \"(.*)\", managerID \"(.*)\" is successfully created$")
	     public void verifyIfVacancyAdded(String title, String vacany, String manager) {
	    	 driver.findElement(By.linkText("Vacancies")).click();
	    	 Select s1 = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
	    	 Select s2 = new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
	    	 Select s3 = new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
	    	 
	    	 s1.selectByVisibleText(title);
	    	 s2.selectByValue(vacany);
	    	 s3.selectByValue(manager);
	    	 
	    	 driver.findElement(By.id("btnSrch")).click();
	    	 
	    	 String jobName = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]")).getText();
	    	 
	    	 System.out.println("Successfully added job with name : " + jobName);
	     }
	     
	     //SCENARIO 2
	     @When ("^User clicks Add Candidate button$")
	     public void clickAddCandidate() {
	    	 driver.findElement(By.id("btnAdd")).click();
	     }
	     
	     @And ("^User fills out candidate details with firstName \"(.*)\", lastName \"(.*)\", email \"(.*)\"$")
	     public void fillCandidateDetails(String fName, String lName, String email) {
	    	 driver.findElement(By.id("addCandidate_firstName")).sendKeys(fName);
	    	 driver.findElement(By.id("addCandidate_lastName")).sendKeys(lName);
	    	 driver.findElement(By.id("addCandidate_email")).sendKeys(email);
		 }
	     
	     @And ("^User uploads resume$")
	     public void uploadResume() throws InterruptedException {
	    	 driver.findElement(By.id("addCandidate_email")).sendKeys("C:\\Users\\XMT5NJV\\Downloads\\resume.docx");
	    	 Thread.sleep(3000);
		 }
	     
	     @And ("^User clicks save candidate button$")
	     public void saveCandidate() {
	    	 driver.findElement(By.id("btnSave")).click();
		 }
	     
	     @Then ("^User checks if candidate with name \"(.*)\" was saved$")
	     public void verifyIfCandidateIsAdded(String name) {
	    	 driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
	    	 driver.findElement(By.id("candidateSearch_candidateName")).sendKeys(name);
	    	 String candidateName = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[3]/a")).getText();
	    	 System.out.println("Name of the candidate saved is " + candidateName);
		 }
	     
	     //SCENARIO 3
	     @Given ("^User navigates to PIM page$")
	     public void navigateToPIM() {
	    	 driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
	    	 driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
	    	 //driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewEmployeeList");
		 }
		 
	     @And ("^User clicks Add Employee button$")
	     public void clickAddEmployee() {
	    	 driver.findElement(By.id("btnAdd")).click();
		 }
		 
	     @And ("^User fills out employee details with firstName \"(.*)\", lastName \"(.*)\"$")
	     public void enterEmployeeName(String fName, String lName) {
	    	 driver.findElement(By.id("firstName")).sendKeys(fName);
	    	 driver.findElement(By.id("lastName")).sendKeys(lName);
		 }
		 
	     @And ("^User checks Create Login Details$")
	     public void checkCreateLogin() {
	    	 driver.findElement(By.id("chkLogin")).click();
		 }
	     
	     @And ("^User fills out login details with userName \"(.*)\"$")
	     public void enterEmployeeUname(String uName) {
	    	 driver.findElement(By.id("user_name")).sendKeys(uName);
		 }
	     
	     @And ("^User clicks save employee button$")
	     public void saveEmployee() {
	    	 driver.findElement(By.id("btnSave")).click();
		 }
		 
	     @Then ("^User checks if employee was added$")
	     public void verifyIfEmployeeAdded() {
	    	 String firstName = null;
	    	 String lastName = null;
	    	 if (driver.findElement(By.xpath("//*[@id='pdMainContainer']/div[1]/h1")).isDisplayed() == true) {
	    		 firstName = driver.findElement(By.id("personal_txtEmpFirstName")).getText();
		    	 lastName = driver.findElement(By.id("personal_txtEmpLastName")).getText();
	    	 }
	    	 System.out.println("Employee with name "+ firstName + " "+ lastName +" was added");
	     }
	     
	     
	     @After
	     public void closeOpenBrowser() {
	     	//driver.close();
	     }
}
