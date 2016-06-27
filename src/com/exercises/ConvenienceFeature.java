package com.exercises;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.utils.RegExpUtils;

/**
 * 便利機能の演習
 *
 * 各テストケースの"regex"の値のみを変えて、
 * テストがグリーンとなるようにしてください。
 * regexには複数のメタキャラクターを指定してください。
 *
 */
public class ConvenienceFeature {

  /**
   * １文字以上の文字が"["と"]"に囲まれている部分にマッチする正規表現
   */
  @Test
  public void 便利機能_最短マッチ() {
    String regex = "\\[.*?\\]";

    String problemText = "OneDirectionは[2013年]と[2015年]に来日している。[2016年6月]の段階では、今年は来日はまだ分からない。";

    List<String> matchList = RegExpUtils.getMatchesStr(problemText, regex);

    List<String> expectedList = Arrays.asList("[2013年]", "[2015年]", "[2016年6月]");
    assertThat(expectedList, is(matchList));
  }

  /**
   * キャプチャを1つ使う
   *
   */
  @Test
  public void キャプチャを1つ使う() {
    String regex = "<(\\w+)>.+?</\\1>";

    String problemText = "<p>正規表現</p>は<i>文字列の集合を一つの文字列で表現する方法</i>の一つである。";

    List<String> matchList = RegExpUtils.getMatchesStr(problemText, regex);

    List<String> expectedList = Arrays.asList("<p>正規表現</p>", "<i>文字列の集合を一つの文字列で表現する方法</i>");
    assertThat(expectedList, is(matchList));
  }

  /**
   * 複数のキャプチャを使う
   */
  @Test
  public void 複数のキャプチャを使う() {
    String regex = "<(\\w+)><(\\w+)>.*</\\2></\\1>";

    String problemText01 = "<ul><li>リンゴ</li></ul>";
    assertTrue(RegExpUtils.executeRegExp(problemText01, regex).matches());

    String problemText02 = "<strong><a>Google</a></strong>";
    assertTrue(RegExpUtils.executeRegExp(problemText02, regex).matches());

    String problemText03 = "<p><a>Google</p></a>";
    assertFalse(RegExpUtils.executeRegExp(problemText03, regex).matches());
  }

  /**
   * グループ化とキャプチャを使い分ける
   */
  @Test
  public void グループ化とキャプチャを使い分ける() {
    String regex = "<(\\w+)(?:\\s+[^>*]*)*>.*?</\\1>";

    String problemText = "<b>ACミランの歴代10番</b>には、<font color=\"red\">ルイコスタ</font>や<font color=\"red\">ボバン</font>そして<font color=\"red\">リベラ</font>がいる。";

    List<String> matchList = RegExpUtils.getMatchesStr(problemText, regex);

    List<String> expectedList = Arrays.asList("<b>ACミランの歴代10番</b>"
                                            , "<font color=\"red\">ルイコスタ</font>"
                                            , "<font color=\"red\">ボバン</font>"
                                            , "<font color=\"red\">リベラ</font>");
    assertThat(expectedList, is(matchList));
  }

  /**
   * 先読みを使う
   */
  @Test
  public void 先読みを使う() {
	  String problemText = "apple,orange,grape,mandarin orange,muscat,cherry";

	  String regex = "\\w+(?=,)";

	  List<String> actualList = RegExpUtils.getMatchesStr(problemText, regex);

	  List<String> matcherList = Arrays.asList("apple", "orange", "grape", "orange", "muscat");

	  assertThat(actualList, is(matcherList));
  }

  /**
   * 後読みを使う
   */
  @Test
  public void 後読みを使う() {
	  String problemText = "apple,orange,grape,mandarin orange,muscat,cherry";

	  String regex = "(?<=,)\\w+";

	  List<String> actualList = RegExpUtils.getMatchesStr(problemText, regex);

	  List<String> matcherList = Arrays.asList("orange", "grape", "mandarin", "muscat", "cherry");

	  assertThat(actualList, is(matcherList));
  }

}
