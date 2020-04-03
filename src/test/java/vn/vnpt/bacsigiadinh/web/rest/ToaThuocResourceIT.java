package vn.vnpt.bacsigiadinh.web.rest;

import vn.vnpt.bacsigiadinh.HosobacsigiadinhApp;
import vn.vnpt.bacsigiadinh.config.SecurityBeanOverrideConfiguration;
import vn.vnpt.bacsigiadinh.domain.ToaThuoc;
import vn.vnpt.bacsigiadinh.repository.ToaThuocRepository;
import vn.vnpt.bacsigiadinh.service.ToaThuocService;
import vn.vnpt.bacsigiadinh.service.dto.ToaThuocDTO;
import vn.vnpt.bacsigiadinh.service.mapper.ToaThuocMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ToaThuocResource} REST controller.
 */
@SpringBootTest(classes = { SecurityBeanOverrideConfiguration.class, HosobacsigiadinhApp.class })
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class ToaThuocResourceIT {

    private static final String DEFAULT_CHANDOANBENH = "AAAAAAAAAA";
    private static final String UPDATED_CHANDOANBENH = "BBBBBBBBBB";

    private static final String DEFAULT_LIEULUONG = "AAAAAAAAAA";
    private static final String UPDATED_LIEULUONG = "BBBBBBBBBB";

    @Autowired
    private ToaThuocRepository toaThuocRepository;

    @Mock
    private ToaThuocRepository toaThuocRepositoryMock;

    @Autowired
    private ToaThuocMapper toaThuocMapper;

    @Mock
    private ToaThuocService toaThuocServiceMock;

    @Autowired
    private ToaThuocService toaThuocService;

    @Autowired
    private MockMvc restToaThuocMockMvc;

    private ToaThuoc toaThuoc;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ToaThuoc createEntity() {
        ToaThuoc toaThuoc = new ToaThuoc()
            .chandoanbenh(DEFAULT_CHANDOANBENH)
            .lieuluong(DEFAULT_LIEULUONG);
        return toaThuoc;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ToaThuoc createUpdatedEntity() {
        ToaThuoc toaThuoc = new ToaThuoc()
            .chandoanbenh(UPDATED_CHANDOANBENH)
            .lieuluong(UPDATED_LIEULUONG);
        return toaThuoc;
    }

    @BeforeEach
    public void initTest() {
        toaThuocRepository.deleteAll();
        toaThuoc = createEntity();
    }

    @Test
    public void createToaThuoc() throws Exception {
        int databaseSizeBeforeCreate = toaThuocRepository.findAll().size();

        // Create the ToaThuoc
        ToaThuocDTO toaThuocDTO = toaThuocMapper.toDto(toaThuoc);
        restToaThuocMockMvc.perform(post("/api/toa-thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(toaThuocDTO)))
            .andExpect(status().isCreated());

        // Validate the ToaThuoc in the database
        List<ToaThuoc> toaThuocList = toaThuocRepository.findAll();
        assertThat(toaThuocList).hasSize(databaseSizeBeforeCreate + 1);
        ToaThuoc testToaThuoc = toaThuocList.get(toaThuocList.size() - 1);
        assertThat(testToaThuoc.getChandoanbenh()).isEqualTo(DEFAULT_CHANDOANBENH);
        assertThat(testToaThuoc.getLieuluong()).isEqualTo(DEFAULT_LIEULUONG);
    }

    @Test
    public void createToaThuocWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = toaThuocRepository.findAll().size();

        // Create the ToaThuoc with an existing ID
        toaThuoc.setId("existing_id");
        ToaThuocDTO toaThuocDTO = toaThuocMapper.toDto(toaThuoc);

        // An entity with an existing ID cannot be created, so this API call must fail
        restToaThuocMockMvc.perform(post("/api/toa-thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(toaThuocDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ToaThuoc in the database
        List<ToaThuoc> toaThuocList = toaThuocRepository.findAll();
        assertThat(toaThuocList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllToaThuocs() throws Exception {
        // Initialize the database
        toaThuocRepository.save(toaThuoc);

        // Get all the toaThuocList
        restToaThuocMockMvc.perform(get("/api/toa-thuocs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(toaThuoc.getId())))
            .andExpect(jsonPath("$.[*].chandoanbenh").value(hasItem(DEFAULT_CHANDOANBENH)))
            .andExpect(jsonPath("$.[*].lieuluong").value(hasItem(DEFAULT_LIEULUONG)));
    }
    
    @SuppressWarnings({"unchecked"})
    public void getAllToaThuocsWithEagerRelationshipsIsEnabled() throws Exception {
        when(toaThuocServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restToaThuocMockMvc.perform(get("/api/toa-thuocs?eagerload=true"))
            .andExpect(status().isOk());

        verify(toaThuocServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({"unchecked"})
    public void getAllToaThuocsWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(toaThuocServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restToaThuocMockMvc.perform(get("/api/toa-thuocs?eagerload=true"))
            .andExpect(status().isOk());

        verify(toaThuocServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    public void getToaThuoc() throws Exception {
        // Initialize the database
        toaThuocRepository.save(toaThuoc);

        // Get the toaThuoc
        restToaThuocMockMvc.perform(get("/api/toa-thuocs/{id}", toaThuoc.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(toaThuoc.getId()))
            .andExpect(jsonPath("$.chandoanbenh").value(DEFAULT_CHANDOANBENH))
            .andExpect(jsonPath("$.lieuluong").value(DEFAULT_LIEULUONG));
    }

    @Test
    public void getNonExistingToaThuoc() throws Exception {
        // Get the toaThuoc
        restToaThuocMockMvc.perform(get("/api/toa-thuocs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateToaThuoc() throws Exception {
        // Initialize the database
        toaThuocRepository.save(toaThuoc);

        int databaseSizeBeforeUpdate = toaThuocRepository.findAll().size();

        // Update the toaThuoc
        ToaThuoc updatedToaThuoc = toaThuocRepository.findById(toaThuoc.getId()).get();
        updatedToaThuoc
            .chandoanbenh(UPDATED_CHANDOANBENH)
            .lieuluong(UPDATED_LIEULUONG);
        ToaThuocDTO toaThuocDTO = toaThuocMapper.toDto(updatedToaThuoc);

        restToaThuocMockMvc.perform(put("/api/toa-thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(toaThuocDTO)))
            .andExpect(status().isOk());

        // Validate the ToaThuoc in the database
        List<ToaThuoc> toaThuocList = toaThuocRepository.findAll();
        assertThat(toaThuocList).hasSize(databaseSizeBeforeUpdate);
        ToaThuoc testToaThuoc = toaThuocList.get(toaThuocList.size() - 1);
        assertThat(testToaThuoc.getChandoanbenh()).isEqualTo(UPDATED_CHANDOANBENH);
        assertThat(testToaThuoc.getLieuluong()).isEqualTo(UPDATED_LIEULUONG);
    }

    @Test
    public void updateNonExistingToaThuoc() throws Exception {
        int databaseSizeBeforeUpdate = toaThuocRepository.findAll().size();

        // Create the ToaThuoc
        ToaThuocDTO toaThuocDTO = toaThuocMapper.toDto(toaThuoc);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restToaThuocMockMvc.perform(put("/api/toa-thuocs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(toaThuocDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ToaThuoc in the database
        List<ToaThuoc> toaThuocList = toaThuocRepository.findAll();
        assertThat(toaThuocList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteToaThuoc() throws Exception {
        // Initialize the database
        toaThuocRepository.save(toaThuoc);

        int databaseSizeBeforeDelete = toaThuocRepository.findAll().size();

        // Delete the toaThuoc
        restToaThuocMockMvc.perform(delete("/api/toa-thuocs/{id}", toaThuoc.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ToaThuoc> toaThuocList = toaThuocRepository.findAll();
        assertThat(toaThuocList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
