package fr.istic.vv;

import fr.istic.vv.SSLSocket;
import fr.istic.vv.TLSSocketFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

    @Test
    public void preparedSocket_NullProtocols() {
        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = mock(SSLSocket.class);
        when(socket.getSupportedProtocols()).thenReturn(null);
        when(socket.getEnabledProtocols()).thenReturn(null);
        //doThrow(Exception.class).when(socket).setEnabledProtocols(null);

        doThrow(IllegalArgumentException.class).when(socket).setEnabledProtocols(any());
        Exception exception = null;

        // when
        try {
            f.prepareSocket(socket);
        } catch (IllegalArgumentException t) {
            exception = t;
        }

        // then
        assertNotNull(exception);
        //assertThrows(Exception.class, () -> f.prepareSocket(socket));
    }

    @Test
    public void typical() {
        String[] supportedProtocols = new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        String[] enabledProtocols = new String[]{"SSLv3", "TLSv1"};

        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = mock(SSLSocket.class);
        when(socket.getSupportedProtocols()).thenReturn(supportedProtocols);
        when(socket.getEnabledProtocols()).thenReturn(shuffle(enabledProtocols));
        //doThrow(NullPointerException.class).when(socket).setEnabledProtocols(new String[0]);

        assertTrue(Arrays.equals(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "TLS"}, socket.getEnabledProtocols()));

    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}