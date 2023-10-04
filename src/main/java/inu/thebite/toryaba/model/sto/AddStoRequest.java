package inu.thebite.toryaba.model.sto;


import lombok.Data;

@Data
public class AddStoRequest {

    private String name;

    private String contents;

    private int count;

    private int goal;

    private String urgeType;

    private String urgeContent;

    private String enforceContent;

    private String memo;

}
