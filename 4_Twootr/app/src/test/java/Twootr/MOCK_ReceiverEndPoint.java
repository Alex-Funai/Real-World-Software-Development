package Twootr;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;

public class MOCK_ReceiverEndPoint implements ReceiverEndPoint {

    private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

    private final List<Twoot> twootsReceived = new ArrayList<>();

    @Override
    public void uponTwoot (final Twoot twoot) {
        twootsReceived.add(twoot)
    }

    public void verifyUponTwoot (final Twoot twoot) {

        assertThat (twootsReceived, contains (twoot));
    }
}
