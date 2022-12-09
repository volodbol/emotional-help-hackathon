package com.epam.hackathon.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "emotional_map")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)

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

    @Column(name = "create_date")
    private LocalDateTime createDate;

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

    @PrePersist
    public void onPrePersist() {
        setCreateDate(LocalDateTime.now());
    }
}
