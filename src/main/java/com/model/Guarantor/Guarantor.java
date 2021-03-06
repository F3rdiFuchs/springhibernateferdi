package com.model.Guarantor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.model.CompanyCar.CompanyCar;

@Entity
@Table(name="GUARANTOR")
public class Guarantor {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="guarantorId")
	private int guarantorId;
	
	@Column(name="gName")
	private String gName;
	
	
	@OneToOne(mappedBy="guarantor")
	private CompanyCar companycar;


	public int getGuarantorId() {
		return guarantorId;
	}


	public void setGuarantorId(int guarantorId) {
		this.guarantorId = guarantorId;
	}


	public String getgName() {
		return gName;
	}


	public void setgName(String gName) {
		this.gName = gName;
	}


	public CompanyCar getCompanycar() {
		return companycar;
	}


	public void setCompanycar(CompanyCar companycar) {
		this.companycar = companycar;
	}
	
	@Override
	public String toString()
	{
		return this.gName;
	}

	
}
