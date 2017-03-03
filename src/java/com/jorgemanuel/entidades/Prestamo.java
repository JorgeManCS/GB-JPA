/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgemanuel.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author develop
 */
@Entity
@Table(name = "PRESTAMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByUsuario", query = "SELECT p FROM Prestamo p WHERE p.prestamoPK.usuario = :usuario")
    , @NamedQuery(name = "Prestamo.findByLibro", query = "SELECT p FROM Prestamo p WHERE p.prestamoPK.libro = :libro")
    , @NamedQuery(name = "Prestamo.findByDias", query = "SELECT p FROM Prestamo p WHERE p.dias = :dias")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrestamoPK prestamoPK;
    @Column(name = "DIAS")
    private Integer dias;
    @JoinColumn(name = "USUARIO", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;
    @JoinColumn(name = "LIBRO", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Libro libro1;

    public Prestamo() {
    }

    public Prestamo(PrestamoPK prestamoPK) {
        this.prestamoPK = prestamoPK;
    }

    public Prestamo(int usuario, int libro) {
        this.prestamoPK = new PrestamoPK(usuario, libro);
    }

    public PrestamoPK getPrestamoPK() {
        return prestamoPK;
    }

    public void setPrestamoPK(PrestamoPK prestamoPK) {
        this.prestamoPK = prestamoPK;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Libro getLibro1() {
        return libro1;
    }

    public void setLibro1(Libro libro1) {
        this.libro1 = libro1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prestamoPK != null ? prestamoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.prestamoPK == null && other.prestamoPK != null) || (this.prestamoPK != null && !this.prestamoPK.equals(other.prestamoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jorgemanuel.entidades.Prestamo[ prestamoPK=" + prestamoPK + " ]";
    }
    
}
