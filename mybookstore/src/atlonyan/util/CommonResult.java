package atlonyan.util;

public class CommonResult {
    private boolean flag;
    private Object resultDate;
    private String message;
    public static CommonResult ok() {
        return new CommonResult().setFlag(true);
    }
    public static CommonResult error(){
        return new CommonResult().setFlag(false);
    }
    public boolean isFlag() {
        return flag;
    }

    public CommonResult setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public Object getResultDate() {
        return resultDate;
    }

    public CommonResult setResultDate(Object resultDate) {
        this.resultDate = resultDate;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "flag=" + flag +
                ", resultDate=" + resultDate +
                ", message='" + message + '\'' +
                '}';
    }
}
