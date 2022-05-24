package com.zestic.apim.repository.mongodb.service;

import com.zestic.apim.repository.mongodb.entity.Sequence;
import com.zestic.apim.repository.mongodb.repository.SequenceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SequenceGeneratorService {

    private final SequenceRepository repository;

    public SequenceGeneratorService(SequenceRepository repository) {
        this.repository = repository;
    }

    public long generateSequence(final String id) {
        Sequence sequence = new Sequence();
        long value = 1L;
        if (this.repository.count() <= 0) {
            save(id, value);
        } else {
            Optional<Sequence> temp = this.repository.findById(id);
            if (temp.isPresent()) {
                value = temp.get().getSeq() + 1L;
                save(temp.get().getId(), value);
            } else {
                save(id, value);
            }
        }
        return value;
    }

    private void save(String id, long value) {
        Sequence sequence = new Sequence();
        sequence.setId(id);
        sequence.setSeq(value);
        this.repository.save(sequence);
    }
}
