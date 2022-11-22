package org.toyproject.Search;

public class test {
    public static void main(String[] args) {
        String a = "[{\"title\":\"abc\",\"url\":\"www.abc.com\",\"description\":\"this is abc\"},{\"title\":\"def\",\"url\":\"www.def.com\",\"description\":\"this is def\"}]";
        a=a.replace("\"","");
        a=a.replace("[]","");
        System.out.println(a);
    }
}
