package ecare;

public class complaint{
    String tockenid;
    String devicetyoe;
    String discription;
    String issue;
    String specs;
    complaint(String tockenid, String devicetyoe, String discription, String issue, String specs){
        this.tockenid=tockenid;
        this.devicetyoe=devicetyoe;
        this.discription=discription;
        this.issue=issue;
        this.specs=specs;
    }
    
    public String toString() {
        return "Device Type: "+devicetyoe+"\nDiscription: "+discription+"\nIssue: "+issue+"\nSpecs: "+specs;
    
    }
}
