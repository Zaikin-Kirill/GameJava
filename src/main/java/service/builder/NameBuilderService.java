package service.builder;

import service.parser.JsonParserService;
import service.webapi.HttpApiService;

public class NameBuilderService {

    public String getRequestRandomWord(String targetUrl) {
        HttpApiService httpService = new HttpApiService();
        String response = httpService.sendGetRequest(targetUrl);
        if (response != null) {
            String[] arrayString = new JsonParserService().getArrayStringFromJsonString(response);
            if (arrayString.length != 0) {
                return arrayString[0];
            }
        }
        return "";
    }
}
