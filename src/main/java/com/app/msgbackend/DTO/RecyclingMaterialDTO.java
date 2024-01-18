package com.app.msgbackend.DTO;

import com.app.msgbackend.model.Materials;
import com.app.msgbackend.model.QuantityType;
import lombok.Data;

@Data
public class RecyclingMaterialDTO {
    private Materials materials;
    private Double quantity;
    private QuantityType quantityType;
}
