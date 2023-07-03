package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.RequestId;

import java.util.Optional;

public class NetworkDevTools {
    public WebDriver driver;
    public NetworkDevTools(WebDriver driver) {
        this.driver = driver;
    }


    public void getNetworkResponse(){
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(), Optional.of(100000000)));
        final RequestId[] requestIds = new RequestId[1];
        devTools.addListener(Network.requestWillBeSent(), request -> {
            String requestMethod = request.getRequest().getMethod();
            if (requestMethod.equalsIgnoreCase("post")) {
                System.out.println("Request URL : " + request.getRequest().getUrl());
                requestIds[0] = request.getRequestId();
                String requestBody = devTools.send(Network.getRequestPostData(requestIds[0])).toString();
                System.out.println("Request Body " + requestBody);
            }
        });
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            requestIds[0] = responseReceived.getRequestId();
            String url = responseReceived.getResponse().getUrl();
            if (url.contains("register") || url.contains("login")) {
                System.out.println("Response url : " + url);
                int status = responseReceived.getResponse().getStatus();
                System.out.println("Response status : " + status);
                String type = responseReceived.getType().toJson();
                String responseBody = devTools.send(Network.getResponseBody(requestIds[0])).getBody();
                System.out.println("Response body : " + responseBody);
            }
        });

    }
}
