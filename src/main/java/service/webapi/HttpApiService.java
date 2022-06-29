package service.webapi;

import service.io.ConsoleMassageService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HttpApiService implements ApiService{

    /**
     * Сервис вывода на экран.
     */
    private final ConsoleMassageService consoleMassageService = ConsoleMassageService.getInstance();

    @Override
    public StringBuilder sendGetRequest(String targetUrl) {
        HttpURLConnection connection = null;
        int timeoutValue = 5000;
        try {
            URL url = new URL(targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(timeoutValue);
            connection.setReadTimeout(timeoutValue);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                consoleMassageService.print("Ошибка. Код ответа: " + responseCode);
                return null;
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response;
        }
        catch (SocketTimeoutException e) {
            consoleMassageService.print("Превышен таймаут: " + timeoutValue);
            return null;
        }
        catch (IOException e) {
            consoleMassageService.print("Ошибка получения ответа: " + e.getMessage());
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}



