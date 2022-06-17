package ru.smurov.cam_cam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TokenDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String value;
    private int ttl;
}
