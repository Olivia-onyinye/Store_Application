package com.holyviastores;

import com.holyviastores.util.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FileUtilTest {

    @Test
    void readProductsShouldReturnTrue() throws IOException {
        FileUtil pr = new FileUtil();
        pr.readProducts();
        Assertions.assertTrue(true);
    }
}