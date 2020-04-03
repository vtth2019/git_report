package vn.vnpt.bacsigiadinh.service.mapper;


import vn.vnpt.bacsigiadinh.domain.*;
import vn.vnpt.bacsigiadinh.service.dto.ToaThuocDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ToaThuoc} and its DTO {@link ToaThuocDTO}.
 */
@Mapper(componentModel = "spring", uses = {ThongTinKhamBenhMapper.class, BacSiMapper.class, ThuocMapper.class})
public interface ToaThuocMapper extends EntityMapper<ToaThuocDTO, ToaThuoc> {

    @Mapping(source = "sokhambenh.id", target = "sokhambenhId")
    @Mapping(source = "sokhambenh.masokhambenh", target = "sokhambenhMasokhambenh")
    @Mapping(source = "bacSi.id", target = "bacSiId")
    @Mapping(source = "bacSi.mabacsi", target = "bacSiMabacsi")
    ToaThuocDTO toDto(ToaThuoc toaThuoc);

    @Mapping(source = "sokhambenhId", target = "sokhambenh")
    @Mapping(source = "bacSiId", target = "bacSi")
    @Mapping(target = "removeThuoc", ignore = true)
    ToaThuoc toEntity(ToaThuocDTO toaThuocDTO);

    default ToaThuoc fromId(String id) {
        if (id == null) {
            return null;
        }
        ToaThuoc toaThuoc = new ToaThuoc();
        toaThuoc.setId(id);
        return toaThuoc;
    }
}
