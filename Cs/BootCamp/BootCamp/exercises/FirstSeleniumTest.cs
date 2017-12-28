using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace BootCamp
{
    [TestClass]
    public class FirstSeleniumTest
    {
        String url = "https://techblog.polteq.com/testshop/index.php";
        String username = "roel.vandenassem@polteq.com";
        String password = "Bootcamp";

        [TestMethod]
        public void LogInSuccesful()
        {

            //String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders";

            IWebDriver driver = new ChromeDriver();

            // navigate to url, click on login button, fill out username and password field and click on submit login button.
            driver.Manage().Window.Maximize();
            driver.Url = url;
            driver.FindElement(By.ClassName("login")).Click();
            driver.FindElement(By.Id("email")).SendKeys(username);
            driver.FindElement(By.Id("passwd")).SendKeys(password);
            driver.FindElement(By.Id("SubmitLogin")).Click();
            String pageHeaderText = driver.FindElement(By.ClassName("page-heading")).Text;
            Assert.AreEqual(pageHeaderText, "MY ACCOUNT", "Text on My Account page is not correct.");
            driver.Quit();
        }
    }
}
