/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convert;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author chander
 */
@Entity
@Table(name = "STUDENTSLOGIN", catalog = "", schema = "USER12")
@NamedQueries({
    @NamedQuery(name = "Studentslogin.findAll", query = "SELECT s FROM Studentslogin s"),
    @NamedQuery(name = "Studentslogin.findById", query = "SELECT s FROM Studentslogin s WHERE s.id = :id"),
    @NamedQuery(name = "Studentslogin.findByName", query = "SELECT s FROM Studentslogin s WHERE s.name = :name"),
    @NamedQuery(name = "Studentslogin.findByRoll", query = "SELECT s FROM Studentslogin s WHERE s.roll = :roll"),
    @NamedQuery(name = "Studentslogin.findByMarks", query = "SELECT s FROM Studentslogin s WHERE s.marks = :marks")})
public class Studentslogin implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", length = 25)
    private String name;
    @Column(name = "ROLL", length = 15)
    private String roll;
    @Column(name = "MARKS")
    private Integer marks;

    public Studentslogin() {
    }

    public Studentslogin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        String oldRoll = this.roll;
        this.roll = roll;
        changeSupport.firePropertyChange("roll", oldRoll, roll);
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        Integer oldMarks = this.marks;
        this.marks = marks;
        changeSupport.firePropertyChange("marks", oldMarks, marks);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentslogin)) {
            return false;
        }
        Studentslogin other = (Studentslogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "convert.Studentslogin[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
