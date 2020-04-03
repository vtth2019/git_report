package vn.vnpt.bacsigiadinh.service.mapper;


import vn.vnpt.bacsigiadinh.domain.*;
import vn.vnpt.bacsigiadinh.service.dto.BacSiDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BacSi} and its DTO {@link BacSiDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BacSiMapper extends EntityMapper<BacSiDTO, BacSi> {



    default BacSi fromId(String id) {
        if (id == null) {
            return null;
        }
        BacSi bacSi = new BacSi();
        bacSi.setId(id);
        return bacSi;
    }
}
