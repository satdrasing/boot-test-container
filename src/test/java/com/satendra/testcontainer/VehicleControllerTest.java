package com.satendra.testcontainer;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class VehicleControllerTest {

    //static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @LocalServerPort
    private Integer port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    VehicleRepository vehicleRepository;

  /*  @BeforeAll
    static void beforeAll() {
        postgres.start();
    }*/

   /* @AfterAll
    static void afterAll() {
        postgres.stop();
    }*/

    @BeforeEach
    void setUp() {
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:" + port));

        List<VehicleEntity> vehicleEntities = List.of(new VehicleEntity(1, "rocket"), new VehicleEntity(2, "spaceship"));
        vehicleRepository.saveAll(vehicleEntities);
    }

    @AfterEach
    void clear() {
        vehicleRepository.deleteAll();
    }

   /* @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }*/

    @Test
    void shouldFindAllVehicle() {

        VehicleEntity[] vehicleEntity = restTemplate.getForObject("/vehicle", VehicleEntity[].class);
        assertEquals(2, vehicleEntity.length);

    }

}
