package org.redcarp.horizon.common.base.domain;
import org.springframework.http.HttpStatus;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @author yangjianfeng
 * @date 2023/12/01
 */
public class Response<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = HttpStatus.OK.value();

    /** 失败 */
    public static final int FAIL = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private int code;

    private String msg;

    private T data;

    private String mdc;

    public static <T> Response<T> ok()
    {
        return restResult(null, SUCCESS, null);
    }

    public static <T> Response<T> ok(T data)
    {
        return restResult(data, SUCCESS, null);
    }

    public static <T> Response<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> Response<T> fail()
    {
        return restResult(null, FAIL, null);
    }

    public static <T> Response<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> Response<T> fail(T data)
    {
        return restResult(data, FAIL, null);
    }

    public static <T> Response<T> fail(T data, String msg)
    {
        return restResult(data, FAIL, msg);
    }

    public static <T> Response<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> Response<T> restResult(T data, int code, String msg)
    {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public static <T> Boolean isError(Response<T> ret)
    {
        return !isSuccess(ret);
    }

    public static <T> Boolean isSuccess(Response<T> ret)
    {
        return Response.SUCCESS == ret.getCode();
    }

    public String getMdc() {
        return mdc;
    }

    public void setMdc(String mdc) {
        this.mdc = mdc;
    }
}
