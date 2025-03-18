package university.SystemUnit;

public class SystemUnit {
    private String core;
    private int ramSize;
    private int diskSize;
    private String systemId;
    private String ledModel;

    public SystemUnit(String core, int ramSize, int diskSize, String systemId, String ledModel) {
        this.core = core;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.systemId = systemId;
        this.ledModel = ledModel;
    }

    public String getCore() {
        return this.core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public int getRamSize() {
        return this.ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getDiskSize() {
        return this.diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public String getSystemId() {
        return this.systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getLedModel() {
        return this.ledModel;
    }

    public void setLedModel(String ledModel) {
        this.ledModel = ledModel;
    }

    @Override
    public String toString() {
        return String.format(
            "\nComputer Details:\nID: %s\nCore: %s\nLED Model: %s\nRam: %d GB\nDisk Size: %d GB\n", 
            systemId, core, ledModel, ramSize, diskSize
        );
    }
}
