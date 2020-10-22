package edu.eci.arsw.weather.APIConsumers;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Service
public class ApiConsumerImpl {

    private String url;
    private String key;
    private String host;

    public ApiConsumerImpl() {
        url = "http://api.openweathermap.org/data/2.5";
        key = "9e324e1015bb65837955b4d0ceadbd8e";
    }

    /**
     * Obtiene el clima de una ciudad en específico
     * @param city El nombre de la ciudad a buscar
     * @return Un string con el clima de la ciudad
     * @throws ApiConsumerException cuando la ciudad no existe , hay un problema con la conexión o la URL está mal formada
     */
    public String getWeatherByCity(String city) throws ApiConsumerException{
        try {
            URL obj = new URL(url + "/weather?q=" + city+"&appid="+key);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            StringBuffer response = null;
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
            } else {
                throw new ApiConsumerException("City not found");
            }
            return String.valueOf(response);
        } catch(MalformedURLException ex){
            throw new ApiConsumerException(ex.getMessage());
        } catch(IOException ex){
            throw new ApiConsumerException(ex.getMessage());
        }
    }
}