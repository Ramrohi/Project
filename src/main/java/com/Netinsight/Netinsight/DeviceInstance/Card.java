package com.Netinsight.Netinsight.DeviceInstance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String cardName;
	@Column(name = "shelf_position")
	private Integer shelfPosition;

	@Column(name = "slot_position")
	private Integer slotPosition;

	@Column(name = "vendor")
	private String vendor;

	@Column(name = "card_model")
	private String cardModel;

	@Column(name = "card_part_number")
	private String cardPartNumber;

	@Column(name = "operational_state")
	private String operationalState;

	@Column(name = "administrative_state")
	private String administrativeState;

	@Column(name = "usage_state")
	private String usageState;

	@Column(name = "href")
	private String href;

	@ManyToOne
	@JoinColumn(name = "slot_name", referencedColumnName = "name")
	private Slots slot;

}
