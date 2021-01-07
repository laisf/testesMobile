package mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertEquals;

public class PetzApp {

        private AndroidDriver<MobileElement> driver;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            //local
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("automationName", "UIAutomator2");
            desiredCapabilities.setCapability("appPackage", "br.com.petz");
            desiredCapabilities.setCapability("appActivity", "br.com.hanzo.petz.view.MainActivity");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("autoGrantPermissions", true); //para pop up

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");
          /*
            //nuvem

            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("automationName", "UIAutomator2");
            desiredCapabilities.setCapability("appPackage", "br.com.petz");
            desiredCapabilities.setCapability("appActivity", "br.com.hanzo.petz.view.MainActivity");
            desiredCapabilities.setCapability("platformVersion", "10.0");
            desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("autoGrantPermissions", true); //para pop up
            desiredCapabilities.setCapability("testobject_api_key", "4C4CEF65B59948CA8F238F84667C97DC");

            URL remoteUrl = new URL("https://us1.appium.testobject.com/wd/hub");

           */

            driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);


        }

        @Test
        public void sampleTest() throws InterruptedException {
            MobileElement cxEmail = (MobileElement) driver.findElementById("br.com.petz:id/et_user_name");
            cxEmail.click();
            driver.findElementById("br.com.petz:id/et_user_name").sendKeys("cristianeemilly@maildrop.cc");
            MobileElement cxSenha = (MobileElement) driver.findElementById("br.com.petz:id/et_password");
            cxSenha.click();
            driver.findElementById("br.com.petz:id/et_password").sendKeys("GHHWc3X1ap");
            MobileElement btnEntrar = (MobileElement) driver.findElementById("br.com.petz:id/rl_do_login");
            btnEntrar.click();
            Thread.sleep(5000);
            MobileElement lupa = (MobileElement) driver.findElementByAccessibilityId("pesquisa");
            lupa.click();
            Thread.sleep(5000);
            MobileElement cxPesquisa = (MobileElement) driver.findElementById("br.com.petz:id/et_search");
            cxPesquisa.click();
            Thread.sleep(8000);
            cxPesquisa.sendKeys("petisco");
            cxPesquisa.click();
            Thread.sleep(8000);
            MobileElement produto = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView");
            produto.click();
            Thread.sleep(8000);
            MobileElement nomeProd = (MobileElement) driver.findElementById("br.com.petz:id/tv_prod_name");
            nomeProd.click();
            Thread.sleep(8000);
            MobileElement precoProd = (MobileElement) driver.findElementById("br.com.petz:id/tv_prod_main_price");
            precoProd.click();
            Thread.sleep(8000);

            //Validacao
            assertEquals("Petisco KelDog Cães Adultos Tekinhos - 500g", nomeProd.getText());
            assertEquals("20.49", precoProd.getText());


    }

        @After
        public void tearDown() {
           // driver.quit();
        }
    }

