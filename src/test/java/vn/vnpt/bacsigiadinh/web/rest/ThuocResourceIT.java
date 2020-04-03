package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.HosobacsigiadinhApp;
import vn.vnpt.bacsigiadinh.config.SecurityBeanOverrideConfiguration;
import vn.vnpt.bacsigiadinh.domain.Thuoc;
import vn.vnpt.bacsigiadinh.repository.ThuocRepository;
import vn.vnpt.bacsigiadinh.service.ThuocService;
import vn.vnpt.bacsigiadinh.service.dto.ThuocDTO;
import vn.vnpt.bacsigiadinh.service.mapper.ThuocMapper;

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
 * Integration tests for the {@link ThuocResource} REST controller.
 */
@SpringBootTest(classes = { SecurityBeanOverrideConfiguration.class, HosobacsigiadinhApp.class })

@AutoConfigureMockMvc
@WithMockUser
public class ThuocResourceIT {

    private static final String DEFAULT_TENTHUOC = "AAAAAAAAAA";
    private static final String UPDATED_TENTHUOC = "BBBBBBBBBB";

    private static final String DEFAULT_LOAITHUOC = "AAAAAAAAAA";
    private static final String UPDATED_LOAITHUOC = "BBBBBBBBBB";

    private static final String DEFAULT_HOATCHAT = "AAAAAAAAAA";
    private static final String UPDATED_HOATCHAT = "BBBBBBBBBB";

    private static final String DEFAULT_HAMLUONG = "AAAAAAAAAA";
    private static final String UPDATED_HAMLUONG = "BBBBBBBBBB";

    private static final String DEFAULT_NUOCSANXUAT = "AAAAAAAAAA";
    private static final String UPDATED_NUOCSANXUAT = "BBBBBBBBBB";

    @Autowired
    private ThuocRepository thuocRepository;

    @Autowired
    private ThuocMapper thuocMapper;

    @Autowired
    private ThuocService thuocService;

    @Autowired
    private MockMvc restThuocMockMvc;

    private Thuoc thuoc;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Thuoc createEntity() {
        Thuoc thuoc = new Thuoc()
            .tenthuoc(DEFAULT_TENTHUOC)
            .loaithuoc(DEFAULT_LOAITHUOC)
            .hoatchat(DEFAULT_HOATCHAT)
            .hamluong(DEFAULT_HAMLUONG)
            .nuocsanxuat(DEFAULT_NUOCSANXUAT);
        return thuoc;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Thuoc createUpdatedEntity() {
        Thuoc thuoc = new Thuoc()
            .tenthuoc(UPDATED_TENTHUOC)
            .loaithuoc(UPDATED_LOAITHUOC)
            .hoatchat(UPDATED_HOATCHAT)
            .hamluong(UPDATED_HAMLUONG)
            .nuocsanxuat(UPDATED_NUOCSANXUAT);
        return thuoc;
    }

    @BeforeEach
    public void initTest() {
        thuocRepository.deleteAll();
        thuoc = createEntity();
    }

    @Test
    public void createThuoc() throws Exception {
        int databaseSizeBeforeCreate = thuocRepository.findAll().size();

        // Create the Thuoc
        ThuocDTO thuocDTO = thuocMapper.toDto(thuoc);
        restThuocMockMvc.perform(post("/api/thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thuocDTO)))
            .andExpect(status().isCreated());

        // Validate the Thuoc in the database
        List<Thuoc> thuocList = thuocRepository.findAll();
        assertThat(thuocList).hasSize(databaseSizeBeforeCreate + 1);
        Thuoc testThuoc = thuocList.get(thuocList.size() - 1);
        assertThat(testThuoc.getTenthuoc()).isEqualTo(DEFAULT_TENTHUOC);
        assertThat(testThuoc.getLoaithuoc()).isEqualTo(DEFAULT_LOAITHUOC);
        assertThat(testThuoc.getHoatchat()).isEqualTo(DEFAULT_HOATCHAT);
        assertThat(testThuoc.getHamluong()).isEqualTo(DEFAULT_HAMLUONG);
        assertThat(testThuoc.getNuocsanxuat()).isEqualTo(DEFAULT_NUOCSANXUAT);
    }

    @Test
    public void createThuocWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = thuocRepository.findAll().size();

        // Create the Thuoc with an existing ID
        thuoc.setId("existing_id");
        ThuocDTO thuocDTO = thuocMapper.toDto(thuoc);

        // An entity with an existing ID cannot be created, so this API call must fail
        restThuocMockMvc.perform(post("/api/thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thuocDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Thuoc in the database
        List<Thuoc> thuocList = thuocRepository.findAll();
        assertThat(thuocList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllThuocs() throws Exception {
        // Initialize the database
        thuocRepository.save(thuoc);

        // Get all the thuocList
        restThuocMockMvc.perform(get("/api/thuocs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(thuoc.getId())))
            .andExpect(jsonPath("$.[*].tenthuoc").value(hasItem(DEFAULT_TENTHUOC)))
            .andExpect(jsonPath("$.[*].loaithuoc").value(hasItem(DEFAULT_LOAITHUOC)))
            .andExpect(jsonPath("$.[*].hoatchat").value(hasItem(DEFAULT_HOATCHAT)))
            .andExpect(jsonPath("$.[*].hamluong").value(hasItem(DEFAULT_HAMLUONG)))
            .andExpect(jsonPath("$.[*].nuocsanxuat").value(hasItem(DEFAULT_NUOCSANXUAT)));
    }
    
    @Test
    public void getThuoc() throws Exception {
        // Initialize the database
        thuocRepository.save(thuoc);

        // Get the thuoc
        restThuocMockMvc.perform(get("/api/thuocs/{id}", thuoc.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(thuoc.getId()))
            .andExpect(jsonPath("$.tenthuoc").value(DEFAULT_TENTHUOC))
            .andExpect(jsonPath("$.loaithuoc").value(DEFAULT_LOAITHUOC))
            .andExpect(jsonPath("$.hoatchat").value(DEFAULT_HOATCHAT))
            .andExpect(jsonPath("$.hamluong").value(DEFAULT_HAMLUONG))
            .andExpect(jsonPath("$.nuocsanxuat").value(DEFAULT_NUOCSANXUAT));
    }

    @Test
    public void getNonExistingThuoc() throws Exception {
        // Get the thuoc
        restThuocMockMvc.perform(get("/api/thuocs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateThuoc() throws Exception {
        // Initialize the database
        thuocRepository.save(thuoc);

        int databaseSizeBeforeUpdate = thuocRepository.findAll().size();

        // Update the thuoc
        Thuoc updatedThuoc = thuocRepository.findById(thuoc.getId()).get();
        updatedThuoc
            .tenthuoc(UPDATED_TENTHUOC)
            .loaithuoc(UPDATED_LOAITHUOC)
            .hoatchat(UPDATED_HOATCHAT)
            .hamluong(UPDATED_HAMLUONG)
            .nuocsanxuat(UPDATED_NUOCSANXUAT);
        ThuocDTO thuocDTO = thuocMapper.toDto(updatedThuoc);

        restThuocMockMvc.perform(put("/api/thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thuocDTO)))
            .andExpect(status().isOk());

        // Validate the Thuoc in the database
        List<Thuoc> thuocList = thuocRepository.findAll();
        assertThat(thuocList).hasSize(databaseSizeBeforeUpdate);
        Thuoc testThuoc = thuocList.get(thuocList.size() - 1);
        assertThat(testThuoc.getTenthuoc()).isEqualTo(UPDATED_TENTHUOC);
        assertThat(testThuoc.getLoaithuoc()).isEqualTo(UPDATED_LOAITHUOC);
        assertThat(testThuoc.getHoatchat()).isEqualTo(UPDATED_HOATCHAT);
        assertThat(testThuoc.getHamluong()).isEqualTo(UPDATED_HAMLUONG);
        assertThat(testThuoc.getNuocsanxuat()).isEqualTo(UPDATED_NUOCSANXUAT);
    }

    @Test
    public void updateNonExistingThuoc() throws Exception {
        int databaseSizeBeforeUpdate = thuocRepository.findAll().size();

        // Create the Thuoc
        ThuocDTO thuocDTO = thuocMapper.toDto(thuoc);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restThuocMockMvc.perform(put("/api/thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(thuocDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Thuoc in the database
        List<Thuoc> thuocList = thuocRepository.findAll();
        assertThat(thuocList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteThuoc() throws Exception {
        // Initialize the database
        thuocRepository.save(thuoc);

        int databaseSizeBeforeDelete = thuocRepository.findAll().size();

        // Delete the thuoc
        restThuocMockMvc.perform(delete("/api/thuocs/{id}", thuoc.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Thuoc> thuocList = thuocRepository.findAll();
        assertThat(thuocList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
