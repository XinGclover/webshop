package jpa;

public class GenerateDatabaseData {
//	public static void main(String[] args) {
//		GenerateDatabaseData db = new GenerateDatabaseData();
//	}

	private EJBControllerDemo ejb;
	Customers[] customerList;

	public GenerateDatabaseData() {
		ejb = new EJBControllerDemo();
		
		run();
	}

	private void run() {

		for (int i = 0; i < 19; i++) {
			Customers c = customerList[i];
			ejb.create(c);
		}
	}

}
