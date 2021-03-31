package com.ccut.whiteshark.dockermanage.client.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/3/27 5:33 下午
 */
public class HttpClient {


    public DockerClient client(DockerConfig dockerConfig){
        DockerClientConfig config = dockerConfig.config();
        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(1000)
                .build();

        DockerHttpClient.Request request = DockerHttpClient.Request.builder()
                .method(DockerHttpClient.Request.Method.GET)
                .path("/_ping")
                .build();

        try (
                DockerHttpClient.Response response = httpClient.execute(request)) {
                assertThat(response.getStatusCode(), equalTo(200));
                assertThat(IOUtils.toString(response.getBody()), equalTo("OK"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DockerClient instance = DockerClientImpl.getInstance(config, httpClient);
        return instance;
    }
}
