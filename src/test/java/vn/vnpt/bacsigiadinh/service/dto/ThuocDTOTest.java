package vn.vnpt.bacsigiadinh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class ThuocDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ThuocDTO.class);
        ThuocDTO thuocDTO1 = new ThuocDTO();
        thuocDTO1.setId("id1");
        ThuocDTO thuocDTO2 = new ThuocDTO();
        assertThat(thuocDTO1).isNotEqualTo(thuocDTO2);
        thuocDTO2.setId(thuocDTO1.getId());
        assertThat(thuocDTO1).isEqualTo(thuocDTO2);
        thuocDTO2.setId("id2");
        assertThat(thuocDTO1).isNotEqualTo(thuocDTO2);
        thuocDTO1.setId(null);
        assertThat(thuocDTO1).isNotEqualTo(thuocDTO2);
    }
}
