package com.Requests;

import com.google.gson.Gson;
import lombok.Data;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

@Data
public class RequestPetsStore {


    private final Links LINKS = new Links();
    private final Gson GSON = new Gson();


    public String resultCode(int code) {

        final String ANOTHER_ANSWER = "Another answer code " + code + " : ";

        if (code >= 100 && code < 200) {
            return ANOTHER_ANSWER + "Informational";
        }

        if (code >= 200 && code < 300) {
            return ANOTHER_ANSWER + "Success ";
        }

        if (code >= 300 && code < 400) {
            return ANOTHER_ANSWER + "Redirection";
        }


        if (code >= 400 && code < 500) {
            return ANOTHER_ANSWER + "Client Error";
        }

        if (code >= 500 && code < 600) {
            return ANOTHER_ANSWER + "Server Error ";
        }

        return ANOTHER_ANSWER + " ??? ";
    }


    protected void requestDeletes(String url) throws IOException {
        Jsoup.connect(url)
                .header("accept", "application/xml")
                .header("api_key", "special-key")
                .method(Connection.Method.DELETE)
                .execute();
    }


    protected String requestGet(String url) throws IOException {
        return Jsoup.connect(url).ignoreContentType(true).get().text();
    }

    protected void requestPut(String url, String gsonClass) throws IOException {
        Jsoup.connect(url)
                .header("accept", "application/xml")
                .header("Content-Type", "application/json")
                .requestBody(gsonClass)
                .method(Connection.Method.PUT)
                .execute();
    }

    protected void requestPutData(String url, HashMap<String, Object> data) throws IOException {
        Connection connection = Jsoup.connect(url);
        for (HashMap.Entry entry : data.entrySet()) {

            connection.data((String) entry.getKey(), entry.getValue().toString());
        }
        connection.ignoreContentType(true).post();
    }

    protected void requestUpdateFile(String url, File file, String format) throws IOException {
        Jsoup.connect(url)
                .data("additionalMetadata", format)
                .data("file", file.getName(), new FileInputStream(file))
                .ignoreContentType(true)
                .post();
    }

    protected void requestPost(String url, String gsonClass) throws IOException {
        Jsoup.connect(url)
                .header("accept", "application/xml")
                .header("Content-Type", "application/json")
                .requestBody(gsonClass)
                .method(Connection.Method.POST)
                .execute();
    }
}
