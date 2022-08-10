package br.com.jackssgames.jackssgameapi.dtos;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class GamesDTO {
	
	
    @NotBlank
    private String nome;
    @NotBlank
    @Length(min = 10,max = 2000000)
    private String descricao;
    @NotBlank
    @Length(min = 10,max = 2000000)
    private String requisitos;
    @NotBlank
    private String id_video;
    @NotBlank
    @Length(max = 2000000)
    private String imagem;
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
