/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author gared
 */
@Entity
@Table(name = "profesoresAnan")

public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idProfesor")
    private int id;

    @Column(length = 30, nullable = false)
    private String nombre;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "profesormodulo",
            joinColumns = @JoinColumn(name = "idProfesor"),
            foreignKey = @ForeignKey(name = "FK_profesormodulo_profesor"),
            inverseJoinColumns = @JoinColumn(name = "idModulo"),
            inverseForeignKey = @ForeignKey(name = "FK_profesormodulo_modulos"))

    private Set<Modulo> modulos;

    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
