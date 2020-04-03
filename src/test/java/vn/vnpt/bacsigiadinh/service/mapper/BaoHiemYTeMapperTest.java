package vn.vnpt.bacsigiadinh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BaoHiemYTeMapperTest {

    private BaoHiemYTeMapper baoHiemYTeMapper;

    @BeforeEach
    public void setUp() {
        baoHiemYTeMapper = new BaoHiemYTeMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(baoHiemYTeMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(baoHiemYTeMapper.fromId(null)).isNull();
    }
}
