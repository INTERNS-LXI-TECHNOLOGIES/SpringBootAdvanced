package com.gokul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gokul.entity.Request;
import com.gokul.exception.ResourceNotFoundException;
import com.gokul.repository.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Transactional
    public List < Request > getRequest() {
        return requestRepository.findAll();
    }

    @Transactional
    public void saveRequest(Request theRequest) {
        requestRepository.save(theRequest);
    }

    @Transactional
    public Request getRequest(int id) throws ResourceNotFoundException {
        return requestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void deleteRequest(int theId) {
        requestRepository.deleteById(theId);
    }
}
