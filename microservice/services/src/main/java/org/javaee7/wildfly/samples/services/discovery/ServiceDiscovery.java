package org.javaee7.wildfly.samples.services.discovery;

import java.net.URI;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

/**
 * @author arungupta
 */
public abstract class ServiceDiscovery {

    private WebTarget userService;
    private WebTarget catalogService;
    private WebTarget orderService;

    public abstract String getUserServiceURI();

    public abstract String getCatalogServiceURI();

    public abstract String getOrderServiceURI();

    public WebTarget getUserService() {
        if (null == userService) {
            userService = ClientBuilder
                    .newClient()
                    .target(
                            UriBuilder.fromUri(URI.create(getUserServiceURI()))
                                    .path("/user/resources/user")
                                    .build()
                    );
        }

        return userService;
    }

    public WebTarget getCatalogService() {
        if (null == catalogService) {
    		String serviceURI = getCatalogServiceURI();
//    		String serviceURI = "http://10.0.0.21:3000";
            catalogService = ClientBuilder
                    .newClient()
                    .target(
                            UriBuilder.fromUri(URI.create(serviceURI))
                                    .path("/catalog/resources/catalog")
                                    .build()
                    );

        }

        return catalogService;
    }

    public WebTarget getOrderService() {
        if (null == orderService) {
//    		String serviceURI = getOrderServiceURI();
    		String serviceURI = "http://10.0.0.21:3000";
            orderService = ClientBuilder
                    .newClient()
                    .target(
                            UriBuilder.fromUri(URI.create(serviceURI))
                                    .path("/order/resources/order")
                                    .build()
                    );

        }

        return orderService;
    }

}
