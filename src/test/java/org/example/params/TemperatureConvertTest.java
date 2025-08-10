package org.example.params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class TemperatureConvertTest {


    @ParameterizedTest
    @EnumSource(
            value = TemperatureConverter.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = {"KELVIN_CELSIUS"})
    void  test_tempShouldBePositive(TemperatureConverter imput) {
        assertThat(imput.converterTemp(10))
                .isPositive();
    }



}
