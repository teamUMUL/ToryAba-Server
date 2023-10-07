package inu.thebite.toryaba.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CenterTest {

    @Test
    @DisplayName("센터 생성")
    public void createCenter() {
        // given
        Center center = Center.createCenter("송도점");

        // when, then
        assertThat(center.getName()).isEqualTo("송도점");
    }

}