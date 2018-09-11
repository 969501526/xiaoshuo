public class Test {

    public static void main(String[] args){
        String a="<p class=\"otitle\"> （原标题：因接受通俄调查时说谎特朗普前幕僚获判刑 白宫撇清关系） </p>\n" +
                "<p class=\"f_center\"><img alt=\"特朗普前幕僚在通俄门调查说谎获刑 白宫撇清关系\" src=\"http://cms-bucket.nosdn.127.net/catchpic/e/e1/e187be9850f37ee78fccaf5765bece7b.jpg?imageView&amp;thumbnail=550x0\" style=\"border-width: initial; border-style: none; vertical-align: top; max-width: 100%; margin: 0px auto; width: 500px; height: 333px; display: block;\"></p>\n";
       String str= a.replaceAll("p","vier");
       System.out.println(str);
    }
}
