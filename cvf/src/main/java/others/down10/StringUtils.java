package others.down10;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils
{
  public static String trim(Object obj)
  {
    return ((obj == null) ? "" : obj.toString().trim());
  }

  public static boolean isNull(Object obj)
  {
    return (obj == null);
  }

  public static boolean isEmpty(Object obj)
  {
    if (isNull(obj)) return true;
    return ("".equals(trim(obj)));
  }

  public static String StrIsEmptyReplace(String str, String r)
  {
    if ((isEmpty(str)) || ("null".equals(str)))
      return r;

    return trim(str);
  }

  public static String formatDate(Date date, String formatter)
  {
    if (isNull(date)) return "";
    SimpleDateFormat sdf = new SimpleDateFormat(formatter);
    return sdf.format(date);
  }

  public static String formatDate(Date date)
  {
    return formatDate(date, "yyyy年MM月dd日");
  }

  public static String formatDouble(Double d, String pattern)
  {
    return formatDouble(d, pattern, "");
  }

  public static String formatDouble(Double d, String pattern, String nullReplace)
  {
    if (isNull(d)) return nullReplace;
    DecimalFormat df = new DecimalFormat();
    df.applyPattern(pattern);
    return df.format(d);
  }

  public static String formatDouble(Double d, String pattern, boolean removeZero)
  {
    String _return = formatDouble(d, pattern);
    if (removeZero) {
      if (_return.indexOf(".") < 0)
        return _return;

      do
        _return = _return.substring(0, _return.length() - 1);
      while (_return.endsWith("0"));

      if (_return.endsWith("."))
        return _return.substring(0, _return.length() - 1);

      return _return;
    }

    return _return;
  }

  public static String reverse(String str)
  {
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    return sb.toString();
  }

  public static String toLowerCase(String str)
  {
    return trim(str).toLowerCase();
  }

  public static String toUpperCase(String str)
  {
    return trim(str).toUpperCase();
  }

  public static String urlEncode(String str)
  {
    try
    {
      if (isNull(str)) return "";
      return URLEncoder.encode(URLEncoder.encode(str, "utf-8"), "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace(); }
    return str;
  }

  public static String urlDecode(String str)
  {
    try
    {
      if (isNull(str)) return "";
      return URLDecoder.decode(str, "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace(); }
    return str;
  }
}