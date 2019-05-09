package controller;

import jpa.Fruit;

class CartRow {

	public Fruit fruit;
	public int quant;

	public CartRow(Fruit f, int quant) {
		this.fruit = f;
		this.quant = quant;
	}

	@Override
	public String toString() {
		return String.format("fruit: %s, quant: %s", fruit, quant);
	}

}
