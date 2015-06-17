package com.example.fw;
import java.io.IOException;
import java.util.Properties;

public class ProcessHelper extends HelperBase {

	private Process process;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}

	public void startAppUnderTest() throws IOException {
		String command = manager.getProperty("app.path");
		process = Runtime.getRuntime().exec(command);
	}
	
	public void stopAppUnderTest() {
		process.destroy();
		
	}
}