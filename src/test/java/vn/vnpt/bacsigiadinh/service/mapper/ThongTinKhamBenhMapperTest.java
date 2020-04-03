package vn.vnpt.bacsigiadinh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThongTinKhamBenhMapperTest {

    private ThongTinKhamBenhMapper thongTinKhamBenhMapper;

    @BeforeEach
    public void setUp() {
        thongTinKhamBenhMapper = new ThongTinKhamBenhMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(thongTinKhamBenhMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(thongTinKhamBenhMapper.fromId(null)).isNull();
    }
}
