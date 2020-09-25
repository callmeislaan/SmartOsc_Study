package com.service;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CongTyServiceTest {
    @Test
    public void itShouldCreateEntity() {
        CongTyService congTyService = new CongTyService();
        congTyService.selectAll();
    }
}
