package vn.vnpt.bacsigiadinh.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 * A BacSi.
 */
@Document(collection = "bac_si")
public class BacSi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("mabacsi")
    private Long mabacsi;

    @Field("hoten")
    private String hoten;

    @Field("gioitinh")
    private String gioitinh;

    @Field("ngaysinh")
    private LocalDate ngaysinh;

    @Field("noilamviec")
    private String noilamviec;

    @Field("chuyenkhoa")
    private String chuyenkhoa;

    @Field("giayphephanhnghe")
    private String giayphephanhnghe;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMabacsi() {
        return mabacsi;
    }

    public BacSi mabacsi(Long mabacsi) {
        this.mabacsi = mabacsi;
        return this;
    }

    public void setMabacsi(Long mabacsi) {
        this.mabacsi = mabacsi;
    }

    public String getHoten() {
        return hoten;
    }

    public BacSi hoten(String hoten) {
        this.hoten = hoten;
        return this;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public BacSi gioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
        return this;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public BacSi ngaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
        return this;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNoilamviec() {
        return noilamviec;
    }

    public BacSi noilamviec(String noilamviec) {
        this.noilamviec = noilamviec;
        return this;
    }

    public void setNoilamviec(String noilamviec) {
        this.noilamviec = noilamviec;
    }

    public String getChuyenkhoa() {
        return chuyenkhoa;
    }

    public BacSi chuyenkhoa(String chuyenkhoa) {
        this.chuyenkhoa = chuyenkhoa;
        return this;
    }

    public void setChuyenkhoa(String chuyenkhoa) {
        this.chuyenkhoa = chuyenkhoa;
    }

    public String getGiayphephanhnghe() {
        return giayphephanhnghe;
    }

    public BacSi giayphephanhnghe(String giayphephanhnghe) {
        this.giayphephanhnghe = giayphephanhnghe;
        return this;
    }

    public void setGiayphephanhnghe(String giayphephanhnghe) {
        this.giayphephanhnghe = giayphephanhnghe;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BacSi)) {
            return false;
        }
        return id != null && id.equals(((BacSi) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BacSi{" +
            "id=" + getId() +
            ", mabacsi=" + getMabacsi() +
            ", hoten='" + getHoten() + "'" +
            ", gioitinh='" + getGioitinh() + "'" +
            ", ngaysinh='" + getNgaysinh() + "'" +
            ", noilamviec='" + getNoilamviec() + "'" +
            ", chuyenkhoa='" + getChuyenkhoa() + "'" +
            ", giayphephanhnghe='" + getGiayphephanhnghe() + "'" +
            "}";
    }
}
