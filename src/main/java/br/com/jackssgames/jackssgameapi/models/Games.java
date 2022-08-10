package br.com.jackssgames.jackssgameapi.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "TB_GAMES")
public class Games implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    @Size(min = 3,max = 50)
    private String nome;
    @Column(nullable = false)
    @Length(min = 10,max = 2000000)
    private String descricao;
    @Column(nullable = false)
    @Length(min = 10,max = 2000000)
    private String requisitos;
    @Column(nullable = false)
    private String id_video;
    @Column(nullable = false)
    @Length(max = 2000000)
    private String imagem;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getId_video() {
		return id_video;
	}
	public void setId_video(String id_video) {
		this.id_video = id_video;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
    
    

}
