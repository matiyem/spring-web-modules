package com.example.cachedrequest;

import com.example.chachedRequest.CachedBodyHttpServletRequest;
import com.example.chachedRequest.PrintRequestContentFilter;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class PrintRequestContentFilterUnitTest extends TestCase {

    @InjectMocks
    private PrintRequestContentFilter filterToTest;

    @Test
    public void testGivenHttpRequest_WhenDoFilter_thenReadsBody() throws IOException, ServletException {
        // Given
        MockHttpServletRequest mockedRequest = new MockHttpServletRequest();
        MockHttpServletResponse mockedResponse = new MockHttpServletResponse();
        FilterChain mockedFilterChain = Mockito.mock(FilterChain.class);
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(mockedRequest);

        // when
        filterToTest.doFilter(cachedBodyHttpServletRequest, mockedResponse, mockedFilterChain);

        // then
        Mockito.verify(mockedFilterChain, Mockito.times(1))
            .doFilter(cachedBodyHttpServletRequest, mockedResponse);
    }

}
