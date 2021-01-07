package testMobile;

import io.appium.java_client.android.AndroidDriver;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

    public class CalcTest {

        private AndroidDriver<MobileElement> driver;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("automationName", "UIAutomator2");
            desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
            desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        }

        @Test
        public void multiplicacao() {
            MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
            btn3.click();
            MobileElement btnmultiplicacao = (MobileElement) driver.findElementByAccessibilityId("multiply");
            btnmultiplicacao.click();
            MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
            btn9.click();
            MobileElement btnigual = (MobileElement) driver.findElementByAccessibilityId("equals");
            btnigual.click();
            // Validacao
            MobileElement visor = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
            visor.getText();
        }

        @Test
        public void subtracao() {

            MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
            btn9.click();
            MobileElement btnmenos = (MobileElement) driver.findElementByAccessibilityId("minus");
            btnmenos.click();
            MobileElement btn6 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_6");
            btn6.click();
            MobileElement btnigual = (MobileElement) driver.findElementByAccessibilityId("equals");
            btnigual.click();
            //Validacao
            MobileElement visor = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
            visor.getText();
        }



        @After
        public void tearDown() {
            driver.quit();
        }
    }


