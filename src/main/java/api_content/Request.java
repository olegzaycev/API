package api_content;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class Request {

    private String method;
    private String protocol;
    private int port;
    private String host;
    private String path;
    private Map<String,String> argMap;

    private String body;

    private Map<String,String> headerMap;

    public URI getURI() {
        try {
            return new URI(protocol+"://"+host+"/"+path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return null;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getArgMap() {
        return argMap;
    }

    public void setArgMap(Map<String, String> argMap) {
        this.argMap = argMap;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", protocol='" + protocol + '\'' +
                ", port=" + port +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", argMap=" + argMap +
                ", body='" + body + '\'' +
                ", headerMap=" + headerMap +
                '}';
    }
}
