package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.HosobacsigiadinhApp;
import vn.vnpt.bacsigiadinh.config.SecurityBeanOverrideConfiguration;
import vn.vnpt.bacsigiadinh.domain.ThongTinKhamBenh;
import vn.vnpt.bacsigiadinh.repository.ThongTinKhamBenhRepository;
import vn.vnpt.bacsigiadinh.service.ThongTinKhamBenhService;
import vn.vnpt.bacsigiadinh.service.dto.ThongTinKhamBenhDTO;
import vn.vnpt.bacsigiadinh.service.mapper.ThongTinKhamBenhMapper;

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
 * Integration tests for the {@link ThongTinKhamBenhResource} REST controller.
 */
@SpringBootTest(classes = { SecurityBeanOverrideConfiguration.class, HosobacsigiadinhApp.class })

@AutoConfigureMockMvc
@WithMockUser
public class ThongTinKhamBenhResourceIT {

    private static final Long DEFAULT_MASOKHAMBENH = 1L;
    private static final Long UPDATED_MASOKHAMBENH = 2L;

    private static final LocalDate DEFAULT_NGAYKHAM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_NGAYKHAM = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NOIKHAM = "AAAAAAAAAA";
    private static final String UPDATED_NOIKHAM = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_NGAYTAIKHAM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_NGAYTAIKHAM = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_LANKHAM = 1;
    private static final Integer UPDATED_LANKHAM = 2;

    private static final String DEFAULT_CHANDOANBENH = "AAAAAAAAAA";
    private static final String UPDATED_CHANDOANBENH = "BBBBBBBBBB";

    @Autowired
    private ThongTinKhamBenhRepository thongTinKhamBenhRepository;

    @Autowired
    private ThongTinKhamBenhMapper thongTinKhamBenhMapper;

    @Autowired
    private ThongTinKhamBenhService thongTinKhamBenhService;

    @Autowired
    private MockMvc restThongTinKhamBenhMockMvc;

    private ThongTinKhamBenh thongTinKhamBenh;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ThongTinKhamBenh createEntity() {
        ThongTinKhamBenh thongTinKhamBenh = new ThongTinKhamBenh()
            .masokhambenh(DEFAULT_MASOKHAMBENH)
            .ngaykham(DEFAULT_NGAYKHAM)
            .noikham(DEFAULT_NOIKHAM)
            .ngaytaikham(DEFAULT_NGAYTAIKHAM)
            .lankham(DEFAULT_LANKHAM)
            .chandoanbenh(DEFAULT_CHANDOANBENH);
        return thongTinKhamBenh;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ThongTinKhamBenh createUpdatedEntity() {
        ThongTinKhamBenh thongTinKhamBenh = new ThongTinKhamBenh()
            .masokhambenh(UPDATED_MASOKHAMBENH)
            .ngaykham(UPDATED_NGAYKHAM)
            .noikham(UPDATED_NOIKHAM)
            .ngaytaikham(UPDATED_NGAYTAIKHAM)
            .lankham(UPDATED_LANKHAM)
            .chandoanbenh(UPDATED_CHANDOANBENH);
        return thongTinKhamBenh;
    }

    @BeforeEach
    public void initTest() {
        thongTinKhamBenhRepository.deleteAll();
        thongTinKhamBenh = createEntity();
    }

    @Test
    public void createThongTinKhamBenh() throws Exception {
        int databaseSizeBeforeCreate = thongTinKhamBenhRepository.findAll().size();

        // Create the ThongTinKhamBenh
        ThongTinKhamBenhDTO thongTinKhamBenhDTO = thongTinKhamBenhMapper.toDto(thongTinKhamBenh);
        restThongTinKhamBenhMockMvc.perform(post("/api/thong-tin-kham-benhs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thongTinKhamBenhDTO)))
            .andExpect(status().isCreated());

        // Validate the ThongTinKhamBenh in the database
        List<ThongTinKhamBenh> thongTinKhamBenhList = thongTinKhamBenhRepository.findAll();
        assertThat(thongTinKhamBenhList).hasSize(databaseSizeBeforeCreate + 1);
        ThongTinKhamBenh testThongTinKhamBenh = thongTinKhamBenhList.get(thongTinKhamBenhList.size() - 1);
        assertThat(testThongTinKhamBenh.getMasokhambenh()).isEqualTo(DEFAULT_MASOKHAMBENH);
        assertThat(testThongTinKhamBenh.getNgaykham()).isEqualTo(DEFAULT_NGAYKHAM);
        assertThat(testThongTinKhamBenh.getNoikham()).isEqualTo(DEFAULT_NOIKHAM);
        assertThat(testThongTinKhamBenh.getNgaytaikham()).isEqualTo(DEFAULT_NGAYTAIKHAM);
        assertThat(testThongTinKhamBenh.getLankham()).isEqualTo(DEFAULT_LANKHAM);
        assertThat(testThongTinKhamBenh.getChandoanbenh()).isEqualTo(DEFAULT_CHANDOANBENH);
    }

    @Test
    public void createThongTinKhamBenhWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = thongTinKhamBenhRepository.findAll().size();

        // Create the ThongTinKhamBenh with an existing ID
        thongTinKhamBenh.setId("existing_id");
        ThongTinKhamBenhDTO thongTinKhamBenhDTO = thongTinKhamBenhMapper.toDto(thongTinKhamBenh);

        // An entity with an existing ID cannot be created, so this API call must fail
        restThongTinKhamBenhMockMvc.perform(post("/api/thong-tin-kham-benhs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thongTinKhamBenhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ThongTinKhamBenh in the database
        List<ThongTinKhamBenh> thongTinKhamBenhList = thongTinKhamBenhRepository.findAll();
        assertThat(thongTinKhamBenhList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllThongTinKhamBenhs() throws Exception {
        // Initialize the database
        thongTinKhamBenhRepository.save(thongTinKhamBenh);

        // Get all the thongTinKhamBenhList
        restThongTinKhamBenhMockMvc.perform(get("/api/thong-tin-kham-benhs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(thongTinKhamBenh.getId())))
            .andExpect(jsonPath("$.[*].masokhambenh").value(hasItem(DEFAULT_MASOKHAMBENH.intValue())))
            .andExpect(jsonPath("$.[*].ngaykham").value(hasItem(DEFAULT_NGAYKHAM.toString())))
            .andExpect(jsonPath("$.[*].noikham").value(hasItem(DEFAULT_NOIKHAM)))
            .andExpect(jsonPath("$.[*].ngaytaikham").value(hasItem(DEFAULT_NGAYTAIKHAM.toString())))
            .andExpect(jsonPath("$.[*].lankham").value(hasItem(DEFAULT_LANKHAM)))
            .andExpect(jsonPath("$.[*].chandoanbenh").value(hasItem(DEFAULT_CHANDOANBENH)));
    }
    
    @Test
    public void getThongTinKhamBenh() throws Exception {
        // Initialize the database
        thongTinKhamBenhRepository.save(thongTinKhamBenh);

        // Get the thongTinKhamBenh
        restThongTinKhamBenhMockMvc.perform(get("/api/thong-tin-kham-benhs/{id}", thongTinKhamBenh.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(thongTinKhamBenh.getId()))
            .andExpect(jsonPath("$.masokhambenh").value(DEFAULT_MASOKHAMBENH.intValue()))
            .andExpect(jsonPath("$.ngaykham").value(DEFAULT_NGAYKHAM.toString()))
            .andExpect(jsonPath("$.noikham").value(DEFAULT_NOIKHAM))
            .andExpect(jsonPath("$.ngaytaikham").value(DEFAULT_NGAYTAIKHAM.toString()))
            .andExpect(jsonPath("$.lankham").value(DEFAULT_LANKHAM))
            .andExpect(jsonPath("$.chandoanbenh").value(DEFAULT_CHANDOANBENH));
    }

    @Test
    public void getNonExistingThongTinKhamBenh() throws Exception {
        // Get the thongTinKhamBenh
        restThongTinKhamBenhMockMvc.perform(get("/api/thong-tin-kham-benhs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateThongTinKhamBenh() throws Exception {
        // Initialize the database
        thongTinKhamBenhRepository.save(thongTinKhamBenh);

        int databaseSizeBeforeUpdate = thongTinKhamBenhRepository.findAll().size();

        // Update the thongTinKhamBenh
        ThongTinKhamBenh updatedThongTinKhamBenh = thongTinKhamBenhRepository.findById(thongTinKhamBenh.getId()).get();
        updatedThongTinKhamBenh
            .masokhambenh(UPDATED_MASOKHAMBENH)
            .ngaykham(UPDATED_NGAYKHAM)
            .noikham(UPDATED_NOIKHAM)
            .ngaytaikham(UPDATED_NGAYTAIKHAM)
            .lankham(UPDATED_LANKHAM)
            .chandoanbenh(UPDATED_CHANDOANBENH);
        ThongTinKhamBenhDTO thongTinKhamBenhDTO = thongTinKhamBenhMapper.toDto(updatedThongTinKhamBenh);

        restThongTinKhamBenhMockMvc.perform(put("/api/thong-tin-kham-benhs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thongTinKhamBenhDTO)))
            .andExpect(status().isOk());

        // Validate the ThongTinKhamBenh in the database
        List<ThongTinKhamBenh> thongTinKhamBenhList = thongTinKhamBenhRepository.findAll();
        assertThat(thongTinKhamBenhList).hasSize(databaseSizeBeforeUpdate);
        ThongTinKhamBenh testThongTinKhamBenh = thongTinKhamBenhList.get(thongTinKhamBenhList.size() - 1);
        assertThat(testThongTinKhamBenh.getMasokhambenh()).isEqualTo(UPDATED_MASOKHAMBENH);
        assertThat(testThongTinKhamBenh.getNgaykham()).isEqualTo(UPDATED_NGAYKHAM);
        assertThat(testThongTinKhamBenh.getNoikham()).isEqualTo(UPDATED_NOIKHAM);
        assertThat(testThongTinKhamBenh.getNgaytaikham()).isEqualTo(UPDATED_NGAYTAIKHAM);
        assertThat(testThongTinKhamBenh.getLankham()).isEqualTo(UPDATED_LANKHAM);
        assertThat(testThongTinKhamBenh.getChandoanbenh()).isEqualTo(UPDATED_CHANDOANBENH);
    }

    @Test
    public void updateNonExistingThongTinKhamBenh() throws Exception {
        int databaseSizeBeforeUpdate = thongTinKhamBenhRepository.findAll().size();

        // Create the ThongTinKhamBenh
        ThongTinKhamBenhDTO thongTinKhamBenhDTO = thongTinKhamBenhMapper.toDto(thongTinKhamBenh);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restThongTinKhamBenhMockMvc.perform(put("/api/thong-tin-kham-benhs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thongTinKhamBenhDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ThongTinKhamBenh in the database
        List<ThongTinKhamBenh> thongTinKhamBenhList = thongTinKhamBenhRepository.findAll();
        assertThat(thongTinKhamBenhList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteThongTinKhamBenh() throws Exception {
        // Initialize the database
        thongTinKhamBenhRepository.save(thongTinKhamBenh);

        int databaseSizeBeforeDelete = thongTinKhamBenhRepository.findAll().size();

        // Delete the thongTinKhamBenh
        restThongTinKhamBenhMockMvc.perform(delete("/api/thong-tin-kham-benhs/{id}", thongTinKhamBenh.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ThongTinKhamBenh> thongTinKhamBenhList = thongTinKhamBenhRepository.findAll();
        assertThat(thongTinKhamBenhList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
