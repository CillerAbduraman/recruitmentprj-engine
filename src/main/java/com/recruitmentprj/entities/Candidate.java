package com.recruitmentprj.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CANDIDATES")
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "candidateLanguages") //aici pun tabelele cu care exista o relatie one to many, le pun cu virgula
public class Candidate {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Embedded
    private Contact contact = new Contact();

    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;

    @Column(name = "MOST_RECENT_EMPLOYER")
    private String mostRecentEmployer;

    @Column(name = "MOST_RECENT_JOB_TITLE")
    private String mostRecentJobTitle;

    @Column(name = "EDUCATION")
    private String education;

    @Column(name = "SALARY_PREFERENCE")
    private String salaryPreference;


    @OneToMany(mappedBy = "candidate")
    private List<CandidateLanguage> candidateLanguages;
}
