package vn.vnpt.bacsigiadinh.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class ThuocTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Thuoc.class);
        Thuoc thuoc1 = new Thuoc();
        thuoc1.setId("id1");
        Thuoc thuoc2 = new Thuoc();
        thuoc2.setId(thuoc1.getId());
        assertThat(thuoc1).isEqualTo(thuoc2);
        thuoc2.setId("id2");
        assertThat(thuoc1).isNotEqualTo(thuoc2);
        thuoc1.setId(null);
        assertThat(thuoc1).isNotEqualTo(thuoc2);
    }
}
