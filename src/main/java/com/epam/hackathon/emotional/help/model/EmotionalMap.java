package com.epam.hackathon.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "emotional_map")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class EmotionalMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ApplicationUser applicationUser;

    private String anonymousUserId;

    private BigDecimal angryValue;

    private BigDecimal joyValue;

    private BigDecimal surpriseValue;

    private BigDecimal sadnessValue;

    private BigDecimal happyValue;

    private BigDecimal fearValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmotionalMap that = (EmotionalMap) o;
        return id.equals(that.id) && Objects.equals(applicationUser, that.applicationUser)
                && anonymousUserId.equals(that.anonymousUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applicationUser, anonymousUserId);
    }

}
