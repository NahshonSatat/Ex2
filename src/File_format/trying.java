package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class trying {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\אליהו סתת\\Desktop\\game_1543684662657.csv"));
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		String[] s = br.readLine().split(",");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		br.close();
	}

}
