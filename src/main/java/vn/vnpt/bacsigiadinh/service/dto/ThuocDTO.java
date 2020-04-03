package vn.vnpt.bacsigiadinh.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.bacsigiadinh.domain.Thuoc} entity.
 */
public class ThuocDTO implements Serializable {
    
    private String id;

    private String tenthuoc;

    private String loaithuoc;

    private String hoatchat;

    private String hamluong;

    private String nuocsanxuat;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getLoaithuoc() {
        return loaithuoc;
    }

    public void setLoaithuoc(String loaithuoc) {
        this.loaithuoc = loaithuoc;
    }

    public String getHoatchat() {
        return hoatchat;
    }

    public void setHoatchat(String hoatchat) {
        this.hoatchat = hoatchat;
    }

    public String getHamluong() {
        return hamluong;
    }

    public void setHamluong(String hamluong) {
        this.hamluong = hamluong;
    }

    public String getNuocsanxuat() {
        return nuocsanxuat;
    }

    public void setNuocsanxuat(String nuocsanxuat) {
        this.nuocsanxuat = nuocsanxuat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ThuocDTO thuocDTO = (ThuocDTO) o;
        if (thuocDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), thuocDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ThuocDTO{" +
            "id=" + getId() +
            ", tenthuoc='" + getTenthuoc() + "'" +
            ", loaithuoc='" + getLoaithuoc() + "'" +
            ", hoatchat='" + getHoatchat() + "'" +
            ", hamluong='" + getHamluong() + "'" +
            ", nuocsanxuat='" + getNuocsanxuat() + "'" +
            "}";
    }
}
