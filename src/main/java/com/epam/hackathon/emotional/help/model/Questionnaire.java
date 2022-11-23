package com.epam.hackathon.emotional.help.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "questionnaire")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "questionnaire_questions_mapping",
            joinColumns = {@JoinColumn(name = "questionnaire_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "question_answers_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "question")
    @ToString.Exclude
    private Map<String, Answers> questionAnswersMap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questionnaire that = (Questionnaire) o;

        if (!id.equals(that.id)) return false;
        return Objects.equals(questionAnswersMap, that.questionAnswersMap);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (questionAnswersMap != null ? questionAnswersMap.hashCode() : 0);
        return result;
    }

}
