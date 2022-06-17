package ru.smurov.cam_cam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SourceDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String urlType;
    private String videoUrl;
}
