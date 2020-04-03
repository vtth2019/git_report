package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.HosobacsigiadinhApp;
import vn.vnpt.bacsigiadinh.config.SecurityBeanOverrideConfiguration;
import vn.vnpt.bacsigiadinh.domain.BacSi;
import vn.vnpt.bacsigiadinh.repository.BacSiRepository;
import vn.vnpt.bacsigiadinh.service.BacSiService;
import vn.vnpt.bacsigiadinh.service.dto.BacSiDTO;
import vn.vnpt.bacsigiadinh.service.mapper.BacSiMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link BacSiResource} REST controller.
 */
@SpringBootTest(classes = { SecurityBeanOverrideConfiguration.class, HosobacsigiadinhApp.class })

@AutoConfigureMockMvc
@WithMockUser
public class BacSiResourceIT {

    private static final Long DEFAULT_MABACSI = 1L;
    private static final Long UPDATED_MABACSI = 2L;

    private static final String DEFAULT_HOTEN = "AAAAAAAAAA";
    private static final String UPDATED_HOTEN = "BBBBBBBBBB";

    private static final String DEFAULT_GIOITINH = "AAAAAAAAAA";
    private static final String UPDATED_GIOITINH = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_NGAYSINH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_NGAYSINH = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NOILAMVIEC = "AAAAAAAAAA";
    private static final String UPDATED_NOILAMVIEC = "BBBBBBBBBB";

    private static final String DEFAULT_CHUYENKHOA = "AAAAAAAAAA";
    private static final String UPDATED_CHUYENKHOA = "BBBBBBBBBB";

    private static final String DEFAULT_GIAYPHEPHANHNGHE = "AAAAAAAAAA";
    private static final String UPDATED_GIAYPHEPHANHNGHE = "BBBBBBBBBB";

    @Autowired
    private BacSiRepository bacSiRepository;

    @Autowired
    private BacSiMapper bacSiMapper;

    @Autowired
    private BacSiService bacSiService;

    @Autowired
    private MockMvc restBacSiMockMvc;

    private BacSi bacSi;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BacSi createEntity() {
        BacSi bacSi = new BacSi()
            .mabacsi(DEFAULT_MABACSI)
            .hoten(DEFAULT_HOTEN)
            .gioitinh(DEFAULT_GIOITINH)
            .ngaysinh(DEFAULT_NGAYSINH)
            .noilamviec(DEFAULT_NOILAMVIEC)
            .chuyenkhoa(DEFAULT_CHUYENKHOA)
            .giayphephanhnghe(DEFAULT_GIAYPHEPHANHNGHE);
        return bacSi;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BacSi createUpdatedEntity() {
        BacSi bacSi = new BacSi()
            .mabacsi(UPDATED_MABACSI)
            .hoten(UPDATED_HOTEN)
            .gioitinh(UPDATED_GIOITINH)
            .ngaysinh(UPDATED_NGAYSINH)
            .noilamviec(UPDATED_NOILAMVIEC)
            .chuyenkhoa(UPDATED_CHUYENKHOA)
            .giayphephanhnghe(UPDATED_GIAYPHEPHANHNGHE);
        return bacSi;
    }

    @BeforeEach
    public void initTest() {
        bacSiRepository.deleteAll();
        bacSi = createEntity();
    }

    @Test
    public void createBacSi() throws Exception {
        int databaseSizeBeforeCreate = bacSiRepository.findAll().size();

        // Create the BacSi
        BacSiDTO bacSiDTO = bacSiMapper.toDto(bacSi);
        restBacSiMockMvc.perform(post("/api/bac-sis").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bacSiDTO)))
            .andExpect(status().isCreated());

        // Validate the BacSi in the database
        List<BacSi> bacSiList = bacSiRepository.findAll();
        assertThat(bacSiList).hasSize(databaseSizeBeforeCreate + 1);
        BacSi testBacSi = bacSiList.get(bacSiList.size() - 1);
        assertThat(testBacSi.getMabacsi()).isEqualTo(DEFAULT_MABACSI);
        assertThat(testBacSi.getHoten()).isEqualTo(DEFAULT_HOTEN);
        assertThat(testBacSi.getGioitinh()).isEqualTo(DEFAULT_GIOITINH);
        assertThat(testBacSi.getNgaysinh()).isEqualTo(DEFAULT_NGAYSINH);
        assertThat(testBacSi.getNoilamviec()).isEqualTo(DEFAULT_NOILAMVIEC);
        assertThat(testBacSi.getChuyenkhoa()).isEqualTo(DEFAULT_CHUYENKHOA);
        assertThat(testBacSi.getGiayphephanhnghe()).isEqualTo(DEFAULT_GIAYPHEPHANHNGHE);
    }

    @Test
    public void createBacSiWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bacSiRepository.findAll().size();

        // Create the BacSi with an existing ID
        bacSi.setId("existing_id");
        BacSiDTO bacSiDTO = bacSiMapper.toDto(bacSi);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBacSiMockMvc.perform(post("/api/bac-sis").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bacSiDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BacSi in the database
        List<BacSi> bacSiList = bacSiRepository.findAll();
        assertThat(bacSiList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllBacSis() throws Exception {
        // Initialize the database
        bacSiRepository.save(bacSi);

        // Get all the bacSiList
        restBacSiMockMvc.perform(get("/api/bac-sis?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bacSi.getId())))
            .andExpect(jsonPath("$.[*].mabacsi").value(hasItem(DEFAULT_MABACSI.intValue())))
            .andExpect(jsonPath("$.[*].hoten").value(hasItem(DEFAULT_HOTEN)))
            .andExpect(jsonPath("$.[*].gioitinh").value(hasItem(DEFAULT_GIOITINH)))
            .andExpect(jsonPath("$.[*].ngaysinh").value(hasItem(DEFAULT_NGAYSINH.toString())))
            .andExpect(jsonPath("$.[*].noilamviec").value(hasItem(DEFAULT_NOILAMVIEC)))
            .andExpect(jsonPath("$.[*].chuyenkhoa").value(hasItem(DEFAULT_CHUYENKHOA)))
            .andExpect(jsonPath("$.[*].giayphephanhnghe").value(hasItem(DEFAULT_GIAYPHEPHANHNGHE)));
    }
    
    @Test
    public void getBacSi() throws Exception {
        // Initialize the database
        bacSiRepository.save(bacSi);

        // Get the bacSi
        restBacSiMockMvc.perform(get("/api/bac-sis/{id}", bacSi.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bacSi.getId()))
            .andExpect(jsonPath("$.mabacsi").value(DEFAULT_MABACSI.intValue()))
            .andExpect(jsonPath("$.hoten").value(DEFAULT_HOTEN))
            .andExpect(jsonPath("$.gioitinh").value(DEFAULT_GIOITINH))
            .andExpect(jsonPath("$.ngaysinh").value(DEFAULT_NGAYSINH.toString()))
            .andExpect(jsonPath("$.noilamviec").value(DEFAULT_NOILAMVIEC))
            .andExpect(jsonPath("$.chuyenkhoa").value(DEFAULT_CHUYENKHOA))
            .andExpect(jsonPath("$.giayphephanhnghe").value(DEFAULT_GIAYPHEPHANHNGHE));
    }

    @Test
    public void getNonExistingBacSi() throws Exception {
        // Get the bacSi
        restBacSiMockMvc.perform(get("/api/bac-sis/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateBacSi() throws Exception {
        // Initialize the database
        bacSiRepository.save(bacSi);

        int databaseSizeBeforeUpdate = bacSiRepository.findAll().size();

        // Update the bacSi
        BacSi updatedBacSi = bacSiRepository.findById(bacSi.getId()).get();
        updatedBacSi
            .mabacsi(UPDATED_MABACSI)
            .hoten(UPDATED_HOTEN)
            .gioitinh(UPDATED_GIOITINH)
            .ngaysinh(UPDATED_NGAYSINH)
            .noilamviec(UPDATED_NOILAMVIEC)
            .chuyenkhoa(UPDATED_CHUYENKHOA)
            .giayphephanhnghe(UPDATED_GIAYPHEPHANHNGHE);
        BacSiDTO bacSiDTO = bacSiMapper.toDto(updatedBacSi);

        restBacSiMockMvc.perform(put("/api/bac-sis").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bacSiDTO)))
            .andExpect(status().isOk());

        // Validate the BacSi in the database
        List<BacSi> bacSiList = bacSiRepository.findAll();
        assertThat(bacSiList).hasSize(databaseSizeBeforeUpdate);
        BacSi testBacSi = bacSiList.get(bacSiList.size() - 1);
        assertThat(testBacSi.getMabacsi()).isEqualTo(UPDATED_MABACSI);
        assertThat(testBacSi.getHoten()).isEqualTo(UPDATED_HOTEN);
        assertThat(testBacSi.getGioitinh()).isEqualTo(UPDATED_GIOITINH);
        assertThat(testBacSi.getNgaysinh()).isEqualTo(UPDATED_NGAYSINH);
        assertThat(testBacSi.getNoilamviec()).isEqualTo(UPDATED_NOILAMVIEC);
        assertThat(testBacSi.getChuyenkhoa()).isEqualTo(UPDATED_CHUYENKHOA);
        assertThat(testBacSi.getGiayphephanhnghe()).isEqualTo(UPDATED_GIAYPHEPHANHNGHE);
    }

    @Test
    public void updateNonExistingBacSi() throws Exception {
        int databaseSizeBeforeUpdate = bacSiRepository.findAll().size();

        // Create the BacSi
        BacSiDTO bacSiDTO = bacSiMapper.toDto(bacSi);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBacSiMockMvc.perform(put("/api/bac-sis").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bacSiDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BacSi in the database
        List<BacSi> bacSiList = bacSiRepository.findAll();
        assertThat(bacSiList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteBacSi() throws Exception {
        // Initialize the database
        bacSiRepository.save(bacSi);

        int databaseSizeBeforeDelete = bacSiRepository.findAll().size();

        // Delete the bacSi
        restBacSiMockMvc.perform(delete("/api/bac-sis/{id}", bacSi.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BacSi> bacSiList = bacSiRepository.findAll();
        assertThat(bacSiList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
