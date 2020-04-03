package vn.vnpt.bacsigiadinh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class ThongTinKhamBenhDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ThongTinKhamBenhDTO.class);
        ThongTinKhamBenhDTO thongTinKhamBenhDTO1 = new ThongTinKhamBenhDTO();
        thongTinKhamBenhDTO1.setId("id1");
        ThongTinKhamBenhDTO thongTinKhamBenhDTO2 = new ThongTinKhamBenhDTO();
        assertThat(thongTinKhamBenhDTO1).isNotEqualTo(thongTinKhamBenhDTO2);
        thongTinKhamBenhDTO2.setId(thongTinKhamBenhDTO1.getId());
        assertThat(thongTinKhamBenhDTO1).isEqualTo(thongTinKhamBenhDTO2);
        thongTinKhamBenhDTO2.setId("id2");
        assertThat(thongTinKhamBenhDTO1).isNotEqualTo(thongTinKhamBenhDTO2);
        thongTinKhamBenhDTO1.setId(null);
        assertThat(thongTinKhamBenhDTO1).isNotEqualTo(thongTinKhamBenhDTO2);
    }
}
