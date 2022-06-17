package ru.smurov.cam_cam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smurov.cam_cam.service.CamService;

@RequiredArgsConstructor
@RestController
public class CamController {

    private final CamService camService;

    @GetMapping(path = "/cams")
    public ResponseEntity<?> cams() {
        return ResponseEntity.ok(camService.cams());
    }
}
