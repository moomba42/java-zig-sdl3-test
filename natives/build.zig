const std = @import("std");

pub fn build(b: *std.Build) void {
    const target = b.standardTargetOptions(.{});
    const optimize = b.standardOptimizeOption(.{});


    const lib = b.addSharedLibrary(.{
        .name = "java-zig-sdl3-test",
        .root_source_file = b.path("src/root.zig"),
        .target = target,
        .optimize = optimize,
    });
    b.installArtifact(lib);

    const sdl_dep = b.dependency("sdl", .{
        .target = target,
        .optimize = optimize,
        .preferred_link_mode = .dynamic,
    });
    const sdl_lib = sdl_dep.artifact("SDL3");
    lib.root_module.linkLibrary(sdl_lib);
}
