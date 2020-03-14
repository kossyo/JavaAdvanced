package Exercises;

 class Robot {

    private String name;
    private int handlingTime;
    private long timeWhenTookLastProduct;
    private long timeWhenExpectedToBeFree;
    private String productWorkingOn;
    private boolean isFree;

    public Robot(String name, int handlingTime, String productWorkingOn) {
        this.name = name;
        this.handlingTime = handlingTime;
        this.productWorkingOn = productWorkingOn;
        this.isFree= true;
    }


    public void setTimeStartAndEndTime(long timeWhenTookLastProduct) {
        this.timeWhenTookLastProduct = timeWhenTookLastProduct;
        this.timeWhenExpectedToBeFree = timeWhenTookLastProduct + this.getHandlingTime();
    }

    public void setProductWorkingOn(String productWorkingOn) {
        this.productWorkingOn = productWorkingOn;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsFree() {
        return this.isFree;
    }

    public void setIsFree(boolean isFree){
        this.isFree = isFree;
    }

    public long getTimeWhenTookLastProduct() {
        return this.timeWhenTookLastProduct;
    }

    public String getProductWorkingOn() {
        return this.productWorkingOn;
    }

    public int getHandlingTime() {
        return this.handlingTime;
    }

    public void setTimeWhenExpectedToBeFree(long timeWhenExpectedToBeFree) {
        this.timeWhenExpectedToBeFree = timeWhenExpectedToBeFree;
    }

    public long getTimeWhenExpectedToBeFree() {
        return this.timeWhenExpectedToBeFree;
    }
}
