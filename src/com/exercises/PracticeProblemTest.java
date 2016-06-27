package com.exercises;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.utils.RegExpUtils;

/**
 * より実践的な問題
 */
public class PracticeProblemTest {

  /**
   * 偶数の数字にマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>先頭にゼロがあるものを対象としてもよい</li>
   * <li>+または-の符号は考慮しない</li>
   * </ul>
   */
  public void 偶数の数字にマッチする正規表現() {
    String regex = "";

    assertFalse(RegExpUtils.executeRegExp("1", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("2", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("3", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("4", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("45", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("456", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("4567", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("2468", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("159", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("100", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("0002", regex).matches());

  }

  /**
   * 携帯電話の番号にマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>携帯電話の番号は3桁、4桁、4桁の番号をハイフンで連結した11桁の番号</li>
   * <li>ハイフンは省略できる</li>
   * <li>最初の3桁は090または080で始まる</li>
   * </ul>
   */
  @Test
  public void 携帯電話の番号にマッチする正規表現() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("09012345678", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("08012345678", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("07012345678", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("090-1234-5678", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("080-1234-5678", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("070-1234-5678", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("090-12345678", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("09012345678", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("0901-2345678", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("090123456789", regex).matches());

  }

  /**
   * クレジットカード番号にマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>クレジットカード番号は13桁または16桁</li>
   * <li>最初の1桁は4</li>
   * </ul>
   */
  @Test
  public void クレジットカード番号にマッチする正規表現() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("4123456789012", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("41234567890123", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("4987654321098765", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("49876543210987656", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("12345678901234567", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("4123456789", regex).matches());

  }

  /**
   * 時刻にマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>「1：12」「12:34」「23：45」などの24時間表記の時刻を対象とする</li>
   * <li>時間は0時0分から23時59分までとする</li>
   * <li>時間が1桁の場合、前にゼロがついてもよい</li>
   * <li>分が1桁の場合には必ず前にゼロがつく</li>
   * </ul>
   */
  @Test
  public void 時刻にマッチする正規表現() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("1:12", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("12:34", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("23:45", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("25:20", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("02:34", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("00:00", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("0:00", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("23:59", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("24:00", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("13:01", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("12:1", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("5:5", regex).matches());

  }

  /**
   * 「キー=値」形式の文字列にマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>キーの部分は任意の英単語、値の部分は任意の文字列とする</li>
   * <li>値は省略可能</li>
   * <li>「=」の前後に空白可能</li>
   * </ul>
   */
  @Test
  public void キー値形式の文字列にマッチする正規表現() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("FirstName=太郎", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("FirstName = 次郎", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("Age = 30", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("Hobby = 映画, 読書", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("BirthDay = ", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("1985/08/28", regex).matches());

  }

  /**
   *  同じ英単語が2回以上連続で出現する部分にマッチする正規表現
   */
  @Test
  public void 同じ英単語が2回以上連続で出現する部分にマッチする正規表現() {
    String regex = "";

    String problemText01 = "This is is a pen.";
    List<String> actualList01 = RegExpUtils.getMatchesStr(problemText01, regex);
    List<String> expectedList01 = Arrays.asList("is", "is");

    assertThat(actualList01, is(expectedList01));

    String problemText02 = "This This is a pen pen pen .";
    List<String> actualList02 = RegExpUtils.getMatchesStr(problemText02, regex);
    List<String> expectedList02 = Arrays.asList("This", "This", "pen", "pen", "pen");

    assertThat(actualList02, is(expectedList02));
  }

  /**
   * URLのホスト名にマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>文字は英大文字、英小文字、数字、「-_.:@」</li>
   * <li>認証情報およびポート番号も含める</li>
   * <li>ホスト名の後には「/」がつく</li>
   * </ul>
   */
  @Test
  public void URLのホスト名にマッチする正規表現() {
    String regex = "";

    String problemText01 = "http://www.example.jp/sample.html";
    List<String> actualList01 = RegExpUtils.getMatchesStr(problemText01, regex);
    List<String> expectedList01 = Arrays.asList("www.example.jp");

    assertThat(actualList01, is(expectedList01));

    String problemText02 = "http://www.example.jp/with_fragment.html#frag";
    List<String> actualList02 = RegExpUtils.getMatchesStr(problemText02, regex);
    List<String> expectedList02 = Arrays.asList("www.example.jp");

    assertThat(actualList02, is(expectedList02));

    String problemText03 = "http://www.example.jp/images/image.png";
    List<String> actualList03 = RegExpUtils.getMatchesStr(problemText03, regex);
    List<String> expectedList03 = Arrays.asList("www.example.jp");

    assertThat(actualList03, is(expectedList03));

    String problemText04 = "http://www.example.jp/";
    List<String> actualList04 = RegExpUtils.getMatchesStr(problemText04, regex);
    List<String> expectedList04 = Arrays.asList("www.example.jp");

    assertThat(actualList04, is(expectedList04));

    String problemText05 = "http://www.example.jp:8080/with_port.html";
    List<String> actualList05 = RegExpUtils.getMatchesStr(problemText05, regex);
    List<String> expectedList05 = Arrays.asList("www.example.jp:8080");

    assertThat(actualList05, is(expectedList05));

    String problemText06 = "http://www.example.jp/with_param.html?param1=value1";
    List<String> actualList06 = RegExpUtils.getMatchesStr(problemText06, regex);
    List<String> expectedList06 = Arrays.asList("www.example.jp");

    assertThat(actualList06, is(expectedList06));
  }

  /**
   * メールアドレスにマッチする正規表現<br>
   * <br>
   * 条件
   * <ul>
   * <li>「ユーザ名@ホスト名.ドメイン」の形式</li>
   * <li>ユーザ名に使える文字は英大文字、英小文字、数字、「_-.」のみ</li>
   * <li>ユーザ名の頭文字は英大文字、英小文字、数字のいずれかでなければならない</li>
   * <li>ユーザ名の末尾は「.」以外の文字でなければならない</li>
   * <li>ホスト名に使える文字は英大文字、英小文字、数字、「-.」のみ</li>
   * <li>ドメインに使える文字は英大文字、英小文字のみ</li>
   * </ul>
   */
  @Test
  public void メールアドレスにマッチする正規表現() {
    String regex = "";

    assertTrue(RegExpUtils.executeRegExp("taro@sample.jp", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("jiro@sample.co.jp", regex).matches());
    assertTrue(RegExpUtils.executeRegExp("taro-juro@example.co.jp", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("I_Like_Tokyo@example.co.jp", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("Taro=RegularExpression@sample.co.jp", regex).matches());
    assertFalse(RegExpUtils.executeRegExp("_taro-jiro@sample.co.jp", regex).matches());
  }

}
