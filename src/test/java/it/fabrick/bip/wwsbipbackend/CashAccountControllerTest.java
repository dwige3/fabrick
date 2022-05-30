package it.fabrick.bip.wwsbipbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:/database/init-schema-drop-h2.sql"})
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:/database/init-data-h2.sql"})
@ActiveProfiles("test")
public class CashAccountControllerTest {

    private static String json = "{\n" +
            "  \"creditor\": {\n" +
            "    \"name\": \"John Doe\",\n" +
            "    \"account\": {\n" +
            "      \"accountCode\": \"IT23A0336844430152923804660\",\n" +
            "      \"bicCode\": \"SELBIT2BXXX\"\n" +
            "    },\n" +
            "    \"address\": {\n" +
            "      \"address\": null,\n" +
            "      \"city\": null,\n" +
            "      \"countryCode\": null\n" +
            "    }\n" +
            "  },\n" +
            "  \"executionDate\": \"2019-04-01\",\n" +
            "  \"uri\": \"REMITTANCE_INFORMATION\",\n" +
            "  \"description\": \"Payment invoice 75/2017\",\n" +
            "  \"amount\": 800,\n" +
            "  \"currency\": \"EUR\",\n" +
            "  \"isUrgent\": false,\n" +
            "  \"isInstant\": false,\n" +
            "  \"feeType\": \"SHA\",\n" +
            "  \"feeAccountId\": \"45685475\",\n" +
            "  \"taxRelief\": {\n" +
            "    \"taxReliefId\": \"L449\",\n" +
            "    \"isCondoUpgrade\": false,\n" +
            "    \"creditorFiscalCode\": \"56258745832\",\n" +
            "    \"beneficiaryType\": \"NATURAL_PERSON\",\n" +
            "    \"naturalPersonBeneficiary\": {\n" +
            "      \"fiscalCode1\": \"MRLFNC81L04A859L\",\n" +
            "      \"fiscalCode2\": null,\n" +
            "      \"fiscalCode3\": null,\n" +
            "      \"fiscalCode4\": null,\n" +
            "      \"fiscalCode5\": null\n" +
            "    },\n" +
            "    \"legalPersonBeneficiary\": {\n" +
            "      \"fiscalCode\": null,\n" +
            "      \"legalRepresentativeFiscalCode\": null\n" +
            "    }\n" +
            "  }\n" +
            "}";
    @Autowired
    private WebApplicationContext applicationContext;

    protected MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc =
                MockMvcBuilders.webAppContextSetup(applicationContext)
                        .build();
    }

    @Test
    void getCashAccountTransactionsTest() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/gbs/banking/v4.0/accounts/14537780/transactions")
                                .param("fromAccountingDate", "2019-04-01")
                                .param("toAccountingDate", "2019-04-01")
                                .param("page", String.valueOf(0))
                                .param("limit", String.valueOf(10))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getCashAccountBalanceTest() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/gbs/banking/v4.0/accounts/14537780/balances")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void createMoneyTransferTest() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }
}
