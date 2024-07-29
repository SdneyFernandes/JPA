package br.com.fsdney.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Marca")
public class Marca {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
	@SequenceGenerator(name = "marca_seq", sequenceName = "sq_marca",
	initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name ="nome", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	private List<Carro> carro;

	 public Marca() {}

	   
	    public Marca(String nome) {
	        this.nome = nome;
	    }

	 
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public List<Carro> getCarros() {
	        return carro;
	    }

	    public void setCarros(List<Carro> carros) {
	        this.carro = carros;
	    }
	
	
}
