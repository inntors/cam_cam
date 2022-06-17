package ru.smurov.cam_cam.service;

import ru.smurov.cam_cam.dto.DataDto;
import ru.smurov.cam_cam.dto.SourceDto;
import ru.smurov.cam_cam.dto.TokenDto;

import java.util.concurrent.CompletableFuture;

public interface ThreadService {

    DataDto[] getData();
    CompletableFuture<SourceDto> getSource(String sourceUrl);
    CompletableFuture<TokenDto> getToken(String tokenUrl);
}
