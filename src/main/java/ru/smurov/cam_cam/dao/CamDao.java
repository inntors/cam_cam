package ru.smurov.cam_cam.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CamDao implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String urlType;
    private String videoUrl;
    private String value;
    private int ttl;
}
