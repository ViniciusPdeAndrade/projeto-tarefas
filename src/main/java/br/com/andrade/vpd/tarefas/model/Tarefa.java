package br.com.andrade.vpd.tarefas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Tarefa implements Serializable {

	private static final long serialVersionUID = -3326015601681724627L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id_tarefa;
	
	@Column(name="descricao")
	private String descricao;
	
	@Version
	private Integer version;
	
	private Tarefa() {
		
	}

	public Integer getId() {
		return id_tarefa;
	}

	public void setId(Integer id) {
		this.id_tarefa = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	

}
