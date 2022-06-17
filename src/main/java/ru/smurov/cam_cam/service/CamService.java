package ru.smurov.cam_cam.service;

import ru.smurov.cam_cam.dao.CamDao;

import java.util.Collection;
import java.util.List;

public interface CamService {

    Collection<CamDao> cams();
}
