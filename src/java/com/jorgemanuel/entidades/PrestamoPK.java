/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgemanuel.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author develop
 */
@Embeddable
public class PrestamoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO")
    private int usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIBRO")
    private int libro;

    public PrestamoPK() {
    }

    public PrestamoPK(int usuario, int libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuario;
        hash += (int) libro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoPK)) {
            return false;
        }
        PrestamoPK other = (PrestamoPK) object;
        if (this.usuario != other.usuario) {
            return false;
        }
        if (this.libro != other.libro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jorgemanuel.entidades.PrestamoPK[ usuario=" + usuario + ", libro=" + libro + " ]";
    }
    
}
