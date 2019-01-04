package com.lukehatton.side.pokemon.utils;

import com.alibaba.fastjson.JSON;
import com.lukehatton.side.pokemon.entity.PocketMonster;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: JsonGetterUtil
 * Description: 从html页面爬取指定内容的工具类
 * Author: Zhao Li
 * Date: 2019/1/4 10:30
 * History:
 */
public class HtmlGetterUtil {

    private static String sourceUrl = "https://wiki.52poke.com/wiki/%E7%A7%8D%E6%97%8F%E5%80%BC%E5%88%97%E8%A1%A8%EF%BC%88%E7%AC%AC%E4%B8%83%E4%B8%96%E4%BB%A3%EF%BC%89";

    private static String siteUrl = "https://wiki.52poke.com";

    private static List<PocketMonster> monsterList = new ArrayList<>();

    private static String FILE_PATH = "D:\\image\\raceList.json";

    private static String blogName = "guoxiaolongonly";

    /**
     * 获取精灵列表
     */
    public static void getArticleListFromUrl() throws IOException {
        Document doc;

        //获取页面文档
        doc = Jsoup.connect(sourceUrl).userAgent("Chrome/71.0.3578.98").timeout(16000).get();
        if (doc == null) {
            throw new IOException("读取的url错误!");
        }

        //获取要处理的元素
        Elements tr = doc.getElementsByTag("tr");
        Elements bgwhite = doc.getElementsByClass("bgwhite");
        Elements results = tr.stream().filter(e -> {
            for (Element element : bgwhite) {
                if (element.equals(e)) {
                    //还要判断是不是"超级进化"和"阿罗拉的形态"
                    return !e.toString().contains("超级进化") && !e.toString().contains("地区形态");
                }
            }
            return false;
        }).collect(Elements::new, ArrayList::add, Elements::addAll);

        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger temp = new AtomicInteger(0);
        /*
         * 依次获取每个元素的链接页面,获取需要的内容
         */
        results.forEach(e -> {
            String s = e.toString();
            //可以获取id,name,raceValue
            String text = e.text();
            String[] pokemon = text.split(" ");
            //获取链接
            Elements children = e.children();
            Elements select = e.select("a[href]");
            String href = select.get(0).attr("href");
            //使用该链接获取详情页面文档
            try {
                //防止被ban,设置3秒间隔
                Thread.sleep(2000);
                Document detailDocument = Jsoup.connect(siteUrl + href).userAgent("Chrome/71.0.3578.98").timeout(16000).get();
                Elements roundy_bgwhite_fulltable = detailDocument.getElementsByClass("roundy bgwhite fulltable");
                /* ----------------属性----------------- */
                Element attributeFrame = roundy_bgwhite_fulltable.get(1);
                Elements attributes = attributeFrame.select("a[href]");
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < attributes.size(); i++) {
                    Element ele = attributes.get(i);
                    String replace = ele.text().replace("&nbsp;", "");
                    if (i < attributes.size() - 1) {
                        builder.append(replace).append("/");
                    } else {
                        builder.append(replace);
                    }

                }
                String attribute = builder.toString();
                /* ----------------种族捕获度----------------- */
                Element capture = roundy_bgwhite_fulltable.get(9);
                String captureDegree = capture.text().split(" ")[0];

                //转换并保存json
                PocketMonster pocketMonster =
                        new PocketMonster(pokemon[0], pokemon[1], attribute, pokemon[2], pokemon[3], pokemon[4], pokemon[5], pokemon[6], pokemon[7], captureDegree);
                monsterList.add(pocketMonster);
                count.set(count.get() + 1);
                //每加入150个元素,就调用一次json写入方法
                if (count.get() - temp.get() == 150) {
                    temp.set(count.get());
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            savePokemonJson(monsterList,FILE_PATH);
                        }
                    }).start();
                }
                System.out.println("列表元素" + count + "添加完成");

            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        //最后,调用json写入方法,将整个list写入磁盘
        savePokemonJson(monsterList,FILE_PATH);
    }

    /**
     * 将PocketMonster对象转换成json数据保存到磁盘上
     *
     * @param pocketMonsters PocketMonster对象List
     */
    private static void savePokemonJson(List<PocketMonster> pocketMonsters,String filePath) {
        String jsonString = JSON.toJSONString(pocketMonsters);
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("列表保存成功!");
    }

    /**
     * 将json文件中的无效数据清除掉
     */
    public static void cleanJsonFile(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        // size 为字串的长度 ，这里一次性读完
        String str;
        int size = in.available();
        byte[] buffer = new byte[size];
        in.read(buffer);
        in.close();
        str = new String(buffer, StandardCharsets.UTF_8);
        List<PocketMonster> monsterList = JSON.parseArray(str, PocketMonster.class);
        /*
         * 遍历monsterList,将HP是数字的保留并写json文件
         */
        ArrayList<Object> collect = monsterList.stream()
                .filter(e -> StringUtils.isNumeric(e.getHp()))
                .collect(ArrayList::new, ArrayList::add, List::addAll);
        String jsonString = JSON.toJSONString(collect);
        FileWriter writer = new FileWriter(filePath);
        writer.write(jsonString);
        writer.close();
    }

}
