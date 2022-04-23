package utility;

import java.io.IOException;;

public class MainExcel {

	// TODO Auto-generated constructor stub
	public static void main(String[] args) throws IOException {
		ExcelRead1 er = new ExcelRead1();
		MainExcel me = new MainExcel();

		for (int i = 0; i < er.rowsize(); i++) {
			for (int j = 0; j < 2; j++) {

				String value = er.readData(i, j);
				System.out.println(value);
			}
		}

	}
}
