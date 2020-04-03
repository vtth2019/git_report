package vn.vnpt.bacsigiadinh.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class BenhNhanTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BenhNhan.class);
        BenhNhan benhNhan1 = new BenhNhan();
        benhNhan1.setId("id1");
        BenhNhan benhNhan2 = new BenhNhan();
        benhNhan2.setId(benhNhan1.getId());
        assertThat(benhNhan1).isEqualTo(benhNhan2);
        benhNhan2.setId("id2");
        assertThat(benhNhan1).isNotEqualTo(benhNhan2);
        benhNhan1.setId(null);
        assertThat(benhNhan1).isNotEqualTo(benhNhan2);
    }
}
