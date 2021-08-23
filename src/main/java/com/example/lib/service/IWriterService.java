package com.example.lib.service;

import com.example.lib.model.Writer;

import java.util.List;

public interface IWriterService {
    List<Writer> getAllWriters();
    Writer deleteWriterById(long id);
    Writer createWriter(Writer writer);
}
