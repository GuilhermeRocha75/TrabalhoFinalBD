
package br.com.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaDTO {
    private int id;
    private java.time.LocalDate data;    // Ou use java.sql.Date para SQL
    private java.time.LocalTime hora;    // Ou use java.sql.Time para SQL
    private String descricao;
    private int clienteId;   // Para associar com o cliente

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}

