package cn.bugstack.chatgpt.api.domain.zsxq.model.vo;

/**
 * @Author lgq
 * @Date 2023/10/16 18:03
 * @PackageName:cn.bugstack.chatgpt.api.domain.zsxq.model.vo
 * @ClassName: Talk
 * @Description: TODO
 * @Version 1.0
 */
public class Talk
{
    private Owner owner;

    private String text;

    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}