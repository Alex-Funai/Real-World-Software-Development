package Twootr;

import java.security.SecureRandom;

import static java.nio.charset.StandardCharsets.UTF_16;
import static com.lambdaworks.*;

public class HashKeyGenerator {

    private static final int SCRYPT_COST =16384;
    private static final int SCRYPT_BLOCK_SIZE = 8;
    private static final int SCRYPT_PARALLELISM = 1;
    private static final int KEY_LENGTH = 20;

    private static final int SALT_LENGTH = 16;

    private static final SecureRandom secureRandom = new SecureRandom();

    static byte[] hash (final String password, final byte[] salt) {

        final byte[] passwordBytes = password.getBytes(UTF_16);
        return scrypt
    }

}
