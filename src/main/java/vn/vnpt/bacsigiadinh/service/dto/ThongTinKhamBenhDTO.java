package vn.vnpt.bacsigiadinh.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link vn.vnpt.bacsigiadinh.domain.ThongTinKhamBenh} entity.
 */
public class ThongTinKhamBenhDTO implements Serializable {
    
    private String id;

    private Long masokhambenh;

    private LocalDate ngaykham;

    private String noikham;

    private LocalDate ngaytaikham;

    private Integer lankham;

    private String chandoanbenh;


    private String benhNhanId;

    private String benhNhanMabenhnhan;

    private String baoHiemYTeId;

    private String baoHiemYTeMathebaohiemyte;

    private String bacSiId;

    private String bacSiMabacsi;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMasokhambenh() {
        return masokhambenh;
    }

    public void setMasokhambenh(Long masokhambenh) {
        this.masokhambenh = masokhambenh;
    }

    public LocalDate getNgaykham() {
        return ngaykham;
    }

    public void setNgaykham(LocalDate ngaykham) {
        this.ngaykham = ngaykham;
    }

    public String getNoikham() {
        return noikham;
    }

    public void setNoikham(String noikham) {
        this.noikham = noikham;
    }

    public LocalDate getNgaytaikham() {
        return ngaytaikham;
    }

    public void setNgaytaikham(LocalDate ngaytaikham) {
        this.ngaytaikham = ngaytaikham;
    }

    public Integer getLankham() {
        return lankham;
    }

    public void setLankham(Integer lankham) {
        this.lankham = lankham;
    }

    public String getChandoanbenh() {
        return chandoanbenh;
    }

    public void setChandoanbenh(String chandoanbenh) {
        this.chandoanbenh = chandoanbenh;
    }

    public String getBenhNhanId() {
        return benhNhanId;
    }

    public void setBenhNhanId(String benhNhanId) {
        this.benhNhanId = benhNhanId;
    }

    public String getBenhNhanMabenhnhan() {
        return benhNhanMabenhnhan;
    }

    public void setBenhNhanMabenhnhan(String benhNhanMabenhnhan) {
        this.benhNhanMabenhnhan = benhNhanMabenhnhan;
    }

    public String getBaoHiemYTeId() {
        return baoHiemYTeId;
    }

    public void setBaoHiemYTeId(String baoHiemYTeId) {
        this.baoHiemYTeId = baoHiemYTeId;
    }

    public String getBaoHiemYTeMathebaohiemyte() {
        return baoHiemYTeMathebaohiemyte;
    }

    public void setBaoHiemYTeMathebaohiemyte(String baoHiemYTeMathebaohiemyte) {
        this.baoHiemYTeMathebaohiemyte = baoHiemYTeMathebaohiemyte;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ThongTinKhamBenhDTO thongTinKhamBenhDTO = (ThongTinKhamBenhDTO) o;
        if (thongTinKhamBenhDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), thongTinKhamBenhDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ThongTinKhamBenhDTO{" +
            "id=" + getId() +
            ", masokhambenh=" + getMasokhambenh() +
            ", ngaykham='" + getNgaykham() + "'" +
            ", noikham='" + getNoikham() + "'" +
            ", ngaytaikham='" + getNgaytaikham() + "'" +
            ", lankham=" + getLankham() +
            ", chandoanbenh='" + getChandoanbenh() + "'" +
            ", benhNhanId=" + getBenhNhanId() +
            ", benhNhanMabenhnhan='" + getBenhNhanMabenhnhan() + "'" +
            ", baoHiemYTeId=" + getBaoHiemYTeId() +
            ", baoHiemYTeMathebaohiemyte='" + getBaoHiemYTeMathebaohiemyte() + "'" +
            ", bacSiId=" + getBacSiId() +
            ", bacSiMabacsi='" + getBacSiMabacsi() + "'" +
            "}";
    }
}
