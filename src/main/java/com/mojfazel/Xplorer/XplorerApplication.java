package com.mojfazel.Xplorer;

import com.mojfazel.Xplorer.HelperMethods.Helpers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class XplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XplorerApplication.class, args);
		String path = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\nPlease enter a valid path (or type 'exit' to exit)");
			path = scanner.nextLine();
			if (path.equals("exit")) {
				System.out.println("Thank you for using my application!");
				scanner.close();
				return;
			} else {
				Helpers.init(path);
			}
		}
	}

}

