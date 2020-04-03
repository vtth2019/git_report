package vn.vnpt.bacsigiadinh.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

/**
 * A BenhNhan.
 */
@Document(collection = "benh_nhan")
public class BenhNhan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("mabenhnhan")
    private Long mabenhnhan;

    @Field("hoten")
    private String hoten;

    @Field("tuoi")
    private Integer tuoi;

    @Field("diachi")
    private String diachi;

    @Field("email")
    private String email;

    @Field("sodienthoai")
    private String sodienthoai;

    @Field("mahoso")
    private Integer mahoso;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMabenhnhan() {
        return mabenhnhan;
    }

    public BenhNhan mabenhnhan(Long mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
        return this;
    }

    public void setMabenhnhan(Long mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
    }

    public String getHoten() {
        return hoten;
    }

    public BenhNhan hoten(String hoten) {
        this.hoten = hoten;
        return this;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public BenhNhan tuoi(Integer tuoi) {
        this.tuoi = tuoi;
        return this;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public BenhNhan diachi(String diachi) {
        this.diachi = diachi;
        return this;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public BenhNhan email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public BenhNhan sodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
        return this;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public Integer getMahoso() {
        return mahoso;
    }

    public BenhNhan mahoso(Integer mahoso) {
        this.mahoso = mahoso;
        return this;
    }

    public void setMahoso(Integer mahoso) {
        this.mahoso = mahoso;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BenhNhan)) {
            return false;
        }
        return id != null && id.equals(((BenhNhan) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BenhNhan{" +
            "id=" + getId() +
            ", mabenhnhan=" + getMabenhnhan() +
            ", hoten='" + getHoten() + "'" +
            ", tuoi=" + getTuoi() +
            ", diachi='" + getDiachi() + "'" +
            ", email='" + getEmail() + "'" +
            ", sodienthoai='" + getSodienthoai() + "'" +
            ", mahoso=" + getMahoso() +
            "}";
    }
}
