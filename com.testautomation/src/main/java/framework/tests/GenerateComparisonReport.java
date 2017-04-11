package framework.tests;

import java.nio.file.Paths;
import java.text.ParseException;
import utilities.ReportFactoryDB;
/**
 * Used to generate comparison report
 *
 */
public class GenerateComparisonReport {
	
	private GenerateComparisonReport(){
		
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		ReportFactoryDB.switchOn();

		ReportFactoryDB.initSqlite(Paths.get("").toAbsolutePath().toString() + "\\ExecutionReports\\DB");

		ReportFactoryDB.getComparisonReport("Previous Execution Results");

		ReportFactoryDB.closeDBConnection();
	}

}
