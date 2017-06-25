package yuan.java.basic.demo.sample.ccs;

/**
 * Created by yuanxin on 17/6/25.
 */
public class Result
{
    String resultCode;

    String resultMsg;

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public String getResultMsg()
    {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg)
    {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Result{");
        sb.append("resultCode='").append(resultCode).append('\'');
        sb.append(", resultMsg='").append(resultMsg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
