package com.example.threadfabric.controller;

import com.example.threadfabric.domain.dto.*;
import com.example.threadfabric.domain.model.Detection;
import com.example.threadfabric.domain.model.Device;
import com.example.threadfabric.domain.model.DeviceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ThreatReportControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    private String deviceId = "6319f9ed-3ca6-4169-897e-9812b008f1d3";

       
   
    @Test
    void saveResolvedDetection() throws URISyntaxException {
        String address = "http://localhost:" + port + "/resources/detections/resolved";
        URI uri = new URI(address);
        ResolvedDetectionDto dto = new ResolvedDetectionDto("11f6b388-a121-4145-a058-4aee349d1d11");
        dto.setDeviceId("8cf6b388-a121-4145-a058-4aee349d1d06");
        dto.setTime(new Date());
        HttpEntity<ResolvedDetectionDto> request = new HttpEntity<>(dto);
        ResponseEntity<ResolvedDetectionDto> response = restTemplate.postForEntity(uri, request, ResolvedDetectionDto.class);
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    
	
    @Test
    void saveResolvedDetectionInvalidData2() throws URISyntaxException {
        String address = "http://localhost:" + port + "/resources/detections/resolved";
        URI uri = new URI(address);
        String uuid = UUID.randomUUID().toString();
        ResolvedDetectionDto dto = new ResolvedDetectionDto();
        dto.setDeviceId(deviceId);
        dto.setTime(new Date());
        HttpEntity<ResolvedDetectionDto> request = new HttpEntity<>(dto);
        ResponseEntity<ResolvedDetectionDto> response = restTemplate.postForEntity(uri, request, ResolvedDetectionDto.class);
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
    
  


    @Test
    void search() throws URISyntaxException {
        String address = "http://localhost:" + port + "/resources/detections/search?from=2021-6-8&to=2021-6-12&deviceId=&deviceModel=&type=";
        URI uri = new URI(address);
        ResponseEntity<List> response = restTemplate.getForEntity(uri, List.class);
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertTrue(response.getBody().size()>2);
    }

	@Test
    void searchNotProvidedDates() throws URISyntaxException {
        String address = "http://localhost:" + port + "/resources/detections/search?to=2021-06-12";
        URI uri = new URI(address);
        ResponseEntity<Object> response = restTemplate.getForEntity(uri, Object.class);
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}