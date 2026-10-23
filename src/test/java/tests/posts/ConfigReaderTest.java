
package tests.posts;

import org.testng.annotations.Test;

import framework.ConfigReader;

import static org.testng.Assert.*;

public class ConfigReaderTest {

    @Test
    void shouldLoadBaseUrlFromConfiguration() {

        String baseUrl = ConfigReader.getProperty("base.url");

        assertNotNull(baseUrl, "Base URL should not be null");
        assertFalse(baseUrl.isBlank(), "Base URL should not be empty");
        assertEquals(
                baseUrl,
                "https://jsonplaceholder.typicode.com"
        );
    }
}
