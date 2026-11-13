package com.me.bidbuddy.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(
        name = "bids"
)
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generates clean UUIDs!
    @Column(name = "id", length = 16)
    @JdbcTypeCode(SqlTypes.BINARY) // Forces Hibernate to use MySQL's BINARY(16)
    private UUID id;

    @Column(nullable = false, name = "auction_guid")
    private UUID auctionGuid;

    @Column(nullable = false, name = "bidder_guid")
    private String bidderGuid;

    @Column(nullable = false, name = "datetime")
    private Date datetime;

    @Column(nullable = false, name = "amount")
    private double amount;

    public Bid() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAuctionGuid() {
        return auctionGuid;
    }

    public void setAuctionGuid(UUID auctionGuid) {
        this.auctionGuid = auctionGuid;
    }

    public String getBidderGuid() {
        return bidderGuid;
    }

    public void setBidderGuid(String bidderGuid) {
        this.bidderGuid = bidderGuid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
