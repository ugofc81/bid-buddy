package com.me.bidbuddy.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(
        name = "bidders",
        uniqueConstraints = @UniqueConstraint(columnNames = {"auction_guid", "bidder_name"})
)
public class Bidder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Automatically generates clean UUIDs!
    @Column(name = "id", length = 16)
    @JdbcTypeCode(SqlTypes.BINARY) // Forces Hibernate to use MySQL's BINARY(16)
    private UUID id;

    @Column(nullable = false, name = "auction_guid")
    private UUID auctionGuid;

    @Column(nullable = false, name = "bidder_name")
    private String bidderName;

    public Bidder() {
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

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }
}
