package vn.vnpt.bacsigiadinh.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class BacSiTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BacSi.class);
        BacSi bacSi1 = new BacSi();
        bacSi1.setId("id1");
        BacSi bacSi2 = new BacSi();
        bacSi2.setId(bacSi1.getId());
        assertThat(bacSi1).isEqualTo(bacSi2);
        bacSi2.setId("id2");
        assertThat(bacSi1).isNotEqualTo(bacSi2);
        bacSi1.setId(null);
        assertThat(bacSi1).isNotEqualTo(bacSi2);
    }
}
