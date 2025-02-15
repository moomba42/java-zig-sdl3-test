## Requirements
1. Java 23 SDK (OpenJDK)
2. [jextract](https://github.com/openjdk/jextract) command available from the command line
3. [zig](https://github.com/ziglang/zig) command available from the command line

## Compiling and running SDL3 using Zig
```shell
mvn install
mvn exec:exec -pl runner
```

## Compiling and running SDL3 using CMake
```shell
cd natives && sh compile_sdl.sh
cd ..
mvn clean
mvn install -P use-cmake-lib
mvn exec:exec -pl runner
```
