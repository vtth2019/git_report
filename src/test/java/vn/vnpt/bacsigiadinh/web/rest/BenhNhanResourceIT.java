package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.HosobacsigiadinhApp;
import vn.vnpt.bacsigiadinh.config.SecurityBeanOverrideConfiguration;
import vn.vnpt.bacsigiadinh.domain.BenhNhan;
import vn.vnpt.bacsigiadinh.repository.BenhNhanRepository;
import vn.vnpt.bacsigiadinh.service.BenhNhanService;
import vn.vnpt.bacsigiadinh.service.dto.BenhNhanDTO;
import vn.vnpt.bacsigiadinh.service.mapper.BenhNhanMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link BenhNhanResource} REST controller.
 */
@SpringBootTest(classes = { SecurityBeanOverrideConfiguration.class, HosobacsigiadinhApp.class })

@AutoConfigureMockMvc
@WithMockUser
public class BenhNhanResourceIT {

    private static final Long DEFAULT_MABENHNHAN = 1L;
    private static final Long UPDATED_MABENHNHAN = 2L;

    private static final String DEFAULT_HOTEN = "AAAAAAAAAA";
    private static final String UPDATED_HOTEN = "BBBBBBBBBB";

    private static final Integer DEFAULT_TUOI = 1;
    private static final Integer UPDATED_TUOI = 2;

    private static final String DEFAULT_DIACHI = "AAAAAAAAAA";
    private static final String UPDATED_DIACHI = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_SODIENTHOAI = "AAAAAAAAAA";
    private static final String UPDATED_SODIENTHOAI = "BBBBBBBBBB";

    private static final Integer DEFAULT_MAHOSO = 1;
    private static final Integer UPDATED_MAHOSO = 2;

    @Autowired
    private BenhNhanRepository benhNhanRepository;

    @Autowired
    private BenhNhanMapper benhNhanMapper;

    @Autowired
    private BenhNhanService benhNhanService;

    @Autowired
    private MockMvc restBenhNhanMockMvc;

    private BenhNhan benhNhan;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BenhNhan createEntity() {
        BenhNhan benhNhan = new BenhNhan()
            .mabenhnhan(DEFAULT_MABENHNHAN)
            .hoten(DEFAULT_HOTEN)
            .tuoi(DEFAULT_TUOI)
            .diachi(DEFAULT_DIACHI)
            .email(DEFAULT_EMAIL)
            .sodienthoai(DEFAULT_SODIENTHOAI)
            .mahoso(DEFAULT_MAHOSO);
        return benhNhan;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BenhNhan createUpdatedEntity() {
        BenhNhan benhNhan = new BenhNhan()
            .mabenhnhan(UPDATED_MABENHNHAN)
            .hoten(UPDATED_HOTEN)
            .tuoi(UPDATED_TUOI)
            .diachi(UPDATED_DIACHI)
            .email(UPDATED_EMAIL)
            .sodienthoai(UPDATED_SODIENTHOAI)
            .mahoso(UPDATED_MAHOSO);
        return benhNhan;
    }

    @BeforeEach
    public void initTest() {
        benhNhanRepository.deleteAll();
        benhNhan = createEntity();
    }

    @Test
    public void createBenhNhan() throws Exception {
        int databaseSizeBeforeCreate = benhNhanRepository.findAll().size();

        // Create the BenhNhan
        BenhNhanDTO benhNhanDTO = benhNhanMapper.toDto(benhNhan);
        restBenhNhanMockMvc.perform(post("/api/benh-nhans").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(benhNhanDTO)))
            .andExpect(status().isCreated());

        // Validate the BenhNhan in the database
        List<BenhNhan> benhNhanList = benhNhanRepository.findAll();
        assertThat(benhNhanList).hasSize(databaseSizeBeforeCreate + 1);
        BenhNhan testBenhNhan = benhNhanList.get(benhNhanList.size() - 1);
        assertThat(testBenhNhan.getMabenhnhan()).isEqualTo(DEFAULT_MABENHNHAN);
        assertThat(testBenhNhan.getHoten()).isEqualTo(DEFAULT_HOTEN);
        assertThat(testBenhNhan.getTuoi()).isEqualTo(DEFAULT_TUOI);
        assertThat(testBenhNhan.getDiachi()).isEqualTo(DEFAULT_DIACHI);
        assertThat(testBenhNhan.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testBenhNhan.getSodienthoai()).isEqualTo(DEFAULT_SODIENTHOAI);
        assertThat(testBenhNhan.getMahoso()).isEqualTo(DEFAULT_MAHOSO);
    }

    @Test
    public void createBenhNhanWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = benhNhanRepository.findAll().size();

        // Create the BenhNhan with an existing ID
        benhNhan.setId("existing_id");
        BenhNhanDTO benhNhanDTO = benhNhanMapper.toDto(benhNhan);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBenhNhanMockMvc.perform(post("/api/benh-nhans").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(benhNhanDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BenhNhan in the database
        List<BenhNhan> benhNhanList = benhNhanRepository.findAll();
        assertThat(benhNhanList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllBenhNhans() throws Exception {
        // Initialize the database
        benhNhanRepository.save(benhNhan);

        // Get all the benhNhanList
        restBenhNhanMockMvc.perform(get("/api/benh-nhans?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(benhNhan.getId())))
            .andExpect(jsonPath("$.[*].mabenhnhan").value(hasItem(DEFAULT_MABENHNHAN.intValue())))
            .andExpect(jsonPath("$.[*].hoten").value(hasItem(DEFAULT_HOTEN)))
            .andExpect(jsonPath("$.[*].tuoi").value(hasItem(DEFAULT_TUOI)))
            .andExpect(jsonPath("$.[*].diachi").value(hasItem(DEFAULT_DIACHI)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].sodienthoai").value(hasItem(DEFAULT_SODIENTHOAI)))
            .andExpect(jsonPath("$.[*].mahoso").value(hasItem(DEFAULT_MAHOSO)));
    }
    
    @Test
    public void getBenhNhan() throws Exception {
        // Initialize the database
        benhNhanRepository.save(benhNhan);

        // Get the benhNhan
        restBenhNhanMockMvc.perform(get("/api/benh-nhans/{id}", benhNhan.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(benhNhan.getId()))
            .andExpect(jsonPath("$.mabenhnhan").value(DEFAULT_MABENHNHAN.intValue()))
            .andExpect(jsonPath("$.hoten").value(DEFAULT_HOTEN))
            .andExpect(jsonPath("$.tuoi").value(DEFAULT_TUOI))
            .andExpect(jsonPath("$.diachi").value(DEFAULT_DIACHI))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.sodienthoai").value(DEFAULT_SODIENTHOAI))
            .andExpect(jsonPath("$.mahoso").value(DEFAULT_MAHOSO));
    }

    @Test
    public void getNonExistingBenhNhan() throws Exception {
        // Get the benhNhan
        restBenhNhanMockMvc.perform(get("/api/benh-nhans/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateBenhNhan() throws Exception {
        // Initialize the database
        benhNhanRepository.save(benhNhan);

        int databaseSizeBeforeUpdate = benhNhanRepository.findAll().size();

        // Update the benhNhan
        BenhNhan updatedBenhNhan = benhNhanRepository.findById(benhNhan.getId()).get();
        updatedBenhNhan
            .mabenhnhan(UPDATED_MABENHNHAN)
            .hoten(UPDATED_HOTEN)
            .tuoi(UPDATED_TUOI)
            .diachi(UPDATED_DIACHI)
            .email(UPDATED_EMAIL)
            .sodienthoai(UPDATED_SODIENTHOAI)
            .mahoso(UPDATED_MAHOSO);
        BenhNhanDTO benhNhanDTO = benhNhanMapper.toDto(updatedBenhNhan);

        restBenhNhanMockMvc.perform(put("/api/benh-nhans").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(benhNhanDTO)))
            .andExpect(status().isOk());

        // Validate the BenhNhan in the database
        List<BenhNhan> benhNhanList = benhNhanRepository.findAll();
        assertThat(benhNhanList).hasSize(databaseSizeBeforeUpdate);
        BenhNhan testBenhNhan = benhNhanList.get(benhNhanList.size() - 1);
        assertThat(testBenhNhan.getMabenhnhan()).isEqualTo(UPDATED_MABENHNHAN);
        assertThat(testBenhNhan.getHoten()).isEqualTo(UPDATED_HOTEN);
        assertThat(testBenhNhan.getTuoi()).isEqualTo(UPDATED_TUOI);
        assertThat(testBenhNhan.getDiachi()).isEqualTo(UPDATED_DIACHI);
        assertThat(testBenhNhan.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testBenhNhan.getSodienthoai()).isEqualTo(UPDATED_SODIENTHOAI);
        assertThat(testBenhNhan.getMahoso()).isEqualTo(UPDATED_MAHOSO);
    }

    @Test
    public void updateNonExistingBenhNhan() throws Exception {
        int databaseSizeBeforeUpdate = benhNhanRepository.findAll().size();

        // Create the BenhNhan
        BenhNhanDTO benhNhanDTO = benhNhanMapper.toDto(benhNhan);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBenhNhanMockMvc.perform(put("/api/benh-nhans").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(benhNhanDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BenhNhan in the database
        List<BenhNhan> benhNhanList = benhNhanRepository.findAll();
        assertThat(benhNhanList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteBenhNhan() throws Exception {
        // Initialize the database
        benhNhanRepository.save(benhNhan);

        int databaseSizeBeforeDelete = benhNhanRepository.findAll().size();

        // Delete the benhNhan
        restBenhNhanMockMvc.perform(delete("/api/benh-nhans/{id}", benhNhan.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BenhNhan> benhNhanList = benhNhanRepository.findAll();
        assertThat(benhNhanList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
