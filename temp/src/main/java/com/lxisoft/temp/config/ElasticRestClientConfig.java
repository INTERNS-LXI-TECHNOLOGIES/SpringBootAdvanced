package com.lxisoft.temp.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticRestClientConfig {

	//@Value("${elasticsearch.host}")
	public String host="400540f9349e42179baf77cb0f3f798b.us-central1.gcp.cloud.es.io";
	//@Value("${elasticsearch.port}")
	public int port=9243;
	//@Value("${elasticsearch.username}")
	public String username="elastic";
	//@Value("${elasticsearch.password}")
	public String password="UK3RCBLhgWn3IH43EQ7ZoCtG";
	//@Value("${elasticsearch.scheme}")
	public String scheme="https";
	//@Value("${elasticsearch.connectTimeout}")
	public int connectTimeout=60;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	@Bean
	public RestHighLevelClient client() {
		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
		RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, scheme)).setHttpClientConfigCallback(
				httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
		builder.setRequestConfigCallback(
				requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(connectTimeout * 1000)
						.setSocketTimeout(connectTimeout * 1000).setConnectionRequestTimeout(0));

		RestHighLevelClient client = new RestHighLevelClient(builder);
		return client;
	}
}
