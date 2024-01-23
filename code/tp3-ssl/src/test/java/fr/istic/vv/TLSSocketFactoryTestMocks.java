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
            doThrow(NullPointerException.class).when(socket).setEnabledProtocols(null);

            assertThrows(NullPointerException.class, () -> f.prepareSocket(socket));
    }

    @Test
    public void typical() {
        String[] supportedProtocols = new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        String[] enabledProtocols = new String[]{"SSLv3", "TLSv1"};

        TLSSocketFactory f = new TLSSocketFactory();
        SSLSocket socket = mock(SSLSocket.class);
        when(socket.getSupportedProtocols()).thenReturn(supportedProtocols);
        when(socket.getEnabledProtocols()).thenReturn(enabledProtocols);
        //doThrow(NullPointerException.class).when(socket).setEnabledProtocols(new String[0]);

        assertArrayEquals(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "TLS"}, socket.getEnabledProtocols());

    }
}