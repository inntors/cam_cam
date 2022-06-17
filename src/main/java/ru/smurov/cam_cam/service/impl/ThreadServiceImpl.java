package ru.smurov.cam_cam.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.smurov.cam_cam.config.properties.ExchangeProperties;
import ru.smurov.cam_cam.dto.DataDto;
import ru.smurov.cam_cam.dto.SourceDto;
import ru.smurov.cam_cam.dto.TokenDto;
import ru.smurov.cam_cam.service.ThreadService;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class ThreadServiceImpl implements ThreadService {

    private final ExchangeProperties properties;
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    @Override
    public DataDto[] getData() {
        ResponseEntity<DataDto[]> resp = restTemplate.exchange(properties.getSource(),
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                DataDto[].class);
        return resp.getBody();
    }

    @Async
    @Override
    public CompletableFuture<SourceDto> getSource(String sourceUrl) {
        ResponseEntity<SourceDto> response = restTemplate.exchange(sourceUrl,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                SourceDto.class);
        return CompletableFuture.completedFuture(response.getBody());
    }

    @Async
    @Override
    public CompletableFuture<TokenDto> getToken(String tokenUrl) {
        ResponseEntity<TokenDto> response = restTemplate.exchange(tokenUrl,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                TokenDto.class);
        return CompletableFuture.completedFuture(response.getBody());
    }
}
