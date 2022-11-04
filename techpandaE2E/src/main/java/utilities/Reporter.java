package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public abstract class Reporter extends AbstractTestNGCucumberTests {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test, node;
	public Properties prop;
	protected static File file;
	
	public String testCaseName, testDescription, nodes, authors,category, propname;
	public String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		file = new File("./reports/Results_"+date);
		if(!file.exists()) {
			System.out.println("Exists? "+file.exists());
			file.mkdir();
		}
		String date1 = new SimpleDateFormat("HH.mm.ss").format(new Date());
		spark = new ExtentSparkReporter(file.toString()+"./result_"+date1+".html");
		ExtentSparkReporter sparkFail = new ExtentSparkReporter("reports/SparkFail.html").filter().statusFilter().as(new Status[]{ Status.FAIL }).apply();
		spark.config().setDocumentTitle("TEST REPORT");
		spark.config().setReportName("AUTOMATION DASHBOARD"); 
		spark.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(spark, sparkFail);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testCaseName);
		test.assignAuthor(authors);
		test.assignCategory(category);  
	}
    
    public abstract long takeSnap();
    public void reportStep(String dec, String status,boolean bSnap ) {
    	Media img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000L;
			snapNumber = takeSnap();
			String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
			String date1 = new SimpleDateFormat("HH.mm").format(new Date());
			img = MediaEntityBuilder.createScreenCaptureFromPath("./../Screenshots/"+date+"/"+ date1 +"_"+snapNumber+".jpg").build();
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img);
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    @AfterSuite(alwaysRun = true)
    public void stopReport() {
    	extent.flush();
    }
}














