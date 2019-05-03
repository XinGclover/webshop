package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Admins;
import jpa.Customers;
import crud.GenericCrudService;
import jpa.Fruit;
import jpa.Products;

@Named(value = "test")
@SessionScoped
public class TestButtons implements Serializable {

	@EJB
	private GenericCrudService crudBean;

	public GenericCrudService getCrudBean() {
		return crudBean;
	}

	public void setCrudBean(GenericCrudService crudBean) {
		this.crudBean = crudBean;
	}

	public void test() {
		crudBean.findWithNamedQuery("Customers.findAll").forEach(e -> {
			System.out.println(e);
		});

		crudBean.findWithNamedQuery("Admins.findAll").forEach(e -> {
			System.out.println(e);
		});

		crudBean.findWithNamedQuery("Fruit.findAll").forEach(e -> {
			System.out.println(e);
		});
                crudBean.findWithNamedQuery("Products.findAll").forEach(e -> {
			System.out.println(e);
		});

	}

	public void newUser() {
		for (Customers customer : jpa.FakeData.CUSTOMERLIST) {
			crudBean.create(customer);
		}
		for (Admins admin : jpa.FakeData.ADMINLIST) {
			crudBean.create(admin);
		}
		for (Fruit fruit : jpa.FakeData.FRUITLIST) {
			crudBean.create(fruit);
		}
		for (Products product : jpa.FakeData.PRODUCTLIST){
			crudBean.create(product);
		}
	}

	public void deleteAll() {
		crudBean.nuke(Customers.class);
		crudBean.nuke(Admins.class);
		crudBean.nuke(Fruit.class);
                crudBean.nuke(Products.class);
	}

}
