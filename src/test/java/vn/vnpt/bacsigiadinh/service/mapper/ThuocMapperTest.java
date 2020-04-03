package vn.vnpt.bacsigiadinh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThuocMapperTest {

    private ThuocMapper thuocMapper;

    @BeforeEach
    public void setUp() {
        thuocMapper = new ThuocMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(thuocMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(thuocMapper.fromId(null)).isNull();
    }
}
