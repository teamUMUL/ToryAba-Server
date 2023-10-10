package inu.thebite.toryaba.model.point;


import lombok.Data;

import java.util.List;

@Data
public class AddPointRequest {

    private List<String> points;

    private int round;

    private String registrant;
}
