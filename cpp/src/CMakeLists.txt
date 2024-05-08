set(SRC_LIB_NAME src)
set(SOURCES
        Necklace.cpp
        Necklace.h
        JewelleryStorage.cpp
        JewelleryStorage.h
        Packer.cpp
        Packer.h
        Jewellery.cpp
        Jewellery.h
        Earring.cpp
        Earring.h
        Pendant.cpp
        Pendant.h
        Ring.cpp
        Ring.h
)
add_library(${SRC_LIB_NAME} ${SOURCES})
target_sources(${SRC_LIB_NAME} PRIVATE ${SOURCES})
target_include_directories(${SRC_LIB_NAME} PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
