package vn.vnpt.bacsigiadinh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class BenhNhanDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BenhNhanDTO.class);
        BenhNhanDTO benhNhanDTO1 = new BenhNhanDTO();
        benhNhanDTO1.setId("id1");
        BenhNhanDTO benhNhanDTO2 = new BenhNhanDTO();
        assertThat(benhNhanDTO1).isNotEqualTo(benhNhanDTO2);
        benhNhanDTO2.setId(benhNhanDTO1.getId());
        assertThat(benhNhanDTO1).isEqualTo(benhNhanDTO2);
        benhNhanDTO2.setId("id2");
        assertThat(benhNhanDTO1).isNotEqualTo(benhNhanDTO2);
        benhNhanDTO1.setId(null);
        assertThat(benhNhanDTO1).isNotEqualTo(benhNhanDTO2);
    }
}
