package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.HosobacsigiadinhApp;
import vn.vnpt.bacsigiadinh.config.SecurityBeanOverrideConfiguration;
import vn.vnpt.bacsigiadinh.domain.BaoHiemYTe;
import vn.vnpt.bacsigiadinh.repository.BaoHiemYTeRepository;
import vn.vnpt.bacsigiadinh.service.BaoHiemYTeService;
import vn.vnpt.bacsigiadinh.service.dto.BaoHiemYTeDTO;
import vn.vnpt.bacsigiadinh.service.mapper.BaoHiemYTeMapper;

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
 * Integration tests for the {@link BaoHiemYTeResource} REST controller.
 */
@SpringBootTest(classes = { SecurityBeanOverrideConfiguration.class, HosobacsigiadinhApp.class })

@AutoConfigureMockMvc
@WithMockUser
public class BaoHiemYTeResourceIT {

    private static final String DEFAULT_MATHEBAOHIEMYTE = "AAAAAAAAAA";
    private static final String UPDATED_MATHEBAOHIEMYTE = "BBBBBBBBBB";

    private static final String DEFAULT_NOIDANGKY = "AAAAAAAAAA";
    private static final String UPDATED_NOIDANGKY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TUNGAY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TUNGAY = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DENNGAY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DENNGAY = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private BaoHiemYTeRepository baoHiemYTeRepository;

    @Autowired
    private BaoHiemYTeMapper baoHiemYTeMapper;

    @Autowired
    private BaoHiemYTeService baoHiemYTeService;

    @Autowired
    private MockMvc restBaoHiemYTeMockMvc;

    private BaoHiemYTe baoHiemYTe;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BaoHiemYTe createEntity() {
        BaoHiemYTe baoHiemYTe = new BaoHiemYTe()
            .mathebaohiemyte(DEFAULT_MATHEBAOHIEMYTE)
            .noidangky(DEFAULT_NOIDANGKY)
            .tungay(DEFAULT_TUNGAY)
            .denngay(DEFAULT_DENNGAY);
        return baoHiemYTe;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BaoHiemYTe createUpdatedEntity() {
        BaoHiemYTe baoHiemYTe = new BaoHiemYTe()
            .mathebaohiemyte(UPDATED_MATHEBAOHIEMYTE)
            .noidangky(UPDATED_NOIDANGKY)
            .tungay(UPDATED_TUNGAY)
            .denngay(UPDATED_DENNGAY);
        return baoHiemYTe;
    }

    @BeforeEach
    public void initTest() {
        baoHiemYTeRepository.deleteAll();
        baoHiemYTe = createEntity();
    }

    @Test
    public void createBaoHiemYTe() throws Exception {
        int databaseSizeBeforeCreate = baoHiemYTeRepository.findAll().size();

        // Create the BaoHiemYTe
        BaoHiemYTeDTO baoHiemYTeDTO = baoHiemYTeMapper.toDto(baoHiemYTe);
        restBaoHiemYTeMockMvc.perform(post("/api/bao-hiem-y-tes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(baoHiemYTeDTO)))
            .andExpect(status().isCreated());

        // Validate the BaoHiemYTe in the database
        List<BaoHiemYTe> baoHiemYTeList = baoHiemYTeRepository.findAll();
        assertThat(baoHiemYTeList).hasSize(databaseSizeBeforeCreate + 1);
        BaoHiemYTe testBaoHiemYTe = baoHiemYTeList.get(baoHiemYTeList.size() - 1);
        assertThat(testBaoHiemYTe.getMathebaohiemyte()).isEqualTo(DEFAULT_MATHEBAOHIEMYTE);
        assertThat(testBaoHiemYTe.getNoidangky()).isEqualTo(DEFAULT_NOIDANGKY);
        assertThat(testBaoHiemYTe.getTungay()).isEqualTo(DEFAULT_TUNGAY);
        assertThat(testBaoHiemYTe.getDenngay()).isEqualTo(DEFAULT_DENNGAY);
    }

    @Test
    public void createBaoHiemYTeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = baoHiemYTeRepository.findAll().size();

        // Create the BaoHiemYTe with an existing ID
        baoHiemYTe.setId("existing_id");
        BaoHiemYTeDTO baoHiemYTeDTO = baoHiemYTeMapper.toDto(baoHiemYTe);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBaoHiemYTeMockMvc.perform(post("/api/bao-hiem-y-tes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(baoHiemYTeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BaoHiemYTe in the database
        List<BaoHiemYTe> baoHiemYTeList = baoHiemYTeRepository.findAll();
        assertThat(baoHiemYTeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllBaoHiemYTes() throws Exception {
        // Initialize the database
        baoHiemYTeRepository.save(baoHiemYTe);

        // Get all the baoHiemYTeList
        restBaoHiemYTeMockMvc.perform(get("/api/bao-hiem-y-tes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(baoHiemYTe.getId())))
            .andExpect(jsonPath("$.[*].mathebaohiemyte").value(hasItem(DEFAULT_MATHEBAOHIEMYTE)))
            .andExpect(jsonPath("$.[*].noidangky").value(hasItem(DEFAULT_NOIDANGKY)))
            .andExpect(jsonPath("$.[*].tungay").value(hasItem(DEFAULT_TUNGAY.toString())))
            .andExpect(jsonPath("$.[*].denngay").value(hasItem(DEFAULT_DENNGAY.toString())));
    }
    
    @Test
    public void getBaoHiemYTe() throws Exception {
        // Initialize the database
        baoHiemYTeRepository.save(baoHiemYTe);

        // Get the baoHiemYTe
        restBaoHiemYTeMockMvc.perform(get("/api/bao-hiem-y-tes/{id}", baoHiemYTe.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(baoHiemYTe.getId()))
            .andExpect(jsonPath("$.mathebaohiemyte").value(DEFAULT_MATHEBAOHIEMYTE))
            .andExpect(jsonPath("$.noidangky").value(DEFAULT_NOIDANGKY))
            .andExpect(jsonPath("$.tungay").value(DEFAULT_TUNGAY.toString()))
            .andExpect(jsonPath("$.denngay").value(DEFAULT_DENNGAY.toString()));
    }

    @Test
    public void getNonExistingBaoHiemYTe() throws Exception {
        // Get the baoHiemYTe
        restBaoHiemYTeMockMvc.perform(get("/api/bao-hiem-y-tes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateBaoHiemYTe() throws Exception {
        // Initialize the database
        baoHiemYTeRepository.save(baoHiemYTe);

        int databaseSizeBeforeUpdate = baoHiemYTeRepository.findAll().size();

        // Update the baoHiemYTe
        BaoHiemYTe updatedBaoHiemYTe = baoHiemYTeRepository.findById(baoHiemYTe.getId()).get();
        updatedBaoHiemYTe
            .mathebaohiemyte(UPDATED_MATHEBAOHIEMYTE)
            .noidangky(UPDATED_NOIDANGKY)
            .tungay(UPDATED_TUNGAY)
            .denngay(UPDATED_DENNGAY);
        BaoHiemYTeDTO baoHiemYTeDTO = baoHiemYTeMapper.toDto(updatedBaoHiemYTe);

        restBaoHiemYTeMockMvc.perform(put("/api/bao-hiem-y-tes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(baoHiemYTeDTO)))
            .andExpect(status().isOk());

        // Validate the BaoHiemYTe in the database
        List<BaoHiemYTe> baoHiemYTeList = baoHiemYTeRepository.findAll();
        assertThat(baoHiemYTeList).hasSize(databaseSizeBeforeUpdate);
        BaoHiemYTe testBaoHiemYTe = baoHiemYTeList.get(baoHiemYTeList.size() - 1);
        assertThat(testBaoHiemYTe.getMathebaohiemyte()).isEqualTo(UPDATED_MATHEBAOHIEMYTE);
        assertThat(testBaoHiemYTe.getNoidangky()).isEqualTo(UPDATED_NOIDANGKY);
        assertThat(testBaoHiemYTe.getTungay()).isEqualTo(UPDATED_TUNGAY);
        assertThat(testBaoHiemYTe.getDenngay()).isEqualTo(UPDATED_DENNGAY);
    }

    @Test
    public void updateNonExistingBaoHiemYTe() throws Exception {
        int databaseSizeBeforeUpdate = baoHiemYTeRepository.findAll().size();

        // Create the BaoHiemYTe
        BaoHiemYTeDTO baoHiemYTeDTO = baoHiemYTeMapper.toDto(baoHiemYTe);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBaoHiemYTeMockMvc.perform(put("/api/bao-hiem-y-tes").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(baoHiemYTeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BaoHiemYTe in the database
        List<BaoHiemYTe> baoHiemYTeList = baoHiemYTeRepository.findAll();
        assertThat(baoHiemYTeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteBaoHiemYTe() throws Exception {
        // Initialize the database
        baoHiemYTeRepository.save(baoHiemYTe);

        int databaseSizeBeforeDelete = baoHiemYTeRepository.findAll().size();

        // Delete the baoHiemYTe
        restBaoHiemYTeMockMvc.perform(delete("/api/bao-hiem-y-tes/{id}", baoHiemYTe.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BaoHiemYTe> baoHiemYTeList = baoHiemYTeRepository.findAll();
        assertThat(baoHiemYTeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
