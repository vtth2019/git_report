package vn.vnpt.bacsigiadinh.service.mapper;


import vn.vnpt.bacsigiadinh.domain.*;
import vn.vnpt.bacsigiadinh.service.dto.ThongTinKhamBenhDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ThongTinKhamBenh} and its DTO {@link ThongTinKhamBenhDTO}.
 */
@Mapper(componentModel = "spring", uses = {BenhNhanMapper.class, BaoHiemYTeMapper.class, BacSiMapper.class})
public interface ThongTinKhamBenhMapper extends EntityMapper<ThongTinKhamBenhDTO, ThongTinKhamBenh> {

    @Mapping(source = "benhNhan.id", target = "benhNhanId")
    @Mapping(source = "benhNhan.mabenhnhan", target = "benhNhanMabenhnhan")
    @Mapping(source = "baoHiemYTe.id", target = "baoHiemYTeId")
    @Mapping(source = "baoHiemYTe.mathebaohiemyte", target = "baoHiemYTeMathebaohiemyte")
    @Mapping(source = "bacSi.id", target = "bacSiId")
    @Mapping(source = "bacSi.mabacsi", target = "bacSiMabacsi")
    ThongTinKhamBenhDTO toDto(ThongTinKhamBenh thongTinKhamBenh);

    @Mapping(source = "benhNhanId", target = "benhNhan")
    @Mapping(source = "baoHiemYTeId", target = "baoHiemYTe")
    @Mapping(source = "bacSiId", target = "bacSi")
    ThongTinKhamBenh toEntity(ThongTinKhamBenhDTO thongTinKhamBenhDTO);

    default ThongTinKhamBenh fromId(String id) {
        if (id == null) {
            return null;
        }
        ThongTinKhamBenh thongTinKhamBenh = new ThongTinKhamBenh();
        thongTinKhamBenh.setId(id);
        return thongTinKhamBenh;
    }
}
