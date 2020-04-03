package vn.vnpt.bacsigiadinh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 * A ThongTinKhamBenh.
 */
@Document(collection = "thong_tin_kham_benh")
public class ThongTinKhamBenh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("masokhambenh")
    private Long masokhambenh;

    @Field("ngaykham")
    private LocalDate ngaykham;

    @Field("noikham")
    private String noikham;

    @Field("ngaytaikham")
    private LocalDate ngaytaikham;

    @Field("lankham")
    private Integer lankham;

    @Field("chandoanbenh")
    private String chandoanbenh;

    @DBRef
    @Field("benhNhan")
    @JsonIgnoreProperties("thongTinKhamBenhs")
    private BenhNhan benhNhan;

    @DBRef
    @Field("baoHiemYTe")
    private BaoHiemYTe baoHiemYTe;

    @DBRef
    @Field("bacSi")
    @JsonIgnoreProperties("thongTinKhamBenhs")
    private BacSi bacSi;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMasokhambenh() {
        return masokhambenh;
    }

    public ThongTinKhamBenh masokhambenh(Long masokhambenh) {
        this.masokhambenh = masokhambenh;
        return this;
    }

    public void setMasokhambenh(Long masokhambenh) {
        this.masokhambenh = masokhambenh;
    }

    public LocalDate getNgaykham() {
        return ngaykham;
    }

    public ThongTinKhamBenh ngaykham(LocalDate ngaykham) {
        this.ngaykham = ngaykham;
        return this;
    }

    public void setNgaykham(LocalDate ngaykham) {
        this.ngaykham = ngaykham;
    }

    public String getNoikham() {
        return noikham;
    }

    public ThongTinKhamBenh noikham(String noikham) {
        this.noikham = noikham;
        return this;
    }

    public void setNoikham(String noikham) {
        this.noikham = noikham;
    }

    public LocalDate getNgaytaikham() {
        return ngaytaikham;
    }

    public ThongTinKhamBenh ngaytaikham(LocalDate ngaytaikham) {
        this.ngaytaikham = ngaytaikham;
        return this;
    }

    public void setNgaytaikham(LocalDate ngaytaikham) {
        this.ngaytaikham = ngaytaikham;
    }

    public Integer getLankham() {
        return lankham;
    }

    public ThongTinKhamBenh lankham(Integer lankham) {
        this.lankham = lankham;
        return this;
    }

    public void setLankham(Integer lankham) {
        this.lankham = lankham;
    }

    public String getChandoanbenh() {
        return chandoanbenh;
    }

    public ThongTinKhamBenh chandoanbenh(String chandoanbenh) {
        this.chandoanbenh = chandoanbenh;
        return this;
    }

    public void setChandoanbenh(String chandoanbenh) {
        this.chandoanbenh = chandoanbenh;
    }

    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public ThongTinKhamBenh benhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
        return this;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public BaoHiemYTe getBaoHiemYTe() {
        return baoHiemYTe;
    }

    public ThongTinKhamBenh baoHiemYTe(BaoHiemYTe baoHiemYTe) {
        this.baoHiemYTe = baoHiemYTe;
        return this;
    }

    public void setBaoHiemYTe(BaoHiemYTe baoHiemYTe) {
        this.baoHiemYTe = baoHiemYTe;
    }

    public BacSi getBacSi() {
        return bacSi;
    }

    public ThongTinKhamBenh bacSi(BacSi bacSi) {
        this.bacSi = bacSi;
        return this;
    }

    public void setBacSi(BacSi bacSi) {
        this.bacSi = bacSi;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ThongTinKhamBenh)) {
            return false;
        }
        return id != null && id.equals(((ThongTinKhamBenh) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ThongTinKhamBenh{" +
            "id=" + getId() +
            ", masokhambenh=" + getMasokhambenh() +
            ", ngaykham='" + getNgaykham() + "'" +
            ", noikham='" + getNoikham() + "'" +
            ", ngaytaikham='" + getNgaytaikham() + "'" +
            ", lankham=" + getLankham() +
            ", chandoanbenh='" + getChandoanbenh() + "'" +
            "}";
    }
}
