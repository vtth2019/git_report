package vn.vnpt.bacsigiadinh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A ToaThuoc.
 */
@Document(collection = "toa_thuoc")
public class ToaThuoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("chandoanbenh")
    private String chandoanbenh;

    @Field("lieuluong")
    private String lieuluong;

    @DBRef
    @Field("sokhambenh")
    @JsonIgnoreProperties("toaThuocs")
    private ThongTinKhamBenh sokhambenh;

    @DBRef
    @Field("bacSi")
    @JsonIgnoreProperties("toaThuocs")
    private BacSi bacSi;

    @DBRef
    @Field("thuocs")
    private Set<Thuoc> thuocs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChandoanbenh() {
        return chandoanbenh;
    }

    public ToaThuoc chandoanbenh(String chandoanbenh) {
        this.chandoanbenh = chandoanbenh;
        return this;
    }

    public void setChandoanbenh(String chandoanbenh) {
        this.chandoanbenh = chandoanbenh;
    }

    public String getLieuluong() {
        return lieuluong;
    }

    public ToaThuoc lieuluong(String lieuluong) {
        this.lieuluong = lieuluong;
        return this;
    }

    public void setLieuluong(String lieuluong) {
        this.lieuluong = lieuluong;
    }

    public ThongTinKhamBenh getSokhambenh() {
        return sokhambenh;
    }

    public ToaThuoc sokhambenh(ThongTinKhamBenh thongTinKhamBenh) {
        this.sokhambenh = thongTinKhamBenh;
        return this;
    }

    public void setSokhambenh(ThongTinKhamBenh thongTinKhamBenh) {
        this.sokhambenh = thongTinKhamBenh;
    }

    public BacSi getBacSi() {
        return bacSi;
    }

    public ToaThuoc bacSi(BacSi bacSi) {
        this.bacSi = bacSi;
        return this;
    }

    public void setBacSi(BacSi bacSi) {
        this.bacSi = bacSi;
    }

    public Set<Thuoc> getThuocs() {
        return thuocs;
    }

    public ToaThuoc thuocs(Set<Thuoc> thuocs) {
        this.thuocs = thuocs;
        return this;
    }

    public ToaThuoc addThuoc(Thuoc thuoc) {
        this.thuocs.add(thuoc);
       // thuoc.getThuocs().add(this);
        return this;
    }

    public ToaThuoc removeThuoc(Thuoc thuoc) {
        this.thuocs.remove(thuoc);
        //thuoc.getThuocs().remove(this);
        return this;
    }

    public void setThuocs(Set<Thuoc> thuocs) {
        this.thuocs = thuocs;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ToaThuoc)) {
            return false;
        }
        return id != null && id.equals(((ToaThuoc) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ToaThuoc{" +
            "id=" + getId() +
            ", chandoanbenh='" + getChandoanbenh() + "'" +
            ", lieuluong='" + getLieuluong() + "'" +
            "}";
    }
}
