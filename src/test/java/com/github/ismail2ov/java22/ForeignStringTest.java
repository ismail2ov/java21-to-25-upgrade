package com.github.ismail2ov.java22;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import org.junit.jupiter.api.Test;

class ForeignStringTest {

    @Test
    void strlenShouldReturnCorrectLength() throws Throwable {
        // 1. Get a linker – the central element for accessing foreign functions
        Linker linker = Linker.nativeLinker();

        // 2. Get a lookup object for commonly used libraries
        SymbolLookup stdlib = linker.defaultLookup();

        // 3. Look up the "strlen" function in the C standard library
        MemorySegment memorySegment = stdlib.find("strlen")
            .orElseThrow(() -> new IllegalStateException("strlen not found"));

        // 4. Define the input and output parameters of the "strlen" function
        FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);

        // 5. Get a handle to the "strlen" function
        MethodHandle strlen = linker.downcallHandle(memorySegment, descriptor);

        // 6. Create a confined memory arena for off-heap allocations
        try (Arena offHeap = Arena.ofConfined()) {

            // 7. Convert the Java String to a C string and store it in off-heap memory
            MemorySegment str = offHeap.allocateFrom("Hello World!");

            // 8. Invoke the foreign function
            long len = (long) strlen.invoke(str);

            // 9. Verify that strlen returned the correct length
            assertThat(len).isEqualTo(12);
        }
        // 10. All off-heap memory allocated in the arena
        // is automatically deallocated at end of try-with-resources
    }
}
