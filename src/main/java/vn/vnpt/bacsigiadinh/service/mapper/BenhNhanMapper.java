package vn.vnpt.bacsigiadinh.service.mapper;


import vn.vnpt.bacsigiadinh.domain.*;
import vn.vnpt.bacsigiadinh.service.dto.BenhNhanDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BenhNhan} and its DTO {@link BenhNhanDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BenhNhanMapper extends EntityMapper<BenhNhanDTO, BenhNhan> {



    default BenhNhan fromId(String id) {
        if (id == null) {
            return null;
        }
        BenhNhan benhNhan = new BenhNhan();
        benhNhan.setId(id);
        return benhNhan;
    }
}
