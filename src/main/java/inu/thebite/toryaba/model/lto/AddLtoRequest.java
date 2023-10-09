package inu.thebite.toryaba.model.lto;

import lombok.Data;

@Data
public class AddLtoRequest {

    // Lto 이름
    private String name;

    // Lto 내용
    private String contents;
}
