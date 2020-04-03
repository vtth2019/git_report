package vn.vnpt.bacsigiadinh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ToaThuocMapperTest {

    private ToaThuocMapper toaThuocMapper;

    @BeforeEach
    public void setUp() {
        toaThuocMapper = new ToaThuocMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(toaThuocMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(toaThuocMapper.fromId(null)).isNull();
    }
}
