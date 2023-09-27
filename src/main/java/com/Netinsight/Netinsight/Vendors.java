package com.Netinsight.Netinsight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendors {
	@Id
	@Column(name="vendorname")
	private String vendorname;

	public Vendors() {
		super();
	}

	public Vendors(String vendorname) {
		super();
		this.vendorname = vendorname;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	

}
