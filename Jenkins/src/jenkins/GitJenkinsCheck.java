package jenkins;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GitJenkinsCheck {
	
	@Test
	public void printMsg() {
		Reporter.log("Hello World", true);
	}

}
