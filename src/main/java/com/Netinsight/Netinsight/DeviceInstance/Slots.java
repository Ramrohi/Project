package com.Netinsight.Netinsight.DeviceInstance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Slots {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	private int shelfPosition;

	private String operationalState;

	private String administrativeState;

	private String href;

	private String usageState;

	@ManyToOne
	@JoinColumn(name = "shelf_name", referencedColumnName = "name")
	private Shelf shelf;
}
