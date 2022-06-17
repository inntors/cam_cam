package ru.smurov.cam_cam.mapper;

import org.springframework.stereotype.Component;
import ru.smurov.cam_cam.dao.CamDao;
import ru.smurov.cam_cam.dto.DataDto;
import ru.smurov.cam_cam.dto.SourceDto;
import ru.smurov.cam_cam.dto.TokenDto;

import java.util.Arrays;

@Component
public class Mapper {

    public CamDao toDataCams (DataDto data, SourceDto source, TokenDto token) throws Exception {

        if (!Arrays.asList("LIVE", "ARCHIVE").contains(source.getUrlType())){
            throw new Exception("Wrong camera type...");
        }
        CamDao camDao = new CamDao();
        camDao.setId(data.getId());
        camDao.setUrlType(source.getUrlType());
        camDao.setVideoUrl(source.getVideoUrl());
        camDao.setValue(token.getValue());
        camDao.setTtl(token.getTtl());
        return camDao;
    }
}
