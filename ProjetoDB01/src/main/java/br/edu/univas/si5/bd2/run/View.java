package br.edu.univas.si5.bd2.run;

public class View {
	
	public void menu() {
		System.out.println("Choose and type a option:" + "\n" + "\n" +
							"1- Persistence" + "\n" + "\n" +
							"2- Update" + "\n" + "\n" +
							"3- Delete" + "\n" + "\n" +
							"4- Consult" + "\n");
	}
	
	public void chooseWrong() {
		System.out.println("You select wrong choice, please run again.");
	}

}
