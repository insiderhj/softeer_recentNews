package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println("오늘의뉴스는...두구두구");
        System.out.println("------------");
        System.out.println(getNewsTitle());
    }

    static String getNewsTitle() {

        try {
            // 요청을 보낼 URL 생성
            String url = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=1a10ebbd8bc44f20b01a46d586e7e766";
            URL obj = new URL(url);

            // HttpURLConnection을 사용하여 연결 설정
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            // 응답 데이터 읽기
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return parseTitle(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String parseTitle(String jsonString) {
        try {
            // JSON 문자열을 Jackson의 JsonNode로 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // "articles" 배열에서 첫 번째 원소의 "title" 값 가져오기
            JsonNode articlesNode = jsonNode.get("articles");
            if (articlesNode != null && articlesNode.isArray() && articlesNode.size() > 0) {
                JsonNode firstArticleNode = articlesNode.get(0);
                JsonNode titleNode = firstArticleNode.get("title");

                if (titleNode != null) {
                    return titleNode.asText();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // 오류가 발생하거나 필요한 데이터가 없을 경우 null 반환
    }
}