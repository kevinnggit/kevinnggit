package n.space.Files_Fusion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empfang {

	public List<String> verification() {

		Scanner sc = new Scanner(System.in);
		List<String> fileNames = new ArrayList<String>();

		for (int i = 1; i <= 2; i++) {
			System.out.println("Name der Datei " + i + " eingeben");
			String datei = sc.nextLine();
			fileNames.add(datei);
		}
		//sc.close();
		//System.out.println("file1 : " + fileNames.get(1));
		return fileNames;
	}
}
