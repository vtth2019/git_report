package vn.vnpt.bacsigiadinh.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class BaoHiemYTeTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BaoHiemYTe.class);
        BaoHiemYTe baoHiemYTe1 = new BaoHiemYTe();
        baoHiemYTe1.setId("id1");
        BaoHiemYTe baoHiemYTe2 = new BaoHiemYTe();
        baoHiemYTe2.setId(baoHiemYTe1.getId());
        assertThat(baoHiemYTe1).isEqualTo(baoHiemYTe2);
        baoHiemYTe2.setId("id2");
        assertThat(baoHiemYTe1).isNotEqualTo(baoHiemYTe2);
        baoHiemYTe1.setId(null);
        assertThat(baoHiemYTe1).isNotEqualTo(baoHiemYTe2);
    }
}
