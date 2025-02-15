package com.javazigsdl3test.runner;

import com.javazigsdl3test.library.NativesInstaller;
import com.javazigsdl3test.library.java_zig_sdl3_test_h;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        NativesInstaller.ensureLoaded();
        System.out.println("Starting SDL3");
        java_zig_sdl3_test_h.init();
        System.out.println("Finished");
    }
}
