package com.kxf.springdemo.result;

/**
 * 状态码，错误码
 */
public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(10000, "成功");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
    public static CodeMsg ACCESS_LIMIT_REACHED = new CodeMsg(500103, "访问太频繁！");


    public static CodeMsg USER_NOT_LOGIN = new CodeMsg(500200, "用户未登录");
    public static CodeMsg TOKEN_INVALID = new CodeMsg(500201, "token无效");
    public static CodeMsg USERNAME_NOT_EXIST = new CodeMsg(500202, "用户名不存在或密码错误");
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(500203, "用户不存在");
    public static CodeMsg OVER_MAX_USER_IMPORT_LIMIT = new CodeMsg(500204, "一次最多导入%s条");
    public static CodeMsg IMPORT_FIELD_FORMAT_ERROR = new CodeMsg(500205, "第%s行%s格式错误");
    public static CodeMsg IMPORT_FIELD_IS_EAMPTY = new CodeMsg(500206, "第%s行%s不能为空");


    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


}
