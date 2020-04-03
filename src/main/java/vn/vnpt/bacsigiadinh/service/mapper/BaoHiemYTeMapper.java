package vn.vnpt.bacsigiadinh.service.mapper;


import vn.vnpt.bacsigiadinh.domain.*;
import vn.vnpt.bacsigiadinh.service.dto.BaoHiemYTeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BaoHiemYTe} and its DTO {@link BaoHiemYTeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BaoHiemYTeMapper extends EntityMapper<BaoHiemYTeDTO, BaoHiemYTe> {



    default BaoHiemYTe fromId(String id) {
        if (id == null) {
            return null;
        }
        BaoHiemYTe baoHiemYTe = new BaoHiemYTe();
        baoHiemYTe.setId(id);
        return baoHiemYTe;
    }
}
