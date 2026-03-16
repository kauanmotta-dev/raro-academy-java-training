package com.example.raro_academy_db.domain;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codigo_associado;
    private Integer codigo_item;
    private Integer matricula_funcionario_verificante;
    private Integer codigo_funcionario_verificante;
    private LocalDateTime data_hora_verificacao;
    private LocalDate data_emprestimo;
    private LocalDate data_devolucao;

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", codigo_associado=" + codigo_associado +
                ", codigo_item=" + codigo_item +
                ", matricula_funcionario_verificante=" + matricula_funcionario_verificante +
                ", codigo_funcionario_verificante=" + codigo_funcionario_verificante +
                ", data_hora_verificacao=" + data_hora_verificacao +
                ", data_emprestimo=" + data_emprestimo +
                ", data_devolucao=" + data_devolucao +
                '}';
    }

    public Emprestimo (){}

    public Emprestimo(Integer codigo_associado, Integer codigo_item, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.codigo_associado = codigo_associado;
        this.codigo_item = codigo_item;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo_associado() {
        return codigo_associado;
    }

    public void setCodigo_associado(Integer codigo_associado) {
        this.codigo_associado = codigo_associado;
    }

    public Integer getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(Integer codigo_item) {
        this.codigo_item = codigo_item;
    }

    public Integer getMatricula_funcionario_verificante() {
        return matricula_funcionario_verificante;
    }

    public void setMatricula_funcionario_verificante(Integer matricula_funcionario_verificante) {
        this.matricula_funcionario_verificante = matricula_funcionario_verificante;
    }

    public Integer getCodigo_funcionario_verificante() {
        return codigo_funcionario_verificante;
    }

    public void setCodigo_funcionario_verificante(Integer codigo_funcionario_verificante) {
        this.codigo_funcionario_verificante = codigo_funcionario_verificante;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDateTime getData_hora_verificacao() {
        return data_hora_verificacao;
    }

    public void setData_hora_verificacao(LocalDateTime data_hora_verificacao) {
        this.data_hora_verificacao = data_hora_verificacao;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}