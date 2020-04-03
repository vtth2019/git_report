package vn.vnpt.bacsigiadinh.service.mapper;


import vn.vnpt.bacsigiadinh.domain.*;
import vn.vnpt.bacsigiadinh.service.dto.ThuocDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Thuoc} and its DTO {@link ThuocDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ThuocMapper extends EntityMapper<ThuocDTO, Thuoc> {



    default Thuoc fromId(String id) {
        if (id == null) {
            return null;
        }
        Thuoc thuoc = new Thuoc();
        thuoc.setId(id);
        return thuoc;
    }
}
