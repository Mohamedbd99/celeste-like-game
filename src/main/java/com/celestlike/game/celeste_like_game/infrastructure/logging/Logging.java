package com.celestlike.game.celeste_like_game.infrastructure.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Centralized logging helper. Avoid spamming logs every frame.
public final class Logging {

    private Logging() { }

    public static Logger getLogger(Class<?> type) {
        return LoggerFactory.getLogger(type);
    }
}
