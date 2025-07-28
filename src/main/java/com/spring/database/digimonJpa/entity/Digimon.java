package com.spring.database.digimonJpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_digimon")
public class Digimon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_id")
    private Long id;

    @Column(name = "digimon_nm", length = 50, nullable = false)
    private String name; // 디지몬이름

    @CreationTimestamp // Insert 시 자동으로 시간을 저장
    @Column(updatable = false) // 수정 불가
    private LocalDateTime createdAt; // 디지몬 등록 시간

    @UpdateTimestamp // UPDATE문 실행 시 자동으로 시간 수정
    private LocalDateTime updateAt; // 디지몬 최종 수정 시간

    //열거형 데이터
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private DigimonCategory digimonCategory;
//
//    public


}
