package pl.pkrakowiak.service;

public class DBService {

	public static void dumpSQL() throws Exception {
		String username = "root";
		String password = "coderslab";
		String dbname = "ExamsDB";

		String command = "mysqldump -u " + username + " -p" + password + " " + dbname
				+ " > /home/pkrakowiak/backup.sql";
		System.out.println(command);
		Runtime.getRuntime().exec(command);

	
	}
}
