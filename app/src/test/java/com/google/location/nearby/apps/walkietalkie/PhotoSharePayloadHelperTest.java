package com.google.location.nearby.apps.walkietalkie;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/** Unit tests for photo-share payload "payloadId:filename" parsing. */
public class PhotoSharePayloadHelperTest {

  @Test
  public void parse_validMessage_returnsPayloadIdAndFilename() {
    PhotoSharePayloadHelper.PayloadFilename result =
        PhotoSharePayloadHelper.parse("12345:image.jpg");
    assertThat(result).isNotNull();
    assertThat(result.payloadId).isEqualTo(12345L);
    assertThat(result.filename).isEqualTo("image.jpg");
  }

  @Test
  public void parse_messageWithPath_returnsFilenameAfterColon() {
    PhotoSharePayloadHelper.PayloadFilename result =
        PhotoSharePayloadHelper.parse("999:primary/DCIM/Photo.png");
    assertThat(result).isNotNull();
    assertThat(result.payloadId).isEqualTo(999L);
    assertThat(result.filename).isEqualTo("primary/DCIM/Photo.png");
  }

  @Test
  public void parse_null_returnsNull() {
    assertNull(PhotoSharePayloadHelper.parse(null));
  }

  @Test
  public void parse_noColon_returnsNull() {
    assertNull(PhotoSharePayloadHelper.parse("no-colon"));
  }

  @Test
  public void parse_nonNumericId_returnsNull() {
    assertNull(PhotoSharePayloadHelper.parse("abc:file.jpg"));
  }
}
