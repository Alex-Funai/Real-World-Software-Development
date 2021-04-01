///////////////////////////////////////////////////////////////////////////////
// Main Class File: Twootr.java
// File: class.KeyGenerator.java
// Date: April 1, 2021
// Programmer: Alexander Kitaro Funai
// Email: alexanderfunai@protonmail.com
// Website: https://www.alexanderfunai.com
///////////////////////////////////////////////////////////////////////////////
// Sources: Real World Software Development
// Authors: Rauol-Gabriel Urma & Richard Warburton
// Sources: github.com/Iteratr-Learning/Real-World-Software-Development.git
///////////////////////////////////////////////////////////////////////////////

package Twootr;
import org.bouncycastle.crypto.generators.SCrypt;
import static java.nio.charset.StandardCharsets.UTF_16;
import java.security.SecureRandom;


/**
 * Hash key generation/structure for users' passwords.
 * @see org.bouncycastle.crypto.generators.SCrypt;
 * @apiNote ::"bcprov-ext-jdk15on-168.jar".
 * @author ::Rauol-Gabriel Urma & Richard Warburton
 */
class KeyGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int SCRYPT_COST = 16384;
    private static final int SCRYPT_BLOCK_SIZE = 8;
    private static final int SCRYPT_PARALLELISM = 1;
    private static final int KEY_LENGTH = 20;
    private static final int SALT_LENGTH = 16;

    /**
     *
     * @param password
     * @param salt
     * @return ::unique hash w/ salt.
     */
     static byte[] hash(final String password, final byte[] salt) {
        final byte[] passwordBytes = password.getBytes(UTF_16);
        return SCrypt.generate(
                passwordBytes, salt, SCRYPT_COST, SCRYPT_BLOCK_SIZE,
                SCRYPT_PARALLELISM, KEY_LENGTH);
    }

    /**
     * Generates a random encryption string to tag passwords.
     * @return ::unique salt encryption[tag] for user password.
     */
    static byte[] newSalt() {
        final byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        return salt;
    }
}