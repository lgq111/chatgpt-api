package cn.bugstack.chatgpt.api.test;

import cn.bugstack.chatgpt.api.domain.ai.IOpenAI;
import cn.bugstack.chatgpt.api.domain.zsxq.IZsxqApi;
import cn.bugstack.chatgpt.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.bugstack.chatgpt.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatgpt-api.groupId}")
    private String groupId;

    @Value("${chatgpt-api.cookie}")
    private String cookie;
    @Value("${chatgpt-api.openAiKey}")
    private String openAiKey;
    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            if(topic!=null) {
                String topicId = topic.getTopic_id();
                String text = topic.getTalk().getText();
                logger.info("topicId：{} text：{}", topicId, text);
                // 回答问题
                if(topic.getTopic_id().equals("188451544188142"))
                {
                    String response = openAI.doChatGPT(text);
                    logger.info("测试结果：{}", response);
                    zsxqApi.answer(groupId, cookie, topicId, response, false);
                }
            }
        }
    }
    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT("帮我写一个java冒泡排序");
        logger.info("测试结果：{}", response);
    }

}
