package com.kennethmschwartz.app.banking.model;

import com.kennethmschwartz.app.banking.bean.Currency;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@Data
@Entity
@Table(name = "transactions")
//@RequiredArgsConstructor(staticName = "of")
public class Transaction implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NonNull
    private String type;

    @NonNull
    private ZonedDateTime date;

    @NonNull
    private Integer accountNumber;

    @NonNull
    private Currency currency;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private String merchantName;

    // maybe base64?
    private String merchantLogo;

    public static ZonedDateTime fromEST(int hour24, int minute, int day, int month, int year) {
        final String EST = "America/New_York";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("H m d M yyyy VV");
        final String asString = String.format("%d %d %d %d %d %s", hour24, minute, day, month, year, EST);
        //log.debug(String.format("sb: %s", asString));
        return ZonedDateTime.parse(asString, format);
    }
}
