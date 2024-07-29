package br.com.fsdney.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name = "carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name ="modelo", nullable = false)
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;
	
	
	@ManyToMany
	@JoinTable(
		name ="carro_acessorio",
		joinColumns = @JoinColumn(name = "carro_id"),
		inverseJoinColumns = @JoinColumn(name = "acessorio_id")
	)
	private List<Acessorio> acessorios;
	
	public Carro() {}
	
	public Carro(String modelo, Marca marca) {
		this.modelo = modelo;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public List<Acessorio> getAcessorio() {
		return acessorios;
	}


	public void setAcessorio(List<Acessorio> acessorio) {
		this.acessorios = acessorio;
	}
	
	
	
}
