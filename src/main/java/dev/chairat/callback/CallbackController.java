package dev.chairat.callback;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/callback")
public class CallbackController {

    @GetMapping
    public ResponseEntity<HTTPRequestInfo> get(HttpServletRequest httpServletRequest, @RequestHeader MultiValueMap<String, String> headers) {
        return new ResponseEntity<>(HTTPRequestInfo.builder()
                .method(httpServletRequest.getMethod())
                .requestURL(httpServletRequest.getRequestURL().toString())
                .requestURI(httpServletRequest.getRequestURI())
                .requestParams(httpServletRequest.getParameterMap())
                .requestHeaders(headers)
                .build()
                , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HTTPRequestInfo> post(HttpServletRequest httpServletRequest, @RequestHeader MultiValueMap<String, String> headers, HttpEntity<String> body) {
        return new ResponseEntity<>(HTTPRequestInfo.builder()
                .method(httpServletRequest.getMethod())
                .requestURL(httpServletRequest.getRequestURL().toString())
                .requestURI(httpServletRequest.getRequestURI())
                .requestParams(httpServletRequest.getParameterMap())
                .requestHeaders(headers)
                .bodyString(body.getBody())
                .build()
                , HttpStatus.OK);
    }

}
