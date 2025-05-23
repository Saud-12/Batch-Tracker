package com.twinleaves.batchtracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="gtin",uniqueConstraints = {
        @UniqueConstraint(columnNames = "gtin")
})

public class GlobalTradeItemNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="gtin", nullable = false)
    private String gtin;

    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private Product product;

    @OneToMany(mappedBy = "globalTradeItemNumber")
    @JsonIgnore
    private List<Batch> batchList;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GlobalTradeItemNumber that = (GlobalTradeItemNumber) o;
        return Objects.equals(id, that.id) && Objects.equals(gtin, that.gtin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gtin);
    }
}
