package com.me.bidbuddy.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "auctions") // Maps this class to a "users" table in MySQL
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generates clean UUIDs!
    @Column(name = "id", length = 16)
    @JdbcTypeCode(SqlTypes.BINARY) // Forces Hibernate to use MySQL's BINARY(16)
    private UUID id;

    @Column(nullable = false, unique = true, name = "item_name")
    private String ItemName;

    @Column(nullable = true, unique = false, name = "evaluation_amount")
    private double evaluationAmount;

    @Column(nullable = true, unique = false, name = "minimum_bid")
    private double minimumBid;

    public Auction() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getEvaluationAmount() {
        return evaluationAmount;
    }

    public void setEvaluationAmount(double evaluationAmount) {
        this.evaluationAmount = evaluationAmount;
    }

    public double getMinimumBid() {
        return minimumBid;
    }

    public void setMinimumBid(double minimumBid) {
        this.minimumBid = minimumBid;
    }
}
