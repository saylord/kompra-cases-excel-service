package com.example.kompracasesexcelservice.repositories.implementations;

import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class NetworkRepositoryImpl {

    public String request(String endpoint) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        URL url = new URL(endpoint);

        // Open a connection to this URL
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            // Read in the bytes
            InputStream inputStream = urlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            // Read them as characters
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read one line at a time
            String inputLine = bufferedReader.readLine();
            while (inputLine != null) {
                // Add this to our output
                stringBuilder.append(inputLine);
                // Reading the next line
                inputLine = bufferedReader.readLine();
            }
        } finally {
            urlConnection.disconnect();
        }
        return stringBuilder.toString();
    }
}
