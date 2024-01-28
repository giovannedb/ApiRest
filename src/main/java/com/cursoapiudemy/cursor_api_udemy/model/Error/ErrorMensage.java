package com.cursoapiudemy.cursor_api_udemy.model.Error;

public class ErrorMensage {
    private String titulo;

    private Integer status;

    private String mensagem;

    // devolver esses campos para quem consumir a aplicação e der um erro
    public ErrorMensage(String titulo, Integer status, String mensagem) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
