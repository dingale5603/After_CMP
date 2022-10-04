package utils;


import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;



import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;



   public class SuitListiner implements ITestListener,IAnnotationTransformer {
	 public void onTestFailure(ITestResult result)  {
		   try {
			ScreenShot.screeshot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			}
		  
	 public void transform( ITestAnnotation annotation,Class testClass, Constructor testConstructor, Method testMethod) {
		   annotation.setRetryAnalyzer(Retryanalyser.class);
		  }
	 
}
