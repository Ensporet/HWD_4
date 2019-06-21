package com.HttpResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HttpResponse {

    private String url = "http://petstore.swagger.io/";


    public void response(HttpUriRequest request) {


        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(request)
        ) {

            System.out.println("Status code : " + response.getStatusLine().getStatusCode());
            HttpEntity httpEntity = response.getEntity();


            if (httpEntity != null) {
                InputStream inputStream = httpEntity.getContent();
                Scanner s = new Scanner(inputStream).useDelimiter("\\A");

                System.out.println(s.hasNext() ? s.next() : "");

                s.close();
                inputStream.close();

                System.out.println("\nHEADERS");
                for (Header header : response.getAllHeaders()) {
                    System.out.println("HEADER : " + header.getName() + " VALUE : " + header.getValue());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MethodResponse
    public void methodGet() {
        response(new HttpGet(getUrl()));
    }

    @MethodResponse
    public void methodHead() {
        response(new HttpHead(getUrl()));
    }

    @MethodResponse
    public void methodPost() {
        response(new HttpPost(getUrl()));
    }

    @MethodResponse
    public void methodPut() {
        response(new HttpPut(getUrl()));
    }

    @MethodResponse
    public void methodDelete() {
        response(new HttpDelete(getUrl()));
    }

    @MethodResponse
    public void methodTrace() {
        response(new HttpTrace(getUrl()));
    }

    @MethodResponse
    public void methodOptions() {
        response(new HttpOptions(getUrl()));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
