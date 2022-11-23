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

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(applicationUser, that.applicationUser))
            return false;
        if (!angryValue.equals(that.angryValue)) return false;
        if (!joyValue.equals(that.joyValue)) return false;
        if (!surpriseValue.equals(that.surpriseValue)) return false;
        if (!sadnessValue.equals(that.sadnessValue)) return false;
        if (!happyValue.equals(that.happyValue)) return false;
        return fearValue.equals(that.fearValue);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (applicationUser != null ? applicationUser.hashCode() : 0);
        result = 31 * result + angryValue.hashCode();
        result = 31 * result + joyValue.hashCode();
        result = 31 * result + surpriseValue.hashCode();
        result = 31 * result + sadnessValue.hashCode();
        result = 31 * result + happyValue.hashCode();
        result = 31 * result + fearValue.hashCode();
        return result;
    }
}
