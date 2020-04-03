package vn.vnpt.bacsigiadinh.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.bacsigiadinh.domain.BenhNhan} entity.
 */
public class BenhNhanDTO implements Serializable {
    
    private String id;

    private Long mabenhnhan;

    private String hoten;

    private Integer tuoi;

    private String diachi;

    private String email;

    private String sodienthoai;

    private Integer mahoso;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMabenhnhan() {
        return mabenhnhan;
    }

    public void setMabenhnhan(Long mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public Integer getMahoso() {
        return mahoso;
    }

    public void setMahoso(Integer mahoso) {
        this.mahoso = mahoso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BenhNhanDTO benhNhanDTO = (BenhNhanDTO) o;
        if (benhNhanDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), benhNhanDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BenhNhanDTO{" +
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
