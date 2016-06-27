package com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils {

  /**
   * 検索対象文字列に対して、<br/>
   * 正規表現を実行したMatcherを返却
   *
   * @param targetStr 検索対象文字列
   * @param regex 正規表現
   * @return 実行結果
   */
  public static Matcher executeRegExp(String targetStr, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(targetStr);
    return matcher;
  }

  /**
   * 一致した文字列のリストを返却
   *
   * @param targetStr 検索対象文字列
   * @param regex 正規表現
   * @return 実行結果
   */
  public static List<String> getMatchesStr(String targetStr, String regex) {
    Matcher matcher = RegExpUtils.executeRegExp(targetStr, regex);

    List<String> matchList = new ArrayList<>();

    while (matcher.find()) {
      matchList.add(matcher.group());
    }

    return matchList;
  }
}
