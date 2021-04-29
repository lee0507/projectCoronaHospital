package projectCoronaHospital;

import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		GetDataClass gd = new GetDataClass();
		
		while(true) {
			String yc = gd.getCity(gd.getData());
			String yc1 = gd.getDist(gd.getData(), yc);
			gd.getHosp(gd.getData(), yc, yc1);
			
			}
		}
	}

