package com.app.msgbackend.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RecyclingSubmissionListDTO {
    private List<RecyclingMaterialDTO> submissions;
}
