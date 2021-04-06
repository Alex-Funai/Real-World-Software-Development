package Twootr;


import static org.junit.Assert.assertThat;      // JUnit-4.12
import static org.hamcrest.Matchers.contains;   // HamcrestCore-2.2
import static org.mockito.Mockito.mock;         // Mockito 1.10.19
import java.util.ArrayList;
import java.util.List;

public class MockReceiverEndPoint implements ReceiverEndPoint {

    private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

    private final List<Twoot> receivedTwoots = new ArrayList<>();

    @Override
    public void onTwoot(final Twoot twoot) {
        receivedTwoots.add(twoot);
    }

    @SuppressWarnings("deprecation")
	public void verifyOnTwoot(final Twoot twoot) {
        assertThat(receivedTwoots, contains(twoot));
    }
}
