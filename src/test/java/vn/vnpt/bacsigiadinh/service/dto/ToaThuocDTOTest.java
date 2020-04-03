package vn.vnpt.bacsigiadinh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class ToaThuocDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ToaThuocDTO.class);
        ToaThuocDTO toaThuocDTO1 = new ToaThuocDTO();
        toaThuocDTO1.setId("id1");
        ToaThuocDTO toaThuocDTO2 = new ToaThuocDTO();
        assertThat(toaThuocDTO1).isNotEqualTo(toaThuocDTO2);
        toaThuocDTO2.setId(toaThuocDTO1.getId());
        assertThat(toaThuocDTO1).isEqualTo(toaThuocDTO2);
        toaThuocDTO2.setId("id2");
        assertThat(toaThuocDTO1).isNotEqualTo(toaThuocDTO2);
        toaThuocDTO1.setId(null);
        assertThat(toaThuocDTO1).isNotEqualTo(toaThuocDTO2);
    }
}
