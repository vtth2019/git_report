package vn.vnpt.bacsigiadinh.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class ToaThuocTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ToaThuoc.class);
        ToaThuoc toaThuoc1 = new ToaThuoc();
        toaThuoc1.setId("id1");
        ToaThuoc toaThuoc2 = new ToaThuoc();
        toaThuoc2.setId(toaThuoc1.getId());
        assertThat(toaThuoc1).isEqualTo(toaThuoc2);
        toaThuoc2.setId("id2");
        assertThat(toaThuoc1).isNotEqualTo(toaThuoc2);
        toaThuoc1.setId(null);
        assertThat(toaThuoc1).isNotEqualTo(toaThuoc2);
    }
}
