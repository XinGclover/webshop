package jpa;

import java.math.BigDecimal;

public class FakeData {

	public static final Customers[] CUSTOMERLIST = new Customers[]{
		new Customers("Ettan", "Etsson", "ettan.ettson@mail.nu", "Ettgatan 1, 12301, Ettan", "Lösen1", false, 0),
		new Customers("Tvåan", "Tvåson", "tvåan.tvåson@mail.nu", "Tvågatan 2,12302,Tvåan", "Lösen2", false, 0),
		new Customers("Trean", "Treson", "trean.treson@mail.nu", "Tregatan 3, 12303, Trean", "Lösen3", false, 0),
		new Customers("Fyran", "Fyrson", "fyran.fyrson@mail.nu", "Fyrgatan 4,12304,Fyran", "Lösen4", false, 0),
		new Customers("Femman", "Femson", "femman.femson@mail.nu", "Femgatan 5,12305,Femman", "Lösen5", false, 0),
		new Customers("Sexan", "Sexson", "sexan.sexson@mail.nu", "Sexgatan 6,12306, Sexan", "Lösen6", false, 0),
		new Customers("Sjuan", "Sjuson", "sjuan.sjuson@mail.nu", "Sjugatan 7,12307,Sjuan", "Lösen7", false, 0),
		new Customers("Åttan", "Åttson", "åttan.åttson@mail.nu", "Åttgatan 8, 12308, Åttan", "Lösen8", false, 0),
		new Customers("Nian", "Nison", "nian.nison@mail.nu", "Niagatan 9, 12309, Nian", "Lösen9", false, 0),
		new Customers("Tian", "Tison", "tian.tison@mail.nu", "Tiagatan 10,12310,Tian", "Lösen10", false, 0),
		new Customers("Elvan", "Elvson", "elvan.elvson@mail.nu", "Elvgatan 11, 12311, Elvan", "Lösen11", false, 0),
		new Customers("Tolvan", "Tolvson", "tolvan.tolvson@mail.nu", "Tolvgatan 12,12312,Tolvan", "Lösen12", false, 0),
		new Customers("Trettonet", "Trettson", "trettonet.trettson@mail.nu", "Tregatan 13,12313,Trettonet", "Lösen13", false, 0),
		new Customers("Fjortonet", "Fjortson", "fjortonet.fjortson@mail.nu", "Fjortgatan 14,12314,Fjortonet", "Lösen14", false, 0),
		new Customers("Femtonet", "Femtson", "femtonet.femtson@mail.nu", "Femgatan 15,12315,Femtonet", "Lösen15", false, 0),
		new Customers("Sextonet", "Sextson", "sextonet.sextson@mail.nu", "Sexgatan 16, 12316, Sextonet", "Lösen16", false, 0),
		new Customers("Sjuttonet", "Sjuttson", "sjuttonet.sjuttson@mail.nu", "Sjugatan 17,12317,Sjuttonet", "Lösen17", false, 0),
		new Customers("Artonet", "Artson", "artonet.artson@mail.nu", "Artgatan 18,12318,Artonet", "Lösen18", false, 0),
		new Customers("Nittonet", "Nittson", "nittonet.nittson@mail.nu", "Nitgatan 19,12319,Nittonet", "Lösen19", false, 0),
		new Customers("Tjugan", "Tjugson", "tjugan.tjugson@mail.nu", "Tjugatan 20,12320,Tjugan", "Lösen20", false, 0)};

	public static final Admins[] ADMINLIST = new Admins[]{
		new Admins("admin.ettan@mail.nu", "Admin1"),
		new Admins("admin.tvåan@mail.nu", "Admin2"),
		new Admins("admin.trean@mail.nu", "Admin3"),
		new Admins("admin.fyran@mail.nu", "Admin4"),
		new Admins("admin.femman@mail.nu", "Admin5")};

	public static final Fruit[] FRUITLIST = new Fruit[]{
		new Fruit("Banan", "1kg", 45),
		new Fruit("Äpple", "1kg", 35),
		new Fruit("Kiwi", "1kg", 25),
		new Fruit("Apelsin", "1kg", 75)};

	public static final Products[] PRODUCTLIST = new Products[]{
		new Products("Banan", "1kg", new BigDecimal(1.0)),
		new Products("Ryggbiff", "500g", new BigDecimal(159.0)),
		new Products("Mjölk", "1,5L", new BigDecimal(12.0)),
		new Products("Kaffe", "450g", new BigDecimal(49.0))};

}
