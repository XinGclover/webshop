package inloging;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Admins;
import jpa.Customers;
import jpa.EJBControllerDemo;
//import jpa.GenericCrudService;

@Named(value = "test")
@SessionScoped
public class test implements Serializable {

	private final EJBControllerDemo ejb = new EJBControllerDemo();
//	@EJB
//	private GenericCrudService gcs;

	public void test() {
		ejb.namedQuery("Customers.findAll").forEach(e -> {
			System.out.println(e);
		});

		ejb.namedQuery("Admins.findAll").forEach(e -> {
			System.out.println(e);
		});

//		gcs.findWithNamedQuery("Customers.findAll").forEach(e -> {
//			System.out.println(e);
//		});
	}

	public void testID() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 251);
		ejb.namedQuery("Customers.findById", params).forEach(e -> {
			System.out.println(e);
		});
	}

	public void newUser() {
		for (Customers customer : customerList) {
			ejb.create(customer);
		}
		for (Admins admin : adminList) {
			ejb.create(admin);
		}
	}

	public void delete() {
		Customers c = ejb.find(Customers.class, 354);
		ejb.delete(c);
	}

	public void updateUser() {
		Customers c = ejb.find(Customers.class, 351);
		c.setAddress("NEW ADRESS!");
		ejb.update(c);

	}

	Customers[] customerList = new Customers[]{
		new Customers(1, "Ettan", "Etsson", "ettan.ettson@mail.nu", "Ettgatan 1, 12301, Ettan", "Lösen1"),
		new Customers(2, "Tvåan", "Tvåson", "tvåan.tvåson@mail.nu", "Tvågatan 2,12302,Tvåan", "Lösen2"),
		new Customers(3, "Trean", "Treson", "trean.treson@mail.nu", "Tregatan 3, 12303, Trean", "Lösen3"),
		new Customers(4, "Fyran", "Fyrson", "fyran.fyrson@mail.nu", "Fyrgatan 4,12304,Fyran", "Lösen4"),
		new Customers(5, "Femman", "Femson", "femman.femson@mail.nu", "Femgatan 5,12305,Femman", "Lösen5"),
		new Customers(6, "Sexan", "Sexson", "sexan.sexson@mail.nu", "Sexgatan 6,12306, Sexan", "Lösen6"),
		new Customers(7, "Sjuan", "Sjuson", "sjuan.sjuson@mail.nu", "Sjugatan 7,12307,Sjuan", "Lösen7"),
		new Customers(8, "Åttan", "Åttson", "åttan.åttson@mail.nu", "Åttgatan 8, 12308, Åttan", "Lösen8"),
		new Customers(9, "Nian", "Nison", "nian.nison@mail.nu", "Niagatan 9, 12309, Nian", "Lösen9"),
		new Customers(10, "Tian", "Tison", "tian.tison@mail.nu", "Tiagatan 10,12310,Tian", "Lösen10"),
		new Customers(11, "Elvan", "Elvson", "elvan.elvson@mail.nu", "Elvgatan 11, 12311, Elvan", "Lösen11"),
		new Customers(12, "Tolvan", "Tolvson", "tolvan.tolvson@mail.nu", "Tolvgatan 12,12312,Tolvan", "Lösen12"),
		new Customers(13, "Trettonet", "Trettson", "trettonet.trettson@mail.nu", "Tregatan 13,12313,Trettonet", "Lösen13"),
		new Customers(14, "Fjortonet", "Fjortson", "fjortonet.fjortson@mail.nu", "Fjortgatan 14,12314,Fjortonet", "Lösen14"),
		new Customers(15, "Femtonet", "Femtson", "femtonet.femtson@mail.nu", "Femgatan 15,12315,Femtonet", "Lösen15"),
		new Customers(16, "Sextonet", "Sextson", "sextonet.sextson@mail.nu", "Sexgatan 16, 12316, Sextonet", "Lösen16"),
		new Customers(17, "Sjuttonet", "Sjuttson", "sjuttonet.sjuttson@mail.nu", "Sjugatan 17,12317,Sjuttonet", "Lösen17"),
		new Customers(18, "Artonet", "Artson", "artonet.artson@mail.nu", "Artgatan 18,12318,Artonet", "Lösen18"),
		new Customers(19, "Nittonet", "Nittson", "nittonet.nittson@mail.nu", "Nitgatan 19,12319,Nittonet", "Lösen19"),
		new Customers(20, "Tjugan", "Tjugson", "tjugan.tjugson@mail.nu", "Tjugatan 20,12320,Tjugan", "Lösen20")};

	Admins[] adminList = new Admins[]{
		new Admins(1, "Admin.ettan@mail.nu", "Admin1"),
		new Admins(2, "Admin.tvåan@mail.nu", "Admin2"),
		new Admins(3, "Admin.trean@mail.nu", "Admin3"),
		new Admins(4, "Admin.fyran@mail.nu", "Admin4"),
		new Admins(5, "Admin.femman@mail.nu", "Admin5")};

}
