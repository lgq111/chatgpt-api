package cn.bugstack.chatgpt.api.test;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
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
        get.addHeader("cookie","" + "zsxqsessionid=9f6a4eff89ca694628286c10d6d6eee5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585124848884244%22%2C%22first_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiMGRjYzZhZThiZTUtMDNiNzJiMGQ4ZTE0ZWUtMjYwMzFlNTEtMjA3MzYwMC0xOGIwZGNjNmFlOWJhYSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTEyNDg0ODg4NDI0NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585124848884244%22%7D%2C%22%24device_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%7D; abtest_env=product; zsxq_access_token=85905AA6-3B08-6F66-4255-8D61E5D34A3E_4AC54F8ED24F6F47");
        get.addHeader("Content-Type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/188451544188142/comments");
        post.addHeader("cookie", "zsxqsessionid=9f6a4eff89ca694628286c10d6d6eee5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585124848884244%22%2C%22first_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiMGRjYzZhZThiZTUtMDNiNzJiMGQ4ZTE0ZWUtMjYwMzFlNTEtMjA3MzYwMC0xOGIwZGNjNmFlOWJhYSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjU4NTEyNDg0ODg4NDI0NCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585124848884244%22%7D%2C%22%24device_id%22%3A%2218b0dcc6ae8be5-03b72b0d8e14ee-26031e51-2073600-18b0dcc6ae9baa%22%7D; abtest_env=product; zsxq_access_token=85905AA6-3B08-6F66-4255-8D61E5D34A3E_4AC54F8ED24F6F47");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
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

    /**
     *
     * @throws IOException
     */
    @Test
    public void test_chatGPT() throws IOException {
        String pro = "127.0.0.1";//本机地址
        int pro1 = 7890; //代理端口号
        //创建一个 HttpHost 实例，这样就设置了代理服务器的主机和端口。
        HttpHost httpHost = new HttpHost(pro, pro1);
        //创建一个 RequestConfig 对象，然后使用 setProxy() 方法将代理 httpHost 设置进去。
        RequestConfig build = RequestConfig.custom().setProxy(httpHost).build();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.openai.com/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer sk-cw8Rj9St03qomIj1EAFaT3BlbkFJNyIx0BZknB3YjCS1Xqya111");
        //将 build 配置设置到 post 请求中包括先前指定的代理设置。
        post.setConfig(build);
        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";

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
