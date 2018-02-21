package org.aerogear.mobile.core.http;

/**
 * Generic interface for requests to HTTP Services.
 */

public interface HttpRequest {

    String CONTENT_TYPE_HEADER = "Content-Type";
    String JSON_MIME_TYPE = "application/json";
    HttpRequest addHeader(String key, String value);

    /**
     * Prepares the request for an HTTP GET of the given URL.
     * @param url a URL for a resource.
     */
    void get(String url);

    void post(String url, byte[] body);

    void put(String url, byte[] body);

    void delete(String url);

    /**
     * Create a HTTPResponse and begin executing the request. The request will be executed on a background thread.
     * @return an HTTPResponse instance that is executing the HttpRequest
     */
    HttpResponse execute();
}
