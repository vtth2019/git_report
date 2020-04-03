package vn.vnpt.bacsigiadinh.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.bacsigiadinh.domain.ToaThuoc} entity.
 */
public class ToaThuocDTO implements Serializable {
    
    private String id;

    private String chandoanbenh;

    private String lieuluong;


    private String sokhambenhId;

    private String sokhambenhMasokhambenh;

    private String bacSiId;

    private String bacSiMabacsi;
    private Set<ThuocDTO> thuocs = new HashSet<>();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChandoanbenh() {
        return chandoanbenh;
    }

    public void setChandoanbenh(String chandoanbenh) {
        this.chandoanbenh = chandoanbenh;
    }

    public String getLieuluong() {
        return lieuluong;
    }

    public void setLieuluong(String lieuluong) {
        this.lieuluong = lieuluong;
    }

    public String getSokhambenhId() {
        return sokhambenhId;
    }

    public void setSokhambenhId(String thongTinKhamBenhId) {
        this.sokhambenhId = thongTinKhamBenhId;
    }

    public String getSokhambenhMasokhambenh() {
        return sokhambenhMasokhambenh;
    }

    public void setSokhambenhMasokhambenh(String thongTinKhamBenhMasokhambenh) {
        this.sokhambenhMasokhambenh = thongTinKhamBenhMasokhambenh;
    }

    public String getBacSiId() {
        return bacSiId;
    }

    public void setBacSiId(String bacSiId) {
        this.bacSiId = bacSiId;
    }

    public String getBacSiMabacsi() {
        return bacSiMabacsi;
    }

    public void setBacSiMabacsi(String bacSiMabacsi) {
        this.bacSiMabacsi = bacSiMabacsi;
    }

    public Set<ThuocDTO> getThuocs() {
        return thuocs;
    }

    public void setThuocs(Set<ThuocDTO> thuocs) {
        this.thuocs = thuocs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ToaThuocDTO toaThuocDTO = (ToaThuocDTO) o;
        if (toaThuocDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), toaThuocDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ToaThuocDTO{" +
            "id=" + getId() +
            ", chandoanbenh='" + getChandoanbenh() + "'" +
            ", lieuluong='" + getLieuluong() + "'" +
            ", sokhambenhId=" + getSokhambenhId() +
            ", sokhambenhMasokhambenh='" + getSokhambenhMasokhambenh() + "'" +
            ", bacSiId=" + getBacSiId() +
            ", bacSiMabacsi='" + getBacSiMabacsi() + "'" +
            ", thuocs='" + getThuocs() + "'" +
            "}";
    }
}
