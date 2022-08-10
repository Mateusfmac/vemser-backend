package com.veiculoprodutorconsumidor.sensor.repository;

import com.veiculoprodutorconsumidor.sensor.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoEntity, Integer> {
    
    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg: $velocidade }}}" })
    Double mediaVelocidade();
    
    @Aggregation(pipeline = { "{$group : { _id:  '', total:  {$avg: $rotacao }}}"})
    Double mediaRotacao();
}
