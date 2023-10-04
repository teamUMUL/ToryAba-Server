package inu.thebite.toryaba.model.domain;


import lombok.Data;

@Data
public class AddDomainRequest {

    private int number;

    private String name;

    private String contents;

}
