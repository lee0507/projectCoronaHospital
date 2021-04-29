package projectCoronaHospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class GetDataClass {
	public Scanner scan = new Scanner(System.in); 
	public String[][] getData() throws IOException {
		ArrayList<String> cHospital = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("D:\\corona\\국민안심병원_20210405174843.csv"));

		String line;
		int cnt = 0;
		while((line = reader.readLine()) != null) {
			if(cnt >= 3) {
				cHospital.add(line);
			}
			cnt++;
		}
		
		String[][] cHosp = new String[cHospital.size()][];
		for(int i = 0; i < cHospital.size(); i++) {
			cHosp[i] = cHospital.get(i).split(",");
		}
		
		return cHosp;
	}
	
	public String getCity(String[][] cHos) {
		HashSet<String> City = new HashSet<String>();
		
		for (int i = 0; i < cHos.length; i++) {
			City.add(cHos[i][1]);
		}
			
		ArrayList<String> city = new ArrayList<String>(City); // change to ArrayList
		Collections.sort(city);
		
		String str;
		System.out.println("====집 근처 코로나 병원 찾기====");
		for (int i = 0; i < city.size(); i++) {
			System.out.println((i+1) + "." + city.get(i));
		}
		
		int choice = scan.nextInt();
		str = city.get(choice - 1);
		return str;

	}
	
	public String getDist(String[][] cHos, String str) {
		HashSet<String> District = new HashSet<String>();
		
		for (int i = 0; i < cHos.length; i++) {
			if(cHos[i][1].contains(str)) {
				District.add(cHos[i][2]);
			}
		}
			
		ArrayList<String> dist = new ArrayList<String>(District); // change to ArrayList
		Collections.sort(dist);
		String str1;
		for (int i = 0; i < dist.size(); i++) {
			System.out.println((i+1) + "." + dist.get(i));
		}
		
		int choice = scan.nextInt();
		str1 = dist.get(choice - 1);
		
		return str1;

	}
	
	public void getHosp(String[][] cHos, String str, String str1) {
		ArrayList<String> hospital = new ArrayList<String>(); // change to ArrayList
		
		for(int i = 0; i < cHos.length; i++) {
			if(cHos[i][5].equals("A")) {
				cHos[i][5] = "외래진료";
			} else if(cHos[i][5].equals("B")) {
				cHos[i][5] = "외래진료 및 입원";
			}
		}
		
		for (int i = 0; i < cHos.length; i++) {
			hospital.add(cHos[i][3] + " / " + cHos[i][4] + " / " + cHos[i][5] + " / " + cHos[i][6]);
		}
		
		for (int i = 0; i < hospital.size(); i++) {
			if(hospital.get(i).contains(str) && hospital.get(i).contains(str1)) {
				System.out.println(hospital.get(i));
			}
		}
		System.out.println("");

	}

}

