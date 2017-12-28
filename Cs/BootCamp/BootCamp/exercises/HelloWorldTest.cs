using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace BootCamp
{
    [TestClass]
    public class HelloWorldTest
    {
        [TestMethod]
        public void PrintText()
        {
            Console.WriteLine("Hello World!");
        }
    }
}