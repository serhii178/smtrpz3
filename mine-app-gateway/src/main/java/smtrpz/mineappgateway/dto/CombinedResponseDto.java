package smtrpz.mineappgateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombinedResponseDto<T> {
    private T lCar;
    private String instance;
}

