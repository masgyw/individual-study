package cn.gyw.frame.thirdpart.httpclient.v4_5_3.request;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.gyw.frame.thirdpart.httpclient.v4_5_3.exception.MethodNotSupportException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.util.CharsetUtils;

/**
 * Request for multi-part form data
 */
public class MultiPartFormRequest extends BaseEntityRequest {

    private Map<String, Object> parts;

    public MultiPartFormRequest(String url, RequestMethod method) throws MethodNotSupportException {
        super(url, method);
        this.parts = new LinkedHashMap<>();
    }

    public MultiPartFormRequest(String url) throws MethodNotSupportException {
        super(url);
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public HttpEntity getEntity()  {
        try {
            Charset charset = CharsetUtils.get(getRequestCharset());
            //Run in browser-compatible mode to prevent file names from being garbled.
            MultipartEntityBuilder builder = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .setCharset(charset);
            parts.forEach((key, value) -> {
                if (null != value && value instanceof File) { //for file
                    FileBody fileBody = new FileBody((File) value);
                    builder.addPart(key, fileBody);
                } else {
                    StringBody stringBody = new StringBody(null == value ? "" : value.toString()
                            , ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
                    builder.addPart(key, stringBody);
                }
            });
            return builder.build();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Charset '" + getRequestCharset() + "' is unsupported!");
        }
    }

    public void addPart(String name, Object body) {
        parts.put(name, body);
    }

    public void addParts(Map<String, Object> parts) {
        if (null != parts && !parts.isEmpty()) {
            this.parts.putAll(parts);
        }
    }

    public void removePart(String name) {
        parts.remove(name);
    }

    public Map<String, Object> getParts() {
        return parts;
    }
}
