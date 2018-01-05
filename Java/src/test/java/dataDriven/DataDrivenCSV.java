package dataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataDrivenCSV {

    @Test
    public static void main( String[] args) {

        File csvFile = new File( "C:/Bootcamp/Java/src/test/java/dataDriven/DataDrivenTestCSV.csv" );

        String cvsSplitBy = ",";
        try ( final Scanner scanner = new Scanner(csvFile)) {
            while (scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                List lineList = new ArrayList(line.split(cvsSplitBy));
                System.out.println(lineList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


    public Object [][] provider() {
        Object[][] returnObject;

        String[] checkpoint = ReadfromCSV();

        count = count + 1;

        returnObject = new Object[][]{checkpoint};
        return returnObject;
    }

    @DataProvider(name = "submitContactForm")
    File CSVfile = new ("C:/Bootcamp/Java/src/test/java/dataDriven/DataDrivenTestCSV.csv")
    FileReader fileReader = new FileReader("C:/Bootcamp/Java/src/test/java/dataDriven/DataDrivenTestCSV.csv");

    public static (String csvFile) throws FileNotFoundException


    public void main(String[] args) {

            String csvFile = "/DataDrivenTestCSV.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";

            try {

                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);

                    System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
