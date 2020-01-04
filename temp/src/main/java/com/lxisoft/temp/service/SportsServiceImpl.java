package com.lxisoft.temp.service;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lxisoft.temp.model.Sports;

//import org.elasticsearch.action.search.*;
public class SportsServiceImpl implements SportsService {
	
	@Autowired
	RestHighLevelClient client;
	
	public Sports findByName(String name)throws IOException
	{
		org.elasticsearch.index.query.QueryBuilder dslQuery=QueryBuilders.termQuery("name", name);
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		//Object client;
		SearchResponse response=null;
		 response=client.search(sr,RequestOptions.DEFAULT);
		//SearchHits searchHits=searchResponse.getHits();
		//List<Sports> searchHits = Arrays.asList(response.getHits().getHits());
		 SearchHit[] searchHit = response.getHits().getHits();
		// List<Sports> list = new ArrayList<>();
		 for(SearchHit hit: searchHit)
		 {
			 System.out.println(hit);
		 }
        return null;

	}

	
	

}
