package com.flightnetwork.ticketbooking.discountService;

import com.flightnetwork.ticketbooking.discountService.models.DiscountedBill;
import com.flightnetwork.ticketbooking.discountService.utils.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.math.BigDecimal;

import static com.flightnetwork.ticketbooking.discountService.models.UserType.STANDARD;
import static com.flightnetwork.ticketbooking.discountService.utils.FileUtils.getFileFromTestResources;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DiscountServiceApplicationTests extends BaseTest {

    @Test
    public void shouldReturnDiscountedBillAmount() {
        addDiscountSlabsTestData();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DiscountedBill> responseEntity = restTemplate.getForEntity("http://localhost:8081/discount/userType/STANDARD/amount/3500", DiscountedBill.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        DiscountedBill actualDiscountedBill = responseEntity.getBody();

        assertNotNull(actualDiscountedBill);
        assertEquals(STANDARD, actualDiscountedBill.getUserType());
        assertEquals(BigDecimal.valueOf(3500), actualDiscountedBill.getOriginalBillAmount());
        assertEquals(0, BigDecimal.valueOf(3225).compareTo(actualDiscountedBill.getDiscountedBillAmount()));
    }

    @Test
    public void shouldNotAllowToImportDiscountSlabsInRegularPort() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new File("upload_discount_slabs.csv"));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        try {
            restTemplate.postForEntity("http://localhost:8081/discount/dev/upload", requestEntity, Void.class);
            Assert.fail();
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
        }
    }

    @Test
    public void shouldAllowToImportDiscountSlabsInDeveloperPort() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(getFileFromTestResources("upload_discount_slabs.csv")));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        restTemplate.postForEntity("http://localhost:10081/discount/dev/upload", requestEntity, Void.class);

        assertEquals(7, discountSlabsRepository.findAll().size());
    }

}
