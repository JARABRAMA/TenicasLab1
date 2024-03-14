package org.tp24;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicSplitPaneUI;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationRunnerTest {
    private final ApplicationRunner applicationRunner = new ApplicationRunner();

    @Test
    public void run(){
        applicationRunner.run();
    }
}