#!/bin/sh

cd "$(dirname "$0")" || exit
git clone https://github.com/libsdl-org/SDL
cd SDL || exit
mkdir build
cd build || exit
cmake -DCMAKE_BUILD_TYPE=Release ..
cmake --build . --config Release --parallel
install_name_tool -id @rpath/libSDL3.dylib ./libSDL3.0.dylib
rm libSDL3.dylib
mv libSDL3.0.dylib libSDL3.dylib
cd ../../
