/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author marcelo
 */
public class Funcionarios {
    
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private String nomeCompleto;
    private LocalDate dataAdmissao;
    private BigDecimal salario;
    private Boolean status;

    public Funcionarios() {
    }

    public Funcionarios(String nomeCompleto, LocalDate dataAdmissao, BigDecimal salario, Boolean status) {
        this.nomeCompleto = nomeCompleto;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.status = status;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public String getDataAdmissaoFormatada() {
        return dataAdmissao == null ? "" : dataAdmissao.format(FORMATO_DATA);
    }
}
