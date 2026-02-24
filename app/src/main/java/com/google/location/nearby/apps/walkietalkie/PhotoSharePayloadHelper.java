package com.google.location.nearby.apps.walkietalkie;

import androidx.annotation.Nullable;

/**
 * Helper for photo-share payload format: "payloadId:filename" sent as BYTES before the FILE payload.
 */
public final class PhotoSharePayloadHelper {

  private PhotoSharePayloadHelper() {}

  /**
   * Parses a message "payloadId:filename". Returns null if format is invalid.
   */
  @Nullable
  public static PayloadFilename parse(String message) {
    if (message == null || !message.contains(":")) {
      return null;
    }
    int colon = message.indexOf(':');
    try {
      long payloadId = Long.parseLong(message.substring(0, colon));
      String filename = message.substring(colon + 1);
      return new PayloadFilename(payloadId, filename);
    } catch (NumberFormatException e) {
      return null;
    }
  }

  public static final class PayloadFilename {
    public final long payloadId;
    public final String filename;

    public PayloadFilename(long payloadId, String filename) {
      this.payloadId = payloadId;
      this.filename = filename;
    }
  }
}
