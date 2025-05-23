package com.twinleaves.batchtracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer minRetailPrice;

    @Column(nullable = false)
    private Integer sellingPrice;

    @Column(nullable = false)
    private Integer purchasePrice;

    @Column(nullable = false)
    private Integer availableQuantity;

    @ManyToOne
    @JoinColumn(name="gtin_id",nullable = false)
    private GlobalTradeItemNumber globalTradeItemNumber;

    @CreationTimestamp
    private LocalDateTime inwardedOn;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(id, batch.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
