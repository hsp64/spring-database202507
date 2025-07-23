package com.spring.database.digimon.api;

import com.spring.database.digimon.entity.Digimon;
import com.spring.database.digimon.repository.DigimonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/digimon")
@RequiredArgsConstructor
@Slf4j
public class digimonController {

    private final DigimonRepository digimonRepository;

    // 전체 조회 요청
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(digimonRepository.findAll());
    }

    // 생성 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Digimon digimon) {
        digimonRepository.save(digimon);
        return ResponseEntity.ok("디지몬 등록 성공");
    }

    // 수정 요청
    @PostMapping("/{id}")
    public ResponseEntity<?> updateDigimon(@RequestBody Digimon digimon) {
        digimonRepository.updateNameAndType(digimon);
        return ResponseEntity.ok("디지몬 수정 성공");
    }

    //개별 조회 요청
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        digimonRepository.deleteById(id);
        return ResponseEntity.ok("도서 삭제 성공!");
    }

    // 개별 조회 요청
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(digimonRepository.findById(id));
    }
}
