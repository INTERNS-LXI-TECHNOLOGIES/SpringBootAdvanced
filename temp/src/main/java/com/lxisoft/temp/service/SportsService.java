package com.lxisoft.temp.service;

import java.io.IOException;

import com.lxisoft.temp.model.Sports;

public interface SportsService {
	public Sports findByName(String name) throws IOException;
}
