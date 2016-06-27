package com.exercises;

import static org.junit.Assert.*;

import org.junit.Test;

import com.utils.RegExpUtils;

/**
 * 単一メタキャラクターの演習
 *
 * 各テストケースの"regex"の値のみを変えて、
 * テストがグリーンとなるようにしてください。
 * regexに指定できるメタキャラクターは1つのみです。
 *
 */
public class SimpleMetaCharTest {

  @Test
  public void 単一メタキャラクター_任意の1文字に一致() {
    String regex = "";
    String regexStr = "This is a " + regex;

    assertTrue(RegExpUtils.executeRegExp("This is a art", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("This is a pilot", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("This is a sea!", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("This is a sea", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_英字一文字に一致() {
    String regex = "";
    String regexStr = "This is a " + regex;

    assertTrue(RegExpUtils.executeRegExp("This is a art", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("This is a pilot", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("This is a sea!", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("This is a sea", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_数字に一致() {
    String regex = "";
    String regexStr = "あなたの誕生日は" + regex + "年です。";

    assertFalse(RegExpUtils.executeRegExp("あなたの誕生日は昭和60年です。", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("あなたの誕生日は1985年です。", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("あなたの誕生日は１９８５年です。", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("あなたの誕生日は1995年です。", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_空白文字に一致() {
    String regex = "";
    String regexStr = "山田" + regex + "太郎";

    assertTrue(RegExpUtils.executeRegExp("山田 太郎", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("山田太郎", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_単語の境界(){
    String regex = ".*\\bman\\b.*";

    assertFalse(RegExpUtils.executeRegExp("dead man's chest", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("iron man", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("roman holiday", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("scent of a woman", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("big man japan", regex).find());

  }

  @Test
  public void 単一メタキャラクター_0回以上の繰り返し() {
    String regex = "";
    String regexStr = "Hell" + regex + "o World";

    assertFalse(RegExpUtils.executeRegExp("Hellalllo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Hello World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Helllllllllo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Heo World", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_1回以上の繰り返し() {
    String regex = "";
    String regexStr = "Hel" + regex + "o World";

    assertTrue(RegExpUtils.executeRegExp("Helo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Helllllllllo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Heo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Hello World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Hellalllo World", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_n回の繰り返し() {
    String regex = "";
    String regexStr = "Hel" + regex + "o World";

    assertFalse(RegExpUtils.executeRegExp("Helo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Hellllo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Heo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Hello World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Helllllo World", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_n回以上の繰り返し() {
    String regex = "";
    String regexStr = "Hel" + regex + "o World";

    assertFalse(RegExpUtils.executeRegExp("Helo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Helllllo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Hello World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Hellllo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Heo World", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_n回以上m回以下の繰り返し() {
    String regex = "";
    String regexStr = "Hel" + regex + "o World";

    assertTrue(RegExpUtils.executeRegExp("Helllo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Hello World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Hellllllo World", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Helllllo World", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Helllllllo World", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_0回または1回発生() {
    String regex = "";
    String regexStr = "I like Toya-" + regex +  "ko";

    assertTrue(RegExpUtils.executeRegExp("I like Toya-ko", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("I like Toyako", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("I like Toya--ko", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("I like ToyAko", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_先文字の先頭に一致() {
    String regex = "";
    String regexStr = regex + "プログラミング.*";

    assertTrue(RegExpUtils.executeRegExp("プログラミング言語", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("プログラミングは難しい", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Javaはプログラミング言語", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_文字の末尾に一致() {
    String regex = "";
    String regexStr = ".*プログラミング言語" + regex;

    assertFalse(RegExpUtils.executeRegExp("プログラミングは難しい", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("プログラミング言語", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("Javaはプログラミング言語です。", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_指定した文字のいずれかに一致() {
    String regex = "";
    String regexStr = regex + "田.*";

    assertTrue(RegExpUtils.executeRegExp("岡田明丈", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("田中広輔", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("中田廉", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("黒田博樹", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_指定した文字の範囲にに一致() {
    String regex = "";
    String regexStr = regex + "いはうまい*";

    assertTrue(RegExpUtils.executeRegExp("かいはうまい", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("わいはうまい", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("こいはうまい", regexStr).matches());
  }

  @Test
  public void 単一メタキャラクター_指定したパターンのいずれかに一致() {
    String regex = "";
    String regexStr = regex;

    assertTrue(RegExpUtils.executeRegExp("Good", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Bad", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("Excellent", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("GoodExcellent", regexStr).matches());
  }

}
