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
@Table(name = "PURCHASES", catalog = "", schema = "USER12")
@NamedQueries({
    @NamedQuery(name = "Purchases.findAll", query = "SELECT p FROM Purchases p"),
    @NamedQuery(name = "Purchases.findByItemno", query = "SELECT p FROM Purchases p WHERE p.itemno = :itemno"),
    @NamedQuery(name = "Purchases.findByDateofpurchase", query = "SELECT p FROM Purchases p WHERE p.dateofpurchase = :dateofpurchase"),
    @NamedQuery(name = "Purchases.findByOrigprice", query = "SELECT p FROM Purchases p WHERE p.origprice = :origprice"),
    @NamedQuery(name = "Purchases.findByDrentalcharge", query = "SELECT p FROM Purchases p WHERE p.drentalcharge = :drentalcharge"),
    @NamedQuery(name = "Purchases.findByAvtype", query = "SELECT p FROM Purchases p WHERE p.avtype = :avtype"),
    @NamedQuery(name = "Purchases.findByFormat", query = "SELECT p FROM Purchases p WHERE p.format = :format"),
    @NamedQuery(name = "Purchases.findByNoofcopies", query = "SELECT p FROM Purchases p WHERE p.noofcopies = :noofcopies"),
    @NamedQuery(name = "Purchases.findByPname", query = "SELECT p FROM Purchases p WHERE p.pname = :pname")})
public class Purchases implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEMNO", nullable = false)
    private Integer itemno;
    @Column(name = "DATEOFPURCHASE")
    @Temporal(TemporalType.DATE)
    private Date dateofpurchase;
    @Column(name = "ORIGPRICE")
    private Integer origprice;
    @Column(name = "DRENTALCHARGE")
    private Integer drentalcharge;
    @Column(name = "AVTYPE", length = 3)
    private String avtype;
    @Column(name = "FORMAT", length = 10)
    private String format;
    @Column(name = "NOOFCOPIES")
    private Integer noofcopies;
    @Column(name = "PNAME", length = 100)
    private String pname;

    public Purchases() {
    }

    public Purchases(Integer itemno) {
        this.itemno = itemno;
    }

    public Integer getItemno() {
        return itemno;
    }

    public void setItemno(Integer itemno) {
        Integer oldItemno = this.itemno;
        this.itemno = itemno;
        changeSupport.firePropertyChange("itemno", oldItemno, itemno);
    }

    public Date getDateofpurchase() {
        return dateofpurchase;
    }

    public void setDateofpurchase(Date dateofpurchase) {
        Date oldDateofpurchase = this.dateofpurchase;
        this.dateofpurchase = dateofpurchase;
        changeSupport.firePropertyChange("dateofpurchase", oldDateofpurchase, dateofpurchase);
    }

    public Integer getOrigprice() {
        return origprice;
    }

    public void setOrigprice(Integer origprice) {
        Integer oldOrigprice = this.origprice;
        this.origprice = origprice;
        changeSupport.firePropertyChange("origprice", oldOrigprice, origprice);
    }

    public Integer getDrentalcharge() {
        return drentalcharge;
    }

    public void setDrentalcharge(Integer drentalcharge) {
        Integer oldDrentalcharge = this.drentalcharge;
        this.drentalcharge = drentalcharge;
        changeSupport.firePropertyChange("drentalcharge", oldDrentalcharge, drentalcharge);
    }

    public String getAvtype() {
        return avtype;
    }

    public void setAvtype(String avtype) {
        String oldAvtype = this.avtype;
        this.avtype = avtype;
        changeSupport.firePropertyChange("avtype", oldAvtype, avtype);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        String oldFormat = this.format;
        this.format = format;
        changeSupport.firePropertyChange("format", oldFormat, format);
    }

    public Integer getNoofcopies() {
        return noofcopies;
    }

    public void setNoofcopies(Integer noofcopies) {
        Integer oldNoofcopies = this.noofcopies;
        this.noofcopies = noofcopies;
        changeSupport.firePropertyChange("noofcopies", oldNoofcopies, noofcopies);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        String oldPname = this.pname;
        this.pname = pname;
        changeSupport.firePropertyChange("pname", oldPname, pname);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemno != null ? itemno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchases)) {
            return false;
        }
        Purchases other = (Purchases) object;
        if ((this.itemno == null && other.itemno != null) || (this.itemno != null && !this.itemno.equals(other.itemno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videostore.Purchases[ itemno=" + itemno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
