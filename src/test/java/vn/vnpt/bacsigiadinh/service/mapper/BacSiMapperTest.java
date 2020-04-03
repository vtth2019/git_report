package vn.vnpt.bacsigiadinh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BacSiMapperTest {

    private BacSiMapper bacSiMapper;

    @BeforeEach
    public void setUp() {
        bacSiMapper = new BacSiMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(bacSiMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bacSiMapper.fromId(null)).isNull();
    }
}
