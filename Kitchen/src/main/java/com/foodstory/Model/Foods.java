package com.foodstory.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="foods")
public class Foods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idfood;
	
	@Column(name = "namefood")
	private String namefood;
	
	@Column(name = "descriptfood")
	private String descriptfood;
	
	@Column(name = "qtityavailfood")
	private Integer qtityavailfood;
	
	@Column(name = "pricefood")
	private double pricefood;
	
	
	public Foods() {}


	public Foods(String namefood, String descriptfood, Integer qtityavailfood, double pricefood) {
		super();
		this.namefood = namefood;
		this.descriptfood = descriptfood;
		this.qtityavailfood = qtityavailfood;
		this.pricefood = pricefood;
	}


	public Integer getIdfood() {
		return idfood;
	}


	public void setIdfood(Integer idfood) {
		this.idfood = idfood;
	}


	public String getNamefood() {
		return namefood;
	}


	public void setNamefood(String namefood) {
		this.namefood = namefood;
	}


	public String getDescriptfood() {
		return descriptfood;
	}


	public void setDescriptfood(String descriptfood) {
		this.descriptfood = descriptfood;
	}


	public Integer getQtityavailfood() {
		return qtityavailfood;
	}


	public void setQtityavailfood(Integer qtityavailfood) {
		this.qtityavailfood = qtityavailfood;
	}


	public double getPricefood() {
		return pricefood;
	}


	public void setPricefood(double pricefood) {
		this.pricefood = pricefood;
	}


	@Override
	public String toString() {
		return "Foods [idfood=" + idfood + ", namefood=" + namefood + ", descriptfood=" + descriptfood
				+ ", qtityavailfood=" + qtityavailfood + ", pricefood=" + pricefood + "]";
	}
	 

}
