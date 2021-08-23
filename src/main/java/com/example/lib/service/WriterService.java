package com.example.lib.service;

import com.example.lib.model.Student;
import com.example.lib.model.Writer;
import com.example.lib.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService implements IWriterService{
    @Autowired
    public WriterRepository _writerRepository;

    public WriterService(WriterRepository _writerRepository) { this._writerRepository = _writerRepository; }

    public List<Writer> getAllWriters() {
        return _writerRepository.findAll();
    }

    public Writer createWriter(Writer writer) {
        return _writerRepository.save(writer);
    }

    public Writer deleteWriterById(long id) {
        Writer writer = _writerRepository.findById(id).get();
        _writerRepository.delete(writer);
        return writer;
    }


}
