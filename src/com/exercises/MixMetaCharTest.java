package com.exercises;

import static org.junit.Assert.*;

import org.junit.Test;

import com.utils.RegExpUtils;

/**
 * 混在メタキャラクターの演習
 *
 * 各テストケースの"regex"の値のみを変えて、
 * テストがグリーンとなるようにしてください。
 * regexには複数のメタキャラクターを指定してください。
 */
public class MixMetaCharTest {

  @Test
  public void 混在メタキャラクター_複数のメタキャラクターを組み合わせる() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("昭和60年 10月 25日", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("平成22年 02月 11日", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("2016年 08月 28日", regex).matches());
  }

  @Test
  public void 混在メタキャラクター_任意の長さの文字列() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("ID=UserName", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("user:daniel", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("Password = password1234", regex).matches());
  }

  @Test
  public void 混在メタキャラクター_指定の長さの文字列() {
    String regex = "";
    String regexStr = "私の名前は、" + regex + "です。";

    assertTrue(RegExpUtils.executeRegExp("私のWilliamはです。", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("私のMasonはです。", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("私のElijhaはです。", regexStr).matches());
    assertFalse(RegExpUtils.executeRegExp("私のJamesはです。", regexStr).matches());
    assertTrue(RegExpUtils.executeRegExp("私のBenjaminはです。", regexStr).matches());
  }

  @Test
  public void 混在メタキャラクター_指定文字の繰り返し() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("「ズン」「ズン」", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("「ズン」「ズン」「ズン」「ズン」「ドコ」", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("「ズン」「ズン」「ズン」", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("「ズン」", regex).matches());
  }

  @Test
  public void 混在メタキャラクター_文字の選択() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("2011/01/14", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("2005-11-22", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("1998/04-04", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("1953.07.12", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("1977 05 09", regex).matches());
  }

  @Test
  public void 混在メタキャラクター_文字の範囲指定と繰り返し() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("どうもはじめまして", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("ドウモハジメマシテ", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("どうも初めまして", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("どうもハジメマシテ", regex).matches());
  }

  @Test
  public void 混在メタキャラクター_大文字小文字の区別なし() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("oliver", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("OLliver", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("OlIver", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("oliVeR", regex).matches());
  }

}
