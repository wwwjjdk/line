package http;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Request {
    private URI uri;
    private String method;
    private String path;
    private String protocol;
    private List<String> headers;

    public Request() {}

    public URI getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getProtocol() {
        return protocol;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public Request setMethod(String method) {
        this.method = method;
        return  this;
    }

    public Request setPathAndCreateUri(String path) throws URISyntaxException {
        this.path = path;
        uri = new URI(path);
        return this;
    }

    public Request setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public Request setHeaders(List<String> headers) {
        this.headers = headers;
        return  this;
    }
    public List<NameValuePair> getQueryParams(){
        return  URLEncodedUtils.parse(uri, StandardCharsets.UTF_8);
    }

    public List<NameValuePair> getQueryParam(String name){
        return getQueryParams().stream()
                .filter(x-> x.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
