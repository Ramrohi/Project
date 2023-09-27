package com.Netinsight.Netinsight.DeviceInstance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cardslot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String CardslotName;
	@Column(name = "slotPosition")
	private int slotPosition;

	@Column(name = "operationalState")
	private String operationalState;

	@Column(name = "administrativeState")
	private String administrativeState;

	@Column(name = "usageState")
	private String usageState;

	@Column(name = "href")
	private String href;

	@ManyToOne
	@JoinColumn(name = "card_name", referencedColumnName = "cardName")
	private Card slot;

}
