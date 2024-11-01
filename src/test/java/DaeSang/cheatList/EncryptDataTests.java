package DaeSang.cheatList;

import DaeSang.cheatList.reposrt.service.EncryptData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EncryptDataTests {

    @Autowired
    private EncryptData encryptData;

    private String plaintext;

    @BeforeEach
    public void setUp() {
        plaintext = "Hello, this is a test!";
    }

    @Test
    public void testEncryption() throws Exception {
        String encryptedText = encryptData.encrypt(plaintext);
        assertNotNull(encryptedText);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = encryptData.decrypt(encryptedText);
        assertEquals(plaintext, decryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}