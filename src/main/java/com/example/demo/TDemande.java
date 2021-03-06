package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dto.CongerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="TDemande")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TDemande implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
    private String dateDebut;
	
	@Column
    private String dateFin;
    
	@Column
    private String commentaire;
	
	@Column
	private String TypeConge;
	
	@Column
	private String empName;
}
