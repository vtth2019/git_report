package vn.vnpt.bacsigiadinh.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.bacsigiadinh.domain.BaoHiemYTe} entity.
 */
public class BaoHiemYTeDTO implements Serializable {
    
    private String id;

    private String mathebaohiemyte;

    private String noidangky;

    private LocalDate tungay;

    private LocalDate denngay;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMathebaohiemyte() {
        return mathebaohiemyte;
    }

    public void setMathebaohiemyte(String mathebaohiemyte) {
        this.mathebaohiemyte = mathebaohiemyte;
    }

    public String getNoidangky() {
        return noidangky;
    }

    public void setNoidangky(String noidangky) {
        this.noidangky = noidangky;
    }

    public LocalDate getTungay() {
        return tungay;
    }

    public void setTungay(LocalDate tungay) {
        this.tungay = tungay;
    }

    public LocalDate getDenngay() {
        return denngay;
    }

    public void setDenngay(LocalDate denngay) {
        this.denngay = denngay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaoHiemYTeDTO baoHiemYTeDTO = (BaoHiemYTeDTO) o;
        if (baoHiemYTeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baoHiemYTeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaoHiemYTeDTO{" +
            "id=" + getId() +
            ", mathebaohiemyte='" + getMathebaohiemyte() + "'" +
            ", noidangky='" + getNoidangky() + "'" +
            ", tungay='" + getTungay() + "'" +
            ", denngay='" + getDenngay() + "'" +
            "}";
    }
}
