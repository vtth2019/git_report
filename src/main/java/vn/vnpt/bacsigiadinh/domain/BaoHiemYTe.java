package vn.vnpt.bacsigiadinh.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 * A BaoHiemYTe.
 */
@Document(collection = "bao_hiemyte")
public class BaoHiemYTe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("mathebaohiemyte")
    private String mathebaohiemyte;

    @Field("noidangky")
    private String noidangky;

    @Field("tungay")
    private LocalDate tungay;

    @Field("denngay")
    private LocalDate denngay;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMathebaohiemyte() {
        return mathebaohiemyte;
    }

    public BaoHiemYTe mathebaohiemyte(String mathebaohiemyte) {
        this.mathebaohiemyte = mathebaohiemyte;
        return this;
    }

    public void setMathebaohiemyte(String mathebaohiemyte) {
        this.mathebaohiemyte = mathebaohiemyte;
    }

    public String getNoidangky() {
        return noidangky;
    }

    public BaoHiemYTe noidangky(String noidangky) {
        this.noidangky = noidangky;
        return this;
    }

    public void setNoidangky(String noidangky) {
        this.noidangky = noidangky;
    }

    public LocalDate getTungay() {
        return tungay;
    }

    public BaoHiemYTe tungay(LocalDate tungay) {
        this.tungay = tungay;
        return this;
    }

    public void setTungay(LocalDate tungay) {
        this.tungay = tungay;
    }

    public LocalDate getDenngay() {
        return denngay;
    }

    public BaoHiemYTe denngay(LocalDate denngay) {
        this.denngay = denngay;
        return this;
    }

    public void setDenngay(LocalDate denngay) {
        this.denngay = denngay;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaoHiemYTe)) {
            return false;
        }
        return id != null && id.equals(((BaoHiemYTe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BaoHiemYTe{" +
            "id=" + getId() +
            ", mathebaohiemyte='" + getMathebaohiemyte() + "'" +
            ", noidangky='" + getNoidangky() + "'" +
            ", tungay='" + getTungay() + "'" +
            ", denngay='" + getDenngay() + "'" +
            "}";
    }
}
