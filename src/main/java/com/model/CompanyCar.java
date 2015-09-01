package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="COMPANYCAR")
public class CompanyCar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="carId")
	private int carId;
	
	@Column(name="model")
	private String model;
	
	@Column(name="distance")
	private int distance;
	
	@Column(name="mark")
	private String mark;
	
	@Column(name="lgeneralinspection")
	private String lgeneralinspection;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    private Guarantor guarantor;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getLgeneralinspection() {
		return lgeneralinspection;
	}

	public void setLgeneralinspection(String lgeneralinspection) {
		this.lgeneralinspection = lgeneralinspection;
	}

	public Guarantor getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(Guarantor guarantor) {
		this.guarantor = guarantor;
	}

	
}
