package vn.vnpt.bacsigiadinh.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.bacsigiadinh.domain.BacSi} entity.
 */
public class BacSiDTO implements Serializable {
    
    private String id;

    private Long mabacsi;

    private String hoten;

    private String gioitinh;

    private LocalDate ngaysinh;

    private String noilamviec;

    private String chuyenkhoa;

    private String giayphephanhnghe;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMabacsi() {
        return mabacsi;
    }

    public void setMabacsi(Long mabacsi) {
        this.mabacsi = mabacsi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNoilamviec() {
        return noilamviec;
    }

    public void setNoilamviec(String noilamviec) {
        this.noilamviec = noilamviec;
    }

    public String getChuyenkhoa() {
        return chuyenkhoa;
    }

    public void setChuyenkhoa(String chuyenkhoa) {
        this.chuyenkhoa = chuyenkhoa;
    }

    public String getGiayphephanhnghe() {
        return giayphephanhnghe;
    }

    public void setGiayphephanhnghe(String giayphephanhnghe) {
        this.giayphephanhnghe = giayphephanhnghe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BacSiDTO bacSiDTO = (BacSiDTO) o;
        if (bacSiDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bacSiDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BacSiDTO{" +
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
