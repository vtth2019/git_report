package vn.vnpt.bacsigiadinh.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Thuoc.
 */
@Document(collection = "thuoc")
public class Thuoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("tenthuoc")
    private String tenthuoc;

    @Field("loaithuoc")
    private String loaithuoc;

    @Field("hoatchat")
    private String hoatchat;

    @Field("hamluong")
    private String hamluong;

    @Field("nuocsanxuat")
    private String nuocsanxuat;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public Thuoc tenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
        return this;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getLoaithuoc() {
        return loaithuoc;
    }

    public Thuoc loaithuoc(String loaithuoc) {
        this.loaithuoc = loaithuoc;
        return this;
    }

    public void setLoaithuoc(String loaithuoc) {
        this.loaithuoc = loaithuoc;
    }

    public String getHoatchat() {
        return hoatchat;
    }

    public Thuoc hoatchat(String hoatchat) {
        this.hoatchat = hoatchat;
        return this;
    }

    public void setHoatchat(String hoatchat) {
        this.hoatchat = hoatchat;
    }

    public String getHamluong() {
        return hamluong;
    }

    public Thuoc hamluong(String hamluong) {
        this.hamluong = hamluong;
        return this;
    }

    public void setHamluong(String hamluong) {
        this.hamluong = hamluong;
    }

    public String getNuocsanxuat() {
        return nuocsanxuat;
    }

    public Thuoc nuocsanxuat(String nuocsanxuat) {
        this.nuocsanxuat = nuocsanxuat;
        return this;
    }

    public void setNuocsanxuat(String nuocsanxuat) {
        this.nuocsanxuat = nuocsanxuat;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thuoc)) {
            return false;
        }
        return id != null && id.equals(((Thuoc) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
            "id=" + getId() +
            ", tenthuoc='" + getTenthuoc() + "'" +
            ", loaithuoc='" + getLoaithuoc() + "'" +
            ", hoatchat='" + getHoatchat() + "'" +
            ", hamluong='" + getHamluong() + "'" +
            ", nuocsanxuat='" + getNuocsanxuat() + "'" +
            "}";
    }
}
