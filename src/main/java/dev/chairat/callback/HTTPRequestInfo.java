package dev.chairat.callback;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Data
@Builder
public class HTTPRequestInfo {

    private String method;

    private String requestURL;

    private String requestURI;

    private Map<String, String[]> requestParams;

    private MultiValueMap<String, String> requestHeaders;

    private String bodyString;

}
