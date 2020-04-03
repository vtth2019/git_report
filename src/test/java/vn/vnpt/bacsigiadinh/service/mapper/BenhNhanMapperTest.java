package vn.vnpt.bacsigiadinh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BenhNhanMapperTest {

    private BenhNhanMapper benhNhanMapper;

    @BeforeEach
    public void setUp() {
        benhNhanMapper = new BenhNhanMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(benhNhanMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(benhNhanMapper.fromId(null)).isNull();
    }
}
