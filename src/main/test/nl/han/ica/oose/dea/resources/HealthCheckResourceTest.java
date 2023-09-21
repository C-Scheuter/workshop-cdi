package nl.han.ica.oose.dea.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCheckResourceTest {
    @Test
    void checkHealthCheckReallySaysHealth() {
        //Arrange
        HealthCheckResource healthCheckResource = new HealthCheckResource();
        String goedAntwoord = "Up & Running";

        //Act
        String antwoord = healthCheckResource.healthy();

        //Assert
        Assertions.assertEquals(antwoord, goedAntwoord);
    }
}