package vn.vnpt.bacsigiadinh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class BacSiDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BacSiDTO.class);
        BacSiDTO bacSiDTO1 = new BacSiDTO();
        bacSiDTO1.setId("id1");
        BacSiDTO bacSiDTO2 = new BacSiDTO();
        assertThat(bacSiDTO1).isNotEqualTo(bacSiDTO2);
        bacSiDTO2.setId(bacSiDTO1.getId());
        assertThat(bacSiDTO1).isEqualTo(bacSiDTO2);
        bacSiDTO2.setId("id2");
        assertThat(bacSiDTO1).isNotEqualTo(bacSiDTO2);
        bacSiDTO1.setId(null);
        assertThat(bacSiDTO1).isNotEqualTo(bacSiDTO2);
    }
}
