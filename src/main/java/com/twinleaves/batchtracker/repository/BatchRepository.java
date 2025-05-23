package com.twinleaves.batchtracker.repository;

import com.twinleaves.batchtracker.entity.Batch;
import com.twinleaves.batchtracker.entity.GlobalTradeItemNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Long> {
    List<Batch> findByGlobalTradeItemNumber(GlobalTradeItemNumber globalTradeItemNumber);

    List<Batch> findByAvailableQuantityGreaterThan(int quantity);

    @Query(value = """
    SELECT b.*
    FROM batch b
    JOIN (
        SELECT gtin_id, MAX(inwarded_on) AS latest_inwarded
        FROM batch
        WHERE available_quantity <= 0
        GROUP BY gtin_id
    ) latest_batches
    ON b.gtin_id = latest_batches.gtin_id
       AND b.inwarded_on = latest_batches.latest_inwarded
    WHERE b.available_quantity <= 0
    """, nativeQuery = true)
    List<Batch> findLatestNonPositiveBatchesPerGtin();





}
