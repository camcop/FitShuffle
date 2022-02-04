package com.qa.fitshuffle.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank(message = "name cannot be blank")
	private String name;

	@Column
	private String type;

	@Column
	private String subtype;

	@Column
	private String brand;

	@Column
	private String colour;

	public Item() {
		super();
	}

	public Item(Long id, String name, String type, String subtype,
			String brand, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.subtype = subtype;
		this.brand = brand;
		this.colour = colour;
	}

	public Item(String name, String type, String subtype, String brand, String colour) {
		this.name = name;
		this.type = type;
		this.subtype = subtype;
		this.brand = brand;
		this.colour = colour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", subtype='" + subtype + '\'' +
				", brand='" + brand + '\'' +
				", colour='" + colour + '\'' +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, colour, id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(colour, other.colour)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

}
