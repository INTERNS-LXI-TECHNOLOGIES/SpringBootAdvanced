package com.lxisoft.temp.service;

//import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.rangeQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxisoft.temp.model.Sports;

import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

//import org.elasticsearch.action.search.*;
@Service
public class SportsServiceImpl implements SportsService {
	
	@Autowired
	RestHighLevelClient client;
	@Autowired
	ObjectMapper objectMapper;
	public List<Sports> findAll()throws IOException
	{
	QueryBuilder dslQuery=QueryBuilders.matchAllQuery();
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		
		SearchResponse response=null;
		 response=client.search(sr,RequestOptions.DEFAULT);
				 SearchHit[] searchHit = response.getHits().getHits();
		 List<Sports> sports = new ArrayList<>();
		 for(SearchHit hit: searchHit)
		 {
			 
			sports.add(objectMapper.convertValue(hit.getSourceAsMap(),Sports.class));
			System.out.println(sports);
		 }
        return sports;

	}

	public List<Sports> findAllByRange(Integer start,Integer end) throws IOException
	{
		QueryBuilder dslQuery=QueryBuilders.rangeQuery("age").gt(start).lt(end);
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		SearchResponse response=client.search(sr,RequestOptions.DEFAULT);
		SearchHit[] searchHit =response.getHits().getHits();
		List<Sports> sports=new ArrayList<>();
		for(SearchHit hit:searchHit)
		{
			sports.add(objectMapper.convertValue(hit.getSourceAsMap(),Sports.class));
			System.out.println(sports);
		}
		return sports;
	}
	
	public List<Sports> findAllByBool(String name,Integer start,Integer end)throws IOException
	{
		QueryBuilder dslQuery=QueryBuilders.boolQuery()
				.must(termQuery("name",name)).must(rangeQuery("age").gt(start).lt(end));
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		SearchResponse response=client.search(sr,RequestOptions.DEFAULT);
		SearchHit[] searchHit=response.getHits().getHits();
		List<Sports> sports=new ArrayList<>();
		for(SearchHit hit:searchHit)
		{
			sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
			System.out.println(sports);
		}
		return sports;
	}
	
	public List<Sports> findAllUsingMustAndFilter(String name)throws IOException
	{
		QueryBuilder dslQuery=QueryBuilders.boolQuery().must(matchAllQuery()).filter(termQuery("name",name));
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		SearchResponse response=client.search(sr, RequestOptions.DEFAULT);
		SearchHit[] searchHit=response.getHits().getHits();
		List<Sports> sports=new ArrayList<>();
		for(SearchHit hit:searchHit)
		{
			sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
			System.out.println(sports);
		}
		return sports;
	}
	public List<Sports> findAllUsingMustnot(String name)throws IOException
	{
		QueryBuilder dslQuery=QueryBuilders.boolQuery().mustNot(termQuery("name",name));
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		SearchResponse response=client.search(sr, RequestOptions.DEFAULT);
		SearchHit[] searchHit=response.getHits().getHits();
		List<Sports> sports=new ArrayList<>();
		for(SearchHit hit:searchHit)
		{
			sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
			System.out.println(sports);
		}
		return sports;
	}
	
	public List<Sports> findAllUsingShould(String name,Integer start,Integer end)throws IOException
	{
		QueryBuilder dslQuery=QueryBuilders.boolQuery().should(termQuery("name",name)).should(rangeQuery("age").gt(20).lt(24));
		SearchSourceBuilder sb=new SearchSourceBuilder();
		sb.query(dslQuery);
		SearchRequest sr=new SearchRequest("sports");
		sr.source(sb);
		SearchResponse response=client.search(sr, RequestOptions.DEFAULT);
		SearchHit[] searchHit=response.getHits().getHits();
		List<Sports> sports=new ArrayList<>();
		for(SearchHit hit:searchHit)
		{
			sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
			System.out.println(sports);
		}
		return sports;
	}
     public List<Sports> findAllUsingFilter(String name)throws IOException
     {
    	QueryBuilder dslQuery=QueryBuilders.boolQuery().filter(termQuery("name",name));
 		SearchSourceBuilder sb=new SearchSourceBuilder();
 		sb.query(dslQuery);
 		SearchRequest sr=new SearchRequest("sports");
 		sr.source(sb);
 		SearchResponse response=client.search(sr, RequestOptions.DEFAULT);
 		SearchHit[] searchHit=response.getHits().getHits();
 		List<Sports> sports=new ArrayList<>();
 		for(SearchHit hit:searchHit)
 		{
 			sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
 			System.out.println(sports);
 		}
 		return sports;
     }
     public List<Sports> findAllUsingSort(String name)throws IOException
     {
    	 QueryBuilder dslQuery=QueryBuilders.termQuery("name",name);
    	 SearchSourceBuilder sb=new SearchSourceBuilder();
    	 sb.query(dslQuery);
    	 FieldSortBuilder sorting=new FieldSortBuilder("age").order(SortOrder.ASC);
    	 sb.sort(sorting);
    	 SearchRequest sr=new SearchRequest("sports");
    	 sr.source(sb);
    	 SearchResponse response=client.search(sr, RequestOptions.DEFAULT);
    	 SearchHit[] searchHit=response.getHits().getHits();
    	 List<Sports> sports=new ArrayList<>();
    	 for(SearchHit hit:searchHit)
    	 {
    		 sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
    		 System.out.println(sports);
    	 }
    	 return sports;
     }
     public List<Sports> sortByAge(String name)throws IOException
     {
    	 QueryBuilder dslQuery=QueryBuilders.termQuery("name",name);
    	 SearchSourceBuilder sb=new SearchSourceBuilder();
    	 sb.query(dslQuery);
    	 FieldSortBuilder sorting=new FieldSortBuilder("age").order(SortOrder.DESC);
    	 sb.sort(sorting);
    	 SearchRequest sr=new SearchRequest("sports");
    	 sr.source(sb);
    	 SearchResponse response=client.search(sr, RequestOptions.DEFAULT);
    	 SearchHit[] searchHit=response.getHits().getHits();
    	 List<Sports> sports=new ArrayList<>();
    	 for(SearchHit hit:searchHit)
    	 {
    		 sports.add(objectMapper.convertValue(hit.getSourceAsMap(), Sports.class));
    		 System.out.println(sports);
    	 }
    	 return sports;
     }
}
