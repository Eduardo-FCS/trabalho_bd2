package br.edu.univas.si5.bd2.run;

import java.util.Date;
import java.util.Scanner;

import br.edu.univas.si5.bd2.dao.AirplaneCRUD;
import br.edu.univas.si5.bd2.dao.AirplaneDetailCRUD;
import br.edu.univas.si5.bd2.dao.FlightsCRUD;
import br.edu.univas.si5.bd2.entities.Airplane;
import br.edu.univas.si5.bd2.entities.AirplaneDetail;
import br.edu.univas.si5.bd2.entities.Flights;

public class App {

	public static View view = new View();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		view.menu();
		int choose = scanner.nextInt();
		if (choose == 1) {
			runPersist();
		} else if (choose == 2) {
			runUpdate();
		} else if (choose == 3) {
			runDelete();
		} else if (choose == 4) {
			runConsult();
		} else {
			view.chooseWrong();
		}
	}

	public static void runPersist() {
		Airplane airplane = new Airplane();
		AirplaneDetail detail = new AirplaneDetail();
		Flights fly = new Flights();
		AirplaneCRUD airplaneCRUD = new AirplaneCRUD();
		AirplaneDetailCRUD detailCRUD = new AirplaneDetailCRUD();
		FlightsCRUD flyCRUD = new FlightsCRUD();

		detail.setRecord("PT-ESA");
		detail.setManufacturer("Airbus");
		detail.setModel("A320");
		detail.setCapacity(200);
		detailCRUD.persist(detail);

		airplane.setMaintenance(new Date());
		airplane.setRecord_detail(detail);
		airplaneCRUD.persist(airplane);

		fly.setTime(new Date());
		fly.setPilot("Pete Maverick");
		fly.setId_airplane(airplane);
		flyCRUD.persist(fly);
	}

	public static void runUpdate() {
		AirplaneCRUD airplaneCRUD = new AirplaneCRUD();
		AirplaneDetailCRUD detailCRUD = new AirplaneDetailCRUD();
		FlightsCRUD flyCRUD = new FlightsCRUD();

		String record_detail = "PT-ESA";
		AirplaneDetail detail = detailCRUD.consult(record_detail);
		detail.setCapacity(120);
		detailCRUD.update(detail);

		int id_airplane = 1;
		Airplane airplane = airplaneCRUD.consult(id_airplane);
		airplane.setMaintenance(new Date());
		airplaneCRUD.update(airplane);

		int id_fly = 1;
		Flights fly = flyCRUD.consult(id_fly);
		fly.setPilot("Tom Kazanksy");
		flyCRUD.update(fly);

	}

	public static void runDelete() {
		AirplaneCRUD airplaneCRUD = new AirplaneCRUD();
		AirplaneDetailCRUD detailCRUD = new AirplaneDetailCRUD();
		FlightsCRUD flyCRUD = new FlightsCRUD();

		int id_fly = 1;
		flyCRUD.delete(id_fly);

		int id_airplane = 1;
		airplaneCRUD.delete(id_airplane);

		String record_detail = "PT-ESA";
		detailCRUD.delete(record_detail);

	}

	public static void runConsult() {
		AirplaneCRUD airplaneCRUD = new AirplaneCRUD();
		AirplaneDetailCRUD detailCRUD = new AirplaneDetailCRUD();
		FlightsCRUD flyCRUD = new FlightsCRUD();

		String record_detail = "PT-ESA";
		detailCRUD.consult(record_detail);

		int id_airplane = 1;
		airplaneCRUD.consult(id_airplane);

		int id_fly = 1;
		flyCRUD.consult(id_fly);
	}

}
