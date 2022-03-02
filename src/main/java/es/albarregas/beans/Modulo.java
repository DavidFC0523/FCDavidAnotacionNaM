/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author gared
 */
@Entity
@Table(name = "modulosAnan")

public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idModulo")
    private Integer id;
    @Column(length = 60, nullable = false)

    private String titulo;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "modulos")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OrderBy("nombre")

    private Set<Profesor> profesores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    
    
    
    
    
}
