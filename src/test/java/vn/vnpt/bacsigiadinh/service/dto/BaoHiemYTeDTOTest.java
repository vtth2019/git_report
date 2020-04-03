package vn.vnpt.bacsigiadinh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class BaoHiemYTeDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BaoHiemYTeDTO.class);
        BaoHiemYTeDTO baoHiemYTeDTO1 = new BaoHiemYTeDTO();
        baoHiemYTeDTO1.setId("id1");
        BaoHiemYTeDTO baoHiemYTeDTO2 = new BaoHiemYTeDTO();
        assertThat(baoHiemYTeDTO1).isNotEqualTo(baoHiemYTeDTO2);
        baoHiemYTeDTO2.setId(baoHiemYTeDTO1.getId());
        assertThat(baoHiemYTeDTO1).isEqualTo(baoHiemYTeDTO2);
        baoHiemYTeDTO2.setId("id2");
        assertThat(baoHiemYTeDTO1).isNotEqualTo(baoHiemYTeDTO2);
        baoHiemYTeDTO1.setId(null);
        assertThat(baoHiemYTeDTO1).isNotEqualTo(baoHiemYTeDTO2);
    }
}
