package com.epam.hackathon.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

    @Column(name = "anonymous_uuid")
    private String anonymousUUID;

    private Integer angryValue;

    private Integer joyValue;

    private Integer surpriseValue;

    private Integer sadnessValue;

    private Integer happyValue;

    private Integer fearValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmotionalMap that = (EmotionalMap) o;
        return id.equals(that.id) && angryValue.equals(that.angryValue) && joyValue.equals(that.joyValue)
                && surpriseValue.equals(that.surpriseValue) && sadnessValue.equals(that.sadnessValue)
                && happyValue.equals(that.happyValue) && fearValue.equals(that.fearValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, angryValue, joyValue, surpriseValue, sadnessValue, happyValue, fearValue);
    }

}
