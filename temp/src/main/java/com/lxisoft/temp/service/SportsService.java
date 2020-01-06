package com.lxisoft.temp.service;

import java.io.IOException;
import java.util.List;

import com.lxisoft.temp.model.Sports;

public interface SportsService {
	public List<Sports> findAll() throws IOException;
	public List<Sports> findAllByRange(Integer start,Integer end) throws IOException;
	public List<Sports> findAllByBool(String name,Integer start,Integer end)throws IOException;
	public List<Sports> findAllUsingMustAndFilter(String name)throws IOException;
	public List<Sports> findAllUsingMustnot(String name)throws IOException;
	public List<Sports> findAllUsingShould(String name,Integer start,Integer end)throws IOException;
	public List<Sports> findAllUsingFilter(String name)throws IOException;
	public List<Sports> findAllUsingSort(String name)throws IOException;
	public List<Sports> sortByAge(String name)throws IOException;
}
