package com.harrishjoshi.distributed.scheduling.repository;

import com.harrishjoshi.distributed.scheduling.entity.Card;
import com.harrishjoshi.distributed.scheduling.enums.CardStatus;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("""
            SELECT c FROM Card c
            JOIN FETCH c.customer
            WHERE c.status = :status AND c.expirationDate < :expirationDate
            ORDER BY c.expirationDate DESC
            LIMIT 50
            """)
    @QueryHints({
            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "0") // nowait
    })
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Card> findTop50ByStatusAndExpirationDateLessThanOrderByExpirationDateDesc(
            @Param("status") CardStatus status,
            @Param("expirationDate") LocalDate expirationDate
    );
}
