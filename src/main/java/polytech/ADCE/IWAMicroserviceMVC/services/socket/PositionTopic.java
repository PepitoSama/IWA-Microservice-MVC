package polytech.ADCE.IWAMicroserviceMVC.services.socket;

public class PositionTopic {

    private String content;

    public PositionTopic() {}

    public PositionTopic(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
