package BrunoOsio.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String manufac;
	private String model;
	private String year;
	private Double price;

	@OneToOne
	private Client whoRented;

	public Car() {
		super();
	}

	public Car(String manufac, String model, String year, Double price, Client whoRented) {
		super();
		this.manufac = manufac;
		this.model = model;
		this.year = year;
		this.price = price;
		this.whoRented = whoRented;
	}
	
	

	public Car(String manufac, String model, String year, Double price) {
		super();
		this.manufac = manufac;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufac() {
		return manufac;
	}

	public void setManufac(String manufac) {
		this.manufac = manufac;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Client getWhoRented() {
		return whoRented;
	}

	public void setWhoRented(Client whoRented) {
		this.whoRented = whoRented;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
