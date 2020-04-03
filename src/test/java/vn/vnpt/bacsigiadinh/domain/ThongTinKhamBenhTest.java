package vn.vnpt.bacsigiadinh.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import vn.vnpt.bacsigiadinh.web.rest.TestUtil;

public class ThongTinKhamBenhTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ThongTinKhamBenh.class);
        ThongTinKhamBenh thongTinKhamBenh1 = new ThongTinKhamBenh();
        thongTinKhamBenh1.setId("id1");
        ThongTinKhamBenh thongTinKhamBenh2 = new ThongTinKhamBenh();
        thongTinKhamBenh2.setId(thongTinKhamBenh1.getId());
        assertThat(thongTinKhamBenh1).isEqualTo(thongTinKhamBenh2);
        thongTinKhamBenh2.setId("id2");
        assertThat(thongTinKhamBenh1).isNotEqualTo(thongTinKhamBenh2);
        thongTinKhamBenh1.setId(null);
        assertThat(thongTinKhamBenh1).isNotEqualTo(thongTinKhamBenh2);
    }
}
