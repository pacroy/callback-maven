package dev.chairat.callback;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/")
public class RootController {

    @GetMapping
    public String redirect(HttpServletResponse httpServletResponse) {
        String clientId = UriUtils.encode(System.getenv("CLIENT_ID"), "UTF-8");
        String resourceId = UriUtils.encode(System.getenv("RESOURCE_ID"), "UTF-8");
        String redirectUri = UriUtils.encode(System.getenv("REDIRECT_URI"),"UTF-8" );

        if (StringUtils.isEmpty(clientId)) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return "Missing environment variable: CLIENT_ID";
        }
        if (StringUtils.isEmpty(resourceId)) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return "Missing environment variable: RESOURCE_ID";
        }
        if (StringUtils.isEmpty(redirectUri)) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return "Missing environment variable: REDIRECT_URI";
        }

        httpServletResponse.setHeader("Location",
                "https://login.microsoftonline.com/EMCloudAD.onmicrosoft.com/oauth2/authorize?" +
                "client_id=" + clientId +
                "&response_type=token" +
                "&resource=" + resourceId +
                "&redirect_uri=" + redirectUri +
                "&state=" + UUID.randomUUID());
        httpServletResponse.setStatus(HttpStatus.FOUND.value());
        return "";
    }

}
