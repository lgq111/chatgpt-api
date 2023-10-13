package cn.bugstack.chatgpt.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ApiTest {
    /**
     *从网站从提取对于的json信息
     */
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        get.addHeader("cookie","zsxq_access_token=3DAA3050-4386-0B67-0BBD-8AD3A6DCF150_4AC54F8ED24F6F47; abtest_env=product; zsxqsessionid=9f6a4eff89ca694628286c10d6d6eee5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585124848884244%22%2C%22first_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiMGRjYzZhZThiZTUtMDNiNzJiMGQ4ZTE0ZWUtMjYwMzFlNTEtMjA3MzYwMC0xOGIwZGNjNmFlOWJhYSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTEyNDg0ODg4NDI0NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585124848884244%22%7D%2C%22%24device_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%7D");
        get.addHeader("Content-Type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/188428441121282/comments");
        post.addHeader("cookie", "zsxq_access_token=3DAA3050-4386-0B67-0BBD-8AD3A6DCF150_4AC54F8ED24F6F47; abtest_env=product; zsxqsessionid=9f6a4eff89ca694628286c10d6d6eee5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585124848884244%22%2C%22first_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiMGRjYzZhZThiZTUtMDNiNzJiMGQ4ZTE0ZWUtMjYwMzFlNTEtMjA3MzYwMC0xOGIwZGNjNmFlOWJhYSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTEyNDg0ODg4NDI0NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585124848884244%22%7D%2C%22%24device_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%7D");
        post.addHeader("Content-Type", "application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"222224444\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
