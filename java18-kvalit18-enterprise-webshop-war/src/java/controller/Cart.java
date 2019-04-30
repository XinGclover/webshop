package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Fruit;

@SessionScoped
@Named(value = "dummyCart")
public class Cart implements Serializable {

	List<CartRow> rows = new ArrayList<>();

	public void add(Fruit f) {
		boolean duplicate = false;

		for (CartRow row : rows) {
			if (row.fruit.getFruitid().equals(f.getFruitid())) {
				row.quant++;
				duplicate = true;
				break;
			}
		}

		if (!duplicate) {
			rows.add(new CartRow(f, 1));
		}
		System.out.println(rows);
	}
}
