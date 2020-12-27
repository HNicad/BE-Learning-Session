package com.nijad.database.util;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

import java.nio.charset.Charset;

public class RandomUtil {
    public static final EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
            .seed(1000)
            .randomizationDepth(2)
            .charset(Charset.forName("UTF-8"))
            .stringLengthRange(3,7)
            .collectionSizeRange(1,5)
            .scanClasspathForConcreteTypes(true)
            .overrideDefaultInitialization(false)
            .build();
}
