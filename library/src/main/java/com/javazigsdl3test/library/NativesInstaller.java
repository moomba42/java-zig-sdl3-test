package com.javazigsdl3test.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NativesInstaller {
    /**
     * Unpacks all native libraries to a temporary directory and loads them
     *
     * @return A path to the directory that stores the native libraries
     * @throws IOException if something went wrong when transferring data
     */
    public static Path ensureLoaded() throws IOException {
        Path nativesFolderPath = Files.createTempDirectory("java-zig-sdl3-test-natives");
        System.load(copyLibrary("java-zig-sdl3-test", nativesFolderPath).toString());
        return nativesFolderPath;
    }

    private static Path copyLibrary(String libraryName, Path targetDirectory) throws IOException {
        String fullLibraryName = System.mapLibraryName(libraryName);
        Path libraryFile = Files.createFile(targetDirectory.resolve(fullLibraryName));
        libraryFile.toFile().deleteOnExit();

        try(var libraryStream = NativesInstaller.class.getClassLoader().getResourceAsStream(fullLibraryName)) {
            if(libraryStream == null) {
                throw new IOException("Could not open a stream to the library file ("+fullLibraryName+")");
            }

            libraryStream.transferTo(Files.newOutputStream(libraryFile));
        }

        return libraryFile;
    }
}
