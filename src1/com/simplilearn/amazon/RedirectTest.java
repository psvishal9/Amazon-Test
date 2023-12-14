
		package com.simplilearn.amazon;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;

		public class RedirectTest {
			
			static WebDriver driver = null;

			
			public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
				
				// step1: formulate a test domain url & driver path
						String siteUrl = "https://www.amazon.in/";
						String driverPath = "drivers/windows/geckodriver.exe";

						// step2: set system properties for selenium dirver
						System.setProperty("webdriver.geckodriver.driver", driverPath);

						// step3: instantiate selenium webdriver
						driver = new FirefoxDriver();

						// step4: launch browser
						driver.get(siteUrl);

						testSearch();
						
						mobileLinkTest1();
						
						tdLinkTest2();
						
						//Thread.sleep(2000);
						
						driver.close();
					}

					/**
					 * Search for a product.
					 * @throws InterruptedException 
					 */
					private static void testSearch() throws InterruptedException {

						WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
						searchBox.sendKeys("Iphone 14");
						searchBox.submit();

						// add delay 
						Thread.sleep(2000);
						
						String expectedTitle = "Amazon.in : Iphone 14";
						String actualTitle = driver.getTitle();

						if (expectedTitle.equals(actualTitle)) {
							System.out.println("Test is Passed !");
						} else {
							System.out.println("Test is Failed !");
						}

						System.out.println("Expected Title : " + expectedTitle);
						System.out.println("Actual Title : " + actualTitle);
					}
						
					
						// Relative Xpath
						public static void mobileLinkTest1() {

							WebElement mobileLink = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));

							System.out.println("Is link loaded :: " + mobileLink.isDisplayed());
							System.out.println("Is link is enabled :: " + mobileLink.isEnabled());

							mobileLink.click();

							String expectedTitle = "Apple iPhone 14 (128 GB) - Yellow : Amazon.in : Electronics";
							String actualTitle = driver.getTitle();

							if (expectedTitle.equals(actualTitle)) {
								System.out.println("Test is Passed !");
							} else {
								System.out.println("Test is Failed !");
							}

							System.out.println("Expected Title : " + expectedTitle);
							System.out.println("Actual Title : " + actualTitle);
						}

						
						// Relative Xpath
						public static void tdLinkTest2() {

							WebElement tdLink = driver.findElement(By.xpath("//*[@id=\"dp-container\"]"));

							System.out.println("Is link loaded :: " + tdLink.isDisplayed());
							System.out.println("Is link is enabled :: " + tdLink.isEnabled());

							tdLink.click();

							String expectedTitle = "Apple iPhone 14 (128 GB) - Yellow : Amazon.in : Electronics";
							String actualTitle = driver.getTitle();

							if (expectedTitle.equals(actualTitle)) {
								System.out.println("Test is Passed !");
							} else {
								System.out.println("Test is Failed !");
							}

							System.out.println("Expected Title : " + expectedTitle);
							System.out.println("Actual Title : " + actualTitle);
	}

}
