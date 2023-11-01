package inu.thebite.toryaba.model.lto;

import lombok.Data;

import java.util.List;

@Data
public class LtoGraphResponse {

    private Long stoId;

    private List<List<Float>> result;

    public static LtoGraphResponse response(Long stoId, List<List<Float>> result) {
        LtoGraphResponse response = new LtoGraphResponse();
        response.stoId = stoId;
        response.result = result;
        return response;
    }
}
