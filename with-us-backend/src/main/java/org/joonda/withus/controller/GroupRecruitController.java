package org.joonda.withus.controller;

import lombok.RequiredArgsConstructor;
import org.joonda.withus.dto.GroupRecruitDto;
import org.joonda.withus.service.GroupRecruitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groupRecruit")
public class GroupRecruitController {
    private final GroupRecruitService groupRecruitService;

    @PostMapping("/save")
    public ResponseEntity<?> recruitGroup(@RequestBody GroupRecruitDto groupRecruitDto) {
        groupRecruitService.recruitGroup(groupRecruitDto);

        Map<String, String> response = new HashMap<>();
        response.put("message", "동행 모집이 성공적으로 등록되었습니다.");
        return ResponseEntity.ok(response);
    }
}
