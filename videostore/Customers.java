/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videostore;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author chander
 */
@Entity
@Table(name = "CUSTOMERS", catalog = "", schema = "USER12")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findById", query = "SELECT c FROM Customers c WHERE c.id = :id"),
    @NamedQuery(name = "Customers.findByCname", query = "SELECT c FROM Customers c WHERE c.cname = :cname"),
    @NamedQuery(name = "Customers.findByAddress", query = "SELECT c FROM Customers c WHERE c.address = :address"),
    @NamedQuery(name = "Customers.findByArented", query = "SELECT c FROM Customers c WHERE c.arented = :arented"),
    @NamedQuery(name = "Customers.findByVrented", query = "SELECT c FROM Customers c WHERE c.vrented = :vrented"),
    @NamedQuery(name = "Customers.findByDateofrent", query = "SELECT c FROM Customers c WHERE c.dateofrent = :dateofrent"),
    @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone")})
public class Customers implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "CNAME", length = 30)
    private String cname;
    @Column(name = "ADDRESS", length = 75)
    private String address;
    @Column(name = "ARENTED")
    private Integer arented = 0;
    @Column(name = "VRENTED")
    private Integer vrented = 0;
    @Column(name = "DATEOFRENT")
    @Temporal(TemporalType.DATE)
    private Date dateofrent = new Date();
    @Column(name = "PHONE", length = 15)
    private String phone;

    public Customers() {
    }

    public Customers(Integer id) {
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        String oldCname = this.cname;
        this.cname = cname;
        changeSupport.firePropertyChange("cname", oldCname, cname);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public Integer getArented() {
        return arented;
    }

    public void setArented(Integer arented) {
        Integer oldArented = this.arented;
        this.arented = arented;
        changeSupport.firePropertyChange("arented", oldArented, arented);
    }

    public Integer getVrented() {
        return vrented;
    }

    public void setVrented(Integer vrented) {
        Integer oldVrented = this.vrented;
        this.vrented = vrented;
        changeSupport.firePropertyChange("vrented", oldVrented, vrented);
    }

    public Date getDateofrent() {
        return dateofrent;
    }

    public void setDateofrent(Date dateofrent) {
        Date oldDateofrent = this.dateofrent;
        this.dateofrent = dateofrent;
        changeSupport.firePropertyChange("dateofrent", oldDateofrent, dateofrent);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
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
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videostore.Customers[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
