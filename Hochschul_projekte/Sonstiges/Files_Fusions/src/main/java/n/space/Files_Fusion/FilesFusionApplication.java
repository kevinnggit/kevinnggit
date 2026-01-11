package n.space.Files_Fusion;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilesFusionApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FilesFusionApplication.class, args);

		Empfang empfang = new Empfang();
		List<String> pfad = new ArrayList<String>();
		pfad = empfang.verification();

		DateiExist dateiExist = new DateiExist();
		dateiExist.exist(pfad);
		dateiExist.lesen();
		//Read_files lese = new Read_files();
		//System.out.println(lese);

		/*System.out.println("Name der Datei 1 eingeben");
        String dat1 = sc.nextLine();
		fileNames.add(dat1);

		System.out.println("Name der Datei 2 eingeben");
        String dat2 = sc.nextLine();
		fileNames.add(dat2);*/

        //Empfang empfang = new Empfang();
		//List<String> namen = empfang.verification();
		// System.out.println("Pfad eingeben");
		// Scanner sb = new Scanner(System.in);
		// String route = sb.nextLine();

        // File file = new File(route);

		// File line;
		// Scanner sc = new Scanner(file);

		// while (sc.hasNextLine()) {
		// 	String data = sc.nextLine();
		// 	System.out.println(data);
		// }
		// System.out.println("End of reading file");
	}

}
