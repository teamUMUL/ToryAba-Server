package inu.thebite.toryaba.model.lto;

import lombok.Data;

@Data
public class AddLtoRequest {

    // lto 이름

    private String name;

    // lto 내용
    private String content;
}
