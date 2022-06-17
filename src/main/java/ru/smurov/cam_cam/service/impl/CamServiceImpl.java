package ru.smurov.cam_cam.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.smurov.cam_cam.dao.CamDao;
import ru.smurov.cam_cam.dto.SourceDto;
import ru.smurov.cam_cam.dto.TokenDto;
import ru.smurov.cam_cam.mapper.Mapper;
import ru.smurov.cam_cam.service.CamService;
import ru.smurov.cam_cam.service.ThreadService;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.Collections.synchronizedCollection;

@Log4j2
@RequiredArgsConstructor
@Service
public class CamServiceImpl implements CamService {

    private final ThreadService threadService;
    private final Mapper mapper;

    @Override
    public Collection<CamDao> cams() {

        Collection<CamDao> collection = synchronizedCollection(new HashSet<CamDao>());
        Arrays.asList(threadService.getData()).parallelStream().forEach(data -> {
            CompletableFuture<SourceDto> source = threadService.getSource(data.getSourceDataUrl());
            CompletableFuture<TokenDto> token = threadService.getToken(data.getTokenDataUrl());
            CompletableFuture.allOf(source, token).join();
            try {
                collection.add(mapper.toDataCams(data, source.get(), token.get()));
            } catch (Exception e) {
                log.error("Camera id = {} processing error: {}", data.getId(), e.getMessage());
            }
        });
        return collection;
    }
}
