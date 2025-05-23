package com.twinleaves.batchtracker.repository;

import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.entity.GlobalTradeItemNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GlobalTradeItemNumberRepository extends JpaRepository<GlobalTradeItemNumber,Long> {
    Optional<GlobalTradeItemNumber> findByGtin(String gtin);

    List<GlobalTradeItemNumber> findAllByProductId(Long id);
}
